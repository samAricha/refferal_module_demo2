package teka.web.refferal_module_demo2.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.refferal_module_demo2.models.users.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
