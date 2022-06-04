package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.AOP.LogErrorEntry;
import kz.iitu.itse1909r.nugmanova.Database.*;
import kz.iitu.itse1909r.nugmanova.Repository.*;
import org.hibernate.annotations.OptimisticLocking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.*;

@Service
@LogErrorEntry
public class AdminService {

    Logger log = LoggerFactory.getLogger(this.getClass());
    AdminRepository repo = null;
    DonorRepository donorRepo = null;
    PatientRepository patientRepo = null;
    MedRepository medRepo = null;
    AppointmentRepository appRepo = null;

    @Autowired
    public AdminService(AdminRepository adminRepository, PatientRepository patientRepository,
                        DonorRepository donorRepository, MedRepository medRepository, AppointmentRepository appRepository) {
        repo = adminRepository;
        patientRepo = patientRepository;
        donorRepo = donorRepository;
        medRepo = medRepository;
        appRepo = appRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Admin getAdminByEmail(String email) {
        Admin admin = repo.getAdminByEmail(email);
        if (admin == null) return new Admin();
        return admin;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @CacheEvict(value = "patients", allEntries = true)
    public Integer deletePatientByPatientId(Integer patientId) {
        patientRepo.deleteById(patientId);
        return 1;
    }

    @Transactional(timeout = 10) // in seconds
    @CacheEvict(value = "patients", allEntries = true)
    public Integer addPatient(Patient patient) {
        Patient pt = patientRepo.save(patient);
        if (pt.equals(patient)) return 1;
        else return 0;
    }

    @CacheEvict(value = "patients", allEntries = true)
    public Integer editPatient(Patient patient, Integer patientId) {
        Optional<Patient> pto = patientRepo.findById(patientId);
        if (pto.isPresent()) {
            Patient pt = pto.get();
            if (!patient.getName().isEmpty()) pt.setName(patient.getName());
            if (!patient.getSurname().isEmpty()) pt.setSurname(patient.getSurname());
            if (!patient.getEmail().isEmpty()) pt.setEmail(patient.getEmail());
            if (!patient.getPassword().isEmpty()) pt.setPassword(patient.getPassword());
            patientRepo.save(pt);
            return 1;
        }
        else return 0;
    }

    @Lock(LockModeType.PESSIMISTIC_READ)
    public Patient getPatientByEmailAndPassword(String email, String password) {
        return patientRepo.getPatientByEmailAndPassword(email, password);
    }

    @Transactional(readOnly = true)
    public List<Donor> getAllDonorsByBloodType(String bloodType) {
        List<String> bloodTypes = Arrays.asList("O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-");
        if (bloodTypes.contains(bloodType)) {
            return donorRepo.getAllByBloodType(bloodType);
        }
        log.error("Blood Type does not correspond to a real one. Do you have milk in your veins, pal?");
        return new ArrayList<>();
    }

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}", initialDelayString = "${initialDelay.in.milliseconds}")
    public void assignDonorsToWaitingList() {
        List<MedicalRecord> patientsWithoutDonors = medRepo.getAllPatientsWithoutDonors();
        List<Donor> donors = donorRepo.findAll();
        HashMap<Integer, Integer> patientDonor = new HashMap<>();
        for (MedicalRecord p: patientsWithoutDonors) {
            for (Donor d: donors) {
                if (d.getBloodType().equals(p.getBloodType())) {
                    System.out.println("Donor ID: " + d.getDonorId() +", Patient ID: " + p.getPatient().getPatientId());
                    patientDonor.put(p.getPatient().getPatientId(), d.getDonorId());
                }
            }
        }
        patientDonor.forEach((key, value) -> {
            System.out.println("patient ID: " + key +", Donor ID: " + value);
            donorRepo.updateWaitingListEntriesWithDonors(value, key);
        });
    }

    @Scheduled(fixedRateString = "${fixedDelay.in.milliseconds}", initialDelayString = "${initialDelay.in.milliseconds}")
    public Appointment checkNextAppointment() {
        Appointment appt = appRepo.checkNextAppointment();
        if (appt == null) return new Appointment();
        else return appt;
    }


}
