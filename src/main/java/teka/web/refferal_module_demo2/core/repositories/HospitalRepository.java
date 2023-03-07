package teka.web.refferal_module_demo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.refferal_module_demo2.models.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
