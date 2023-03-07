package teka.web.refferal_module_demo2.referral.models;

import jakarta.persistence.*;
import teka.backend.refferal_module_demo1.core.models.core.Hospital;
import teka.backend.refferal_module_demo1.core.models.core.Patient;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "referrals")
public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "hospital_a_id")
    private Hospital hospitalA;

    @ManyToOne
    @JoinColumn(name = "hospital_b_id")
    private Hospital hospitalB;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "referral", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}

