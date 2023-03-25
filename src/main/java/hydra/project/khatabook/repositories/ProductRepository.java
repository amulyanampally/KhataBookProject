package hydra.project.khatabook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import hydra.project.khatabook.model.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{

}
