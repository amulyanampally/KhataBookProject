package hydra.project.khatabook.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hydra.project.khatabook.model.Customer;
import hydra.project.khatabook.model.Products;
import hydra.project.khatabook.repositories.CustomerRepository;
import hydra.project.khatabook.repositories.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public void saveProduct(Products product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		
	}

	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub

		Optional<Products> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Products product=optional.get();
			Set<Customer> customers=product.getCustomer();
			for(Customer customer:customers )
			{
				customer.getProducts().remove(product);
			}
		}
		else {
				throw new RuntimeException("no product with that id:"+id);
			}
		
		
		productRepository.deleteById(id);
		
	}

	@Override
	public Products findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Products> optional = productRepository.findById(id);
		Products product = null;
		if(optional.isPresent())
		{
			product=optional.get();
		}
		else {
			throw new RuntimeException("product not found with id "+id);
		}
	return product;
	}

	
}
