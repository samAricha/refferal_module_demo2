package teka.web.refferal_module_demo2.referral.models;

import jakarta.persistence.*;
import teka.backend.refferal_module_demo1.core.models.core.Hospital;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "referral_id")
    private Referral referral;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

}

