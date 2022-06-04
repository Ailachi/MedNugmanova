package kz.iitu.itse1909r.nugmanova.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "appointment")
@Data
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId")
    private Patient patient;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @NotNull
    @Size(min = 10, max = 255)
    @Column(name = "prescription")
    private String prescription;

    @NotNull
    @Size(min = 10, max = 255)
    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "appointdate")
    private LocalDate appointDate;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recordId")
    private MedicalRecord record;

    @Override
    public String toString() {
        return "APPOINTMENT INFO: " + this.appointDate + " DOCTOR: " + this.doctor.getName() + " " + this.doctor.getSurname()
                + ", PATIENT: " + this.patient.getName() + " " + this.patient.getSurname();
    }
}
