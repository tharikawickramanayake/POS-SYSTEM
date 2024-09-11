package io.java.springbootstarter.DTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class UserOrderDTO {


	    private Long id;
	    private LocalDateTime orderDate;
	    private String status;
	    private BigDecimal totalAmount;
	    private Long customerId;
	    private Long userId;
	    private Long paymentId;
	    private List<Long> productIds;
	    private LocalDateTime createdDate;
	    private LocalDateTime lastUpdated;

	    // Constructors, Getters, and Setters
	    public UserOrderDTO() {}

	    public UserOrderDTO(Long id, LocalDateTime orderDate, String status, BigDecimal totalAmount, Long customerId, Long userId, Long paymentId, List<Long> productIds, LocalDateTime createdDate, LocalDateTime lastUpdated) {
	        this.id = id;
	        this.orderDate = orderDate;
	        this.status = status;
	        this.totalAmount = totalAmount;
	        this.customerId = customerId;
	        this.userId = userId;
	        this.paymentId = paymentId;
	        this.productIds = productIds;
	        this.createdDate = createdDate;
	        this.lastUpdated = lastUpdated;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public Long getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(Long paymentId) {
			this.paymentId = paymentId;
		}

		public List<Long> getProductIds() {
			return productIds;
		}

		public void setProductIds(List<Long> productIds) {
			this.productIds = productIds;
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


