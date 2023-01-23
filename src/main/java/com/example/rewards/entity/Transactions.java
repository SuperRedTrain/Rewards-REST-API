package com.example.rewards.entity;
/*
 * Create an entity Transactions(id, customer, amount, transactionDate, points, month)
 */

import java.util.Date;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Transient;

@Entity
@Table(name = "transactions")
public class Transactions{	
	@Id
	@GeneratedValue
	private Long id;                   // Transaction Id

	@JsonIgnore
	@ManyToOne
	@JoinColumn                        // Foreign key to customer
	private Customer customer;

	private Double amount;             // Amount of each transaction
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;      // Date of each transaction

	@JsonInclude  
	@Transient                         // Mark a field to be transient for the mapping framework
	private Long points;               // Reward points of each transaction

	@JsonInclude  
	@Transient 
	private Integer month;             // Month of each transactionDate

	public Transactions() {
		super();
	}
	public Transactions(Long id, Customer customer, Double amount, Date date) {
		super();
		this.id = id;
		this.customer = customer;
		this.amount = amount;
		this.transactionDate = date;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	// Calculate Reward Points for each transaction
	public Long getPoints() {
		this.points = 0l;
		
		if (this.amount > 50 && this.amount <= 100) {
			this.points += (this.amount.intValue() - 50) * 1;
			
		} 
		
		if (this.amount > 100) {
			this.points += 50;                                  // 1 point for every dollar spent over $50
			this.points += (this.amount.intValue() - 100) * 2;  // 2 points for every dollar spent over $100
		}
		
		return this.points;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	//Get month of every transaction date
	public Integer getMonth(){
		this.month = -1;

		Calendar cal = Calendar.getInstance();
		cal.setTime(this.transactionDate);
		this.month = cal.get(Calendar.MONTH);

		return this.month;
	}
	
	@Override
	public String toString() {
		return String.format("Transactions [id=%s, customer=%s, amount=%s, transactionDate=%s]", id, customer,
				amount, transactionDate);
	
	}
	
}
