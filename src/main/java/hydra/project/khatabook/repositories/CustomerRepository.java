package hydra.project.khatabook.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import hydra.project.khatabook.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
