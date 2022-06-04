package kz.iitu.itse1909r.nugmanova.Repository;

import kz.iitu.itse1909r.nugmanova.Database.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAllByEmailAndPassword(String email, String password);
    List<Doctor> getAllDoctorsWithAppointmentsAfter(LocalDate date);
    @Query("SELECT d FROM #{#entityName} d WHERE d.specialty.specialtyId = ?1")
    List<Doctor> getAlLSpecializedDoctors(Integer specialtyId);

    Doctor getDoctorByEmail(String email);
    Doctor findDoctorByEmail(String email);


}
