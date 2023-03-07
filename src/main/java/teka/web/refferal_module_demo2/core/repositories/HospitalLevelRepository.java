package teka.web.refferal_module_demo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.refferal_module_demo2.models.HospitalLevel;


public interface HospitalLevelRepository extends JpaRepository<HospitalLevel, Long> {
}
