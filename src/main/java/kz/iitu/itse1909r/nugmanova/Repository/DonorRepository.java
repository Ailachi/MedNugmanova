package kz.iitu.itse1909r.nugmanova.Repository;

import kz.iitu.itse1909r.nugmanova.Database.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
    List<Donor> getAllByBloodType(String bloodType);

//    @Query(value = "SELECT wt.* FROM waitinglist wt " +
//            "INNER JOIN Patient p ON p.patientId = wt.patientId " +
//            "INNER JOIN Donor d ON d.donorId = wt.donorId " +
//            "INNER JOIN MedicalRecord md ON wt.patientId = md.patientId " +
//            "WHERE wt.donorshiptypeid = 1 AND d.bloodType = md.bloodType", nativeQuery = true)
//    void assignBloodDonorsToWaitingList();


    @Query(value = "UPDATE waitinglist SET donorid = ?1 WHERE patientId = ?2 RETURNING donorid", nativeQuery = true)
    List<Integer> updateWaitingListEntriesWithDonors(Integer donorId, Integer patientId);
}
