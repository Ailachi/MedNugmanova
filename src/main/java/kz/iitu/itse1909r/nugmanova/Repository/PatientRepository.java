package kz.iitu.itse1909r.nugmanova.Repository;

import kz.iitu.itse1909r.nugmanova.Database.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query(value = "SELECT p.* FROM Patient p INNER JOIN medicalrecord mr ON p.patientid = mr.patientid " +
            "INNER JOIN recordallergy ra ON mr.recordid = ra.recordid WHERE allergyid = ?1", nativeQuery = true)
    List<Patient> getAllPatientsWithAllergy(Integer allergyId);

    @Query(value = "SELECT p.* FROM patient p INNER JOIN waitinglist w on p.patientid = w.patientid", nativeQuery = true)
    List<Patient> getAllByWaitingList();

    Patient getPatientByEmailAndPassword(String email, String password);
    Patient getPatientByEmail(String email);
}
