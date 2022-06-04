package kz.iitu.itse1909r.nugmanova.Database;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "waitingList")
@Data
public class WaitingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer waitingListId;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId")
    private Patient patient;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donorId")
    private Donor donor;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donorshipTypeId")
    private DonorshipType type;
}
