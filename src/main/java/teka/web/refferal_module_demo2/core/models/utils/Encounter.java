package teka.web.refferal_module_demo2.models.utils;

import jakarta.persistence.*;
import lombok.Data;
import teka.web.refferal_module_demo2.models.Hospital;
import teka.web.refferal_module_demo2.models.users.Person;
import teka.web.refferal_module_demo2.models.users.Physician;

@Data
@Entity
@Table(name = "encounter")
public class Encounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Person patient;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "physician_id", nullable = false)
    private Physician physician;
}