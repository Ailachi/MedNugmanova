package kz.iitu.itse1909r.nugmanova.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Patient")
@Data
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @Column(name = "email")
    @Size(min = 8, max = 255)
    private String email;

    @Column(name = "password")
    @Size(min = 4, max = 255)
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", orphanRemoval = true)
    private List<Appointment> appointments;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", orphanRemoval = true)
    private List<WaitingList> waitingList;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "patient", orphanRemoval = true)
    MedicalRecord record;

    @Override
    public String toString() {
        return "PATIENT INFO: " + this.name + " " + this.surname + ", " + this.email + " " + this.password;
    }

    @Override
    public int hashCode(){
        return 1;
    }
}


