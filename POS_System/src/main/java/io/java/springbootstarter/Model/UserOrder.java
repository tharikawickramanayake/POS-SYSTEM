package io.java.springbootstarter.Model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_orders")
public class UserOrder {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long userorder_id;

	    @Column(nullable = false)
	    private LocalDateTime orderDate;

	    @Column(nullable = false)
	    private String status;

	    @Column(nullable = false)
	    private BigDecimal totalAmount;

	    @ManyToOne
	    @JoinColumn(name = "customer_id", nullable = false)
	    private Customer customer;  // Many-to-One with Customer

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;  // Many-to-One with User

	    @ManyToOne
	    @JoinColumn(name = "payment_id", nullable = true)
	    private Payment payment;  // Many-to-One with Payment (Optional)

	    @ManyToMany
	    @JoinTable(
	        name = "order_products",
	        joinColumns = @JoinColumn(name = "order_id"),
	        inverseJoinColumns = @JoinColumn(name = "product_id")
	    )
	    private List<Product> products;  // Many-to-Many with Product via Order-Product Join Table

	    @Column(nullable = false)
	    private LocalDateTime createdDate;

	    @Column(nullable = false)
	    private LocalDateTime lastUpdated;

	    // Constructors, Getters, and Setters
	    public UserOrder() {}

	    public UserOrder(LocalDateTime orderDate, String status, BigDecimal totalAmount, Customer customer, User user, Payment payment, List<Product> products) {
	        this.orderDate = orderDate;
	        this.status = status;
	        this.totalAmount = totalAmount;
	        this.customer = customer;
	        this.user = user;
	        this.payment = payment;
	        this.products = products;
	        this.createdDate = LocalDateTime.now();
	        this.lastUpdated = LocalDateTime.now();
	    }

	    public Long getId() {
	        return userorder_id;
	    }

	    public void setId(Long id) {
	        this.userorder_id = userorder_id;
	    }

	    public LocalDateTime getOrderDate() {
	        return orderDate;
	    }

	    public void setOrderDate(LocalDateTime orderDate) {
	        this.orderDate = orderDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public BigDecimal getTotalAmount() {
	        return totalAmount;
	    }

	    public void setTotalAmount(BigDecimal totalAmount) {
	        this.totalAmount = totalAmount;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }

	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }

	    public Payment getPayment() {
	        return payment;
	    }

	    public void setPayment(Payment payment) {
	        this.payment = payment;
	    }

	    public List<Product> getProducts() {
	        return products;
	    }

	    public void setProducts(List<Product> products) {
	        this.products = products;
	    }

	    public LocalDateTime getCreatedDate() {
	        return createdDate;
	    }

	    public void setCreatedDate(LocalDateTime createdDate) {
	        this.createdDate = createdDate;
	    }

	    public LocalDateTime getLastUpdated() {
	        return lastUpdated;
	    }

	    public void setLastUpdated(LocalDateTime lastUpdated) {
	        this.lastUpdated = lastUpdated;
	    }
	}


