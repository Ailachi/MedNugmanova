package kz.iitu.itse1909r.nugmanova.Database;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "specialty")
@Data
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specialtyId;

    @Column(name = "specName")
    private String specName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty")
    private List<Doctor> doctors;

    public Specialty(){};

    @Override
    public String toString() {
        return "SPECIALTY INFO: " + this.specName;
    }
}
