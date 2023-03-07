package teka.web.refferal_module_demo2.models.users;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "secretary")
public class Secretary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    private String position;

}