package kz.iitu.itse1909r.nugmanova.Database;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "MedicalRecord")
@Data
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    @ManyToMany(mappedBy = "records")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Allergy> allergies;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "record")
    private List<Appointment> appointments;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "patientId")
    private Patient patient;

    @Column(name = "bloodType")
    private String bloodType;

    public MedicalRecord(){}

    @Override
    public int hashCode(){
        return 1;
    }
}
