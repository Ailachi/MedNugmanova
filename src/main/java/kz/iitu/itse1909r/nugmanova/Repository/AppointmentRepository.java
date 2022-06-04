package kz.iitu.itse1909r.nugmanova.Repository;

import kz.iitu.itse1909r.nugmanova.Database.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query(value = "SELECT app.* FROM appointment app WHERE app.appointdate > CURRENT_DATE ORDER BY app.appointdate LIMIT 1", nativeQuery = true)
    Appointment checkNextAppointment();
}
