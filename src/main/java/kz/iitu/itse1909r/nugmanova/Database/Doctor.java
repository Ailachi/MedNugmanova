package kz.iitu.itse1909r.nugmanova.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Doctor")
@Data

@NamedQuery(name = "Doctor.getAllDoctorsWithAppointmentsAfter", query = "SELECT d FROM Doctor d INNER JOIN Appointment ap ON d.doctorId = ap.doctor.doctorId WHERE ap.appointDate > ?1")
public class Doctor {

    @JsonIgnore
    transient Logger log = LoggerFactory.getLogger(this.getClass());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialtyId")
    private Specialty specialty;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    private List<Appointment> appointments;


    @PostConstruct
    public void initSession() {
        log.info("Init Doctor session initialized");
        if (this.email.isEmpty() || this.password.isEmpty()) log.error("Cannot save a doctor with null auth values");
    }

    @PreDestroy
    public void destroySession() {
        log.info("Destroy session initialized");
        this.email = null;
        this.password = null;
        this.name = null;
        this.surname = null;
    }

    public Doctor(){};
    public Doctor(String email, String password, String surname, String name) {
        this.surname = surname;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "DOCTOR INFO: " + this.name + " " + this.surname + ", " + this.email + " "
                + this.password + ", " + this.specialty;
    }
}
