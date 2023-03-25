package hydra.project.khatabook.services;

import java.util.List;


import hydra.project.khatabook.model.Products;

public interface ProductService {

	List<Products> getAllProducts();

	void saveProduct(Products product);

	void deleteProductById(Long id);

	Products findById(Long id);
	
}
