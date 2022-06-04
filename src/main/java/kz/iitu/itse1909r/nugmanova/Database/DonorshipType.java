package kz.iitu.itse1909r.nugmanova.Database;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "donorshipType")
@Data
public class DonorshipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donorshipTypeId;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "type")
    private Donor donor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    private List<WaitingList> waitingList;
}
