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
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("from saveCustomer"+customer.getProducts());
		customerRepository.save(customer);
		
	}

	@Override
	public void deleteCustomerById(Long id) {
		// TODO Auto-generated method stub
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isPresent()) {
			Customer customer=optional.get();
			Set<Products> products=customer.getProducts();
			for(Products product:products) {
				product.getCustomer().remove(customer);
			}
		}
		else {
			throw new RuntimeException("no customer with that id:"+id);
		}
		customerRepository.deleteById(id);
		
	}

	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
				Optional<Customer> optional = customerRepository.findById(id);
				Customer customer = null;
				if(optional.isPresent())
				{
					customer=optional.get();
				}
				else {
					throw new RuntimeException("customer not found with id "+id);
				}
			return customer;
			}

	@Override
	public Set<Products> getAllProducts(Long cust_id) {
		Optional<Customer> customer = customerRepository.findById(cust_id);
		Set<Products> products=null;
		if(customer.isPresent())
		{
			System.out.print(customer.get().getProducts());
			products=customer.get().getProducts();
		}
		else {
			throw new RuntimeException();
		}
		return products;
	}

	@Override
	public void addProduct(Long cust_id, Long prod_id) {
		// TODO Auto-generated method stub
		Optional<Customer> customer= customerRepository.findById(cust_id);
		Optional<Products> product= productRepository.findById(prod_id);
		System.out.println("from impl");
		if(customer.isPresent() && product.isPresent()) {
//			Customer customers=customer.get();
//			Products products = product.get();
//			customers.getProducts().remove(products);
//			products.getCustomer().remove(customers);
//			Customer c = customerRepository.save(customers);
//			Products p = productRepository.save(products);
			Customer customers=customer.get();
			Products products = product.get();
			customers.getProducts().add(products);
//			product.get().setCustomer(customer.get());
			products.getCustomer().add(customers);
			
			Customer c=customerRepository.save(customers);
			Products p=productRepository.save(products);
			
		}
		
		System.out.println(customer.get().getProducts());
		System.out.println(product.get().getCustomer());
		
	}

	@Override
	public void removeProduct(Long cust_id, Long prod_id) {
		// TODO Auto-generated method stub
		Optional<Customer> customer= customerRepository.findById(cust_id);
		Optional<Products> product= productRepository.findById(prod_id);
		System.out.println("from impl");
		if(customer.isPresent() && product.isPresent()) {
			
			Customer customers=customer.get();
			Products products = product.get();
			customers.getProducts().remove(products);
			products.getCustomer().remove(customers);
			Customer c = customerRepository.save(customers);
			Products p = productRepository.save(products);
//			customer.get().setProducts(product.get());
//			product.get().setCustomer(customer.get());
//			Customer customers=customer.get();
//			Products products = product.get();
//			Customer c=customerRepository.save(customers);
//			Products p=productRepository.save(products);
			
		}
		
		System.out.println(customer.get().getProducts());
		System.out.println(product.get().getCustomer());
	}
	
}
