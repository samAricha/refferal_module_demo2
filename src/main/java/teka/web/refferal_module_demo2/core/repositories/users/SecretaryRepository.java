package teka.web.refferal_module_demo2.repositories.users;


import org.springframework.data.jpa.repository.JpaRepository;
import teka.web.refferal_module_demo2.models.users.Secretary;

public interface SecretaryRepository extends JpaRepository<Secretary, Long>{

}