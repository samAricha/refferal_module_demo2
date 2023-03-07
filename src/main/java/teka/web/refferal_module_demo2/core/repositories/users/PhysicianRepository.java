package teka.web.refferal_module_demo2.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.refferal_module_demo2.models.users.Physician;

public interface PhysicianRepository extends JpaRepository<Physician, Long> {
}
