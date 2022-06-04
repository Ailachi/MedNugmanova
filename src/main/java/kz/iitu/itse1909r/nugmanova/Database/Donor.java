package kz.iitu.itse1909r.nugmanova.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name = "donor")
@Data
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donorId;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "bloodType")
    private String bloodType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donorshipTypeId")
    private DonorshipType type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "donor")
    private List<WaitingList> waitingList;

    @JsonIgnore
    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

    @JsonIgnore
    @CreatedBy
    protected String createdBy;
}
