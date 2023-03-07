package teka.web.refferal_module_demo2.repositories.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.refferal_module_demo2.models.utils.Observation;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
}
