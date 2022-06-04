package kz.iitu.itse1909r.nugmanova.Database;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ErrorLog")
@Data
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer errorLogId;

    @Column(name = "origin")
    private String origin;

    @Column(name = "stackTrace")
    private String stackTrace;

    @Column(name = "time")
    private LocalDateTime time;

}
