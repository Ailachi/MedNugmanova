package kz.iitu.itse1909r.nugmanova.Repository;

import kz.iitu.itse1909r.nugmanova.Database.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Integer> {
}
