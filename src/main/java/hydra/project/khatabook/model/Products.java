package hydra.project.khatabook.model;

import java.sql.Date;
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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "product")
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	public Products(String productName, Date date, int cost, List<Customer> customer) {
		super();
		this.productName = productName;
		this.date = date;
		this.cost = cost;
		
	}
	@Column(name = "product_name")
	private String productName;
	@Column(name="date_of_purchase")
	private Date date;
	@Column(name = "cost")
	private int cost;
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		              CascadeType.PERSIST,
		              CascadeType.MERGE
		          },mappedBy = "products")
	private Set<Customer> customer = new HashSet<>();
	
	
	public Long getId() {
		return id;
	}
	public Set<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.getCustomer().add(customer);
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public Products() {
		super();
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", productName=" + productName + ", date=" + date + ", cost=" + cost + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
