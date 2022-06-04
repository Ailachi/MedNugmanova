package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.Doctor;
import kz.iitu.itse1909r.nugmanova.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DoctorService {

    DoctorRepository repo;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        repo = doctorRepository;
    }

    @Cacheable("doctors")
    @Transactional(noRollbackForClassName = {"NullPointerException"})
    public List<Doctor> getAllDoctors() {
        return repo.findAll();
    }

    @Transactional(noRollbackFor = {RuntimeException.class})
    public List<Doctor> findAllByEmailAndPassword(String email, String password) {
        List<Doctor> doctors = repo.findAllByEmailAndPassword(email, password);
        if (doctors.isEmpty()) return new ArrayList<>();
        else return doctors;
    }

    @Transactional(value = "")
    public List<Doctor> getAllDoctorsWithAppointmentsAfter(LocalDate date) {
        return repo.getAllDoctorsWithAppointmentsAfter(date);
    }


    @Transactional(rollbackFor = {RuntimeException.class})
    public List<Doctor> getAlLSpecializedDoctors(Integer specialtyId) {
        return repo.getAlLSpecializedDoctors(specialtyId);
    }

    @Transactional(rollbackForClassName = {"NullPointerException"})
    public Doctor getDoctorByEmail(String email) {
        Doctor doc = repo.getDoctorByEmail(email);
        if (doc == null) return new Doctor();
        else return doc;
    }
}
