package teka.web.refferal_module_demo2.repositories.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.refferal_module_demo2.models.utils.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Long> {
}
