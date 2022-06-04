package kz.iitu.itse1909r.nugmanova.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Allergy")
@Data
public class Allergy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer allergyId;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "RecordAllergy", joinColumns = { @JoinColumn(name = "recordId")},
            inverseJoinColumns = {@JoinColumn(name = "allergyId")})
    private List<MedicalRecord> records;
}
