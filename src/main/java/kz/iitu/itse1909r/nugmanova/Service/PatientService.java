package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.Patient;
import kz.iitu.itse1909r.nugmanova.Repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PatientService {
    Logger log = LoggerFactory.getLogger(this.getClass());
    PatientRepository repo = null;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        repo = patientRepository;
    }

    @Cacheable("patients")
    public List<Patient> getAllPatients(){
        return repo.findAll();
    }

    public List<Patient> getAllPatientsWithAllergy(Integer allergyId) {
        if (allergyId <= 0) {
            log.error("Allergy ID cannot be zero or below");
            return new ArrayList<>();
        }
        return repo.getAllPatientsWithAllergy(allergyId);
    }

    public List<Patient> getAllByWaitingList() {
        return repo.getAllByWaitingList();
    }

    public Patient getPatientByEmail(String email) {
        Patient patient = repo.getPatientByEmail(email);
        if (patient == null) return new Patient();
        return patient;
    }

}
