package hydra.project.khatabook.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hydra.project.khatabook.model.Products;
import hydra.project.khatabook.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping("/displayAllProducts")
	public String displayAllProducts(ModelMap model){
		List<Products> products = productService.getAllProducts();
		model.addAttribute("products", products);
		
		return "products.html";
	}
	@GetMapping("/requestAddProduct")
	public String addProduct(ModelMap model) {
		Products product = new Products();
		model.addAttribute("newProduct", product);
		return "addProductForm";
	}
	@PostMapping("/addProduct")
	public String saveProduct(@ModelAttribute("newProduct") Products product) {
		System.out.println("from /addproduct"+product.getCustomer());
		productService.saveProduct(product);
		return "redirect:/product/displayAllProducts";
	}
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id)
	{
		productService.deleteProductById(id);
		return "redirect:/product/displayAllProducts";
		
	}
	
	@GetMapping("/update/{id}")
	public String addProduct(@PathVariable("id") Long id, ModelMap model) {
		Products product = productService.findById(id);
		model.addAttribute("newProduct", product);
		return "addProductForm";
	}
	@GetMapping("/displayProductsToBuy/{cust_id}")
	public String displayProductsToBuy(@PathVariable("cust_id") Long cust_id, ModelMap model) {
		List<Products> products=productService.getAllProducts();
		model.addAttribute("productsToPurchase", products);
		model.addAttribute("cust_id", cust_id);
		return "displayProductsToPurchase.html";
		
	}
	

}
