package hydra.project.khatabook.services;

import java.util.List;
import java.util.Set;

import hydra.project.khatabook.model.Customer;
import hydra.project.khatabook.model.Products;

public interface CustomerService {

	List<Customer> getAllCustomers();

	void saveCustomer(Customer customer);

	void deleteCustomerById(Long id);

	Customer findById(Long id);
	
	Set<Products> getAllProducts(Long cust_id);

	void addProduct(Long cust_id, Long prod_id);

	void removeProduct(Long cust_id, Long prod_id);
	

}
