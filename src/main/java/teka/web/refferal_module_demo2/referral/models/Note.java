package teka.backend.refferal_module_demo1.referral.models;

import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "referral_id")
    private Referral referral;

    // Constructors, getters, and setters
}
