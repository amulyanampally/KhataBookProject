package hydra.project.khatabook.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long id;
	@Column(name="fist_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "contact")
	private int mobile;
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		    		  
		              CascadeType.PERSIST,
		              CascadeType.MERGE,
		              
		          })
	@JoinTable(name = "customer_product", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name="product_id"))
	private Set<Products> products = new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	
	public Set<Products> getProducts() {
		return products;
	}
	
//	  public void addTag(Tag tag) {
//		    this.tags.add(tag);
//		    tag.getTutorials().add(this);
//		  }
//	public void setProducts(Products product) {
//		this.getProducts().add(product);
//		product.getCustomer().add(this);
//	}
	
	public Customer(String firstName, String lastName, int mobile,  List<Products> products) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		
		
	}
	public void setProducts(Products product) {
		this.getProducts().add(product) ;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+  ", products=" + products + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
