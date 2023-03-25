package hydra.project.khatabook.controllers;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hydra.project.khatabook.model.Customer;
import hydra.project.khatabook.model.Products;
import hydra.project.khatabook.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@GetMapping("/displayAllCustomers")
	public String displayAllCustomers(ModelMap model){
		List<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customers", customers);
		
		return "customers.html";
	}
	@GetMapping("/requestAddCustomer")
	public String addCustomer(ModelMap model) {
		Customer customer = new Customer();
		Set<Products> products = customer.getProducts();
		model.addAttribute("newCustomer", customer);
		return "addCustomerForm";
	}
	@PostMapping("/addCustomer")
	public String saveCustomer(@ModelAttribute("newCustomer") Customer customer) {
		System.out.println(customer+"from post");
		customerService.saveCustomer(customer);
		return "redirect:/customer/displayAllCustomers";
	}
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") Long id)
	{
		customerService.deleteCustomerById(id);
		return "redirect:/customer/displayAllCustomers";
		
	}
	
//	@GetMapping("/update/{id}")
//	public String addCustomer(@PathVariable("id") Long id, ModelMap model) {
//		Customer customer = customerService.findById(id);
//		Set<Products> products = customer.getProducts();
//		System.out.println(customer+"from addCustomer function");
//		model.addAttribute("newCustomer", customer);
//		return "addCustomerForm";
//	}
	@GetMapping("/viewPurchasedProducts/{id}")
	public String viewPurchasedProducts(@PathVariable("id") Long cust_id, ModelMap model) {
		System.out.println("from viewPurchasedProducts mapping"+cust_id);
		Set<Products> products=customerService.getAllProducts(cust_id);
		System.out.println(products+"from last");
		model.addAttribute("products", products);
		model.addAttribute("cust_id",cust_id);
		return "productsPurchased.html";
	}
	
	@GetMapping("/productPurchased/{cust_id}/{product_id}")
	public String addProduct(@PathVariable("cust_id") Long cust_id, @PathVariable("product_id") Long prod_id) {
		System.out.print("cust_id and prod_id"+cust_id+" "+prod_id);
		customerService.addProduct(cust_id, prod_id);
		return "redirect:/customer/viewPurchasedProducts/{cust_id}";
		//return "donePurchasing/{cust_id}";
		//return "productsPurchased.html";
	}
	@GetMapping("/removeProduct/{cust_id}/{product_id}")
	public String removeProduct(@PathVariable("cust_id") Long cust_id, @PathVariable("product_id") Long prod_id)
	{
	customerService.removeProduct(cust_id,prod_id);
	return "redirect:/customer/viewPurchasedProducts/{cust_id}";
}
}
