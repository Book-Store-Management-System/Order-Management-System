package com.cg.iter.bookorder.dto;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "order_info")
public class BookOrderEntity {

	/** Declaring all the required variables for the Bookorder Entity */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long orderId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	private String orderBy;
	private int orderbookcopies;
	private int totalAmount;
	private String paymentMethod;
	private String orderStatus;
	private int bookRate;

	public BookOrderEntity(Long orderId, Date orderDate, String orderBy, int orderbookcopies, int totalAmount,
			String paymentMethod, String orderStatus, int bookRate) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderBy = orderBy;
		this.orderbookcopies = orderbookcopies;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
		this.bookRate = bookRate;

	}

	public int getBookRate() {
		return bookRate;
	}

	public void setBookRate(int bookRate) {
		this.bookRate = bookRate;
	}

	public BookOrderEntity() {
		super();
		
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getOrderbookcopies() {
		return orderbookcopies;
	}

	public void setOrderbookcopies(int orderbookcopies) {
		this.orderbookcopies = orderbookcopies;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "BookOrderEntity [orderId=" + orderId + ", OrderDate=" + orderDate + ", orderBy=" + orderBy
				+ ", orderbookcopies=" + orderbookcopies + ", TotalAmount=" + totalAmount + ", PaymentMethod="
				+ paymentMethod + ", orderStatus=" + orderStatus + "]";
	}

}
