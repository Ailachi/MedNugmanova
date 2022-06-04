package kz.iitu.itse1909r.nugmanova.Repository;

import kz.iitu.itse1909r.nugmanova.Database.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedRepository extends JpaRepository<MedicalRecord, Integer> {

    @Query(value = "SELECT md.* FROM medicalrecord md INNER JOIN waitinglist wt " +
            "ON md.patientId = wt.patientid WHERE donorid is NULL", nativeQuery = true)
    List<MedicalRecord> getAllPatientsWithoutDonors();
}
