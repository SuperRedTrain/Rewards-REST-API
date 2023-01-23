package com.example.rewards.entity;
/*
 * Create an entity Customer(id, customerName, rewardPoints, rewardPerMonthInDesc, transactions)
 */

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue
	private Integer id;                      // Customer Id
	private String customerName;             // Customer Name

	@JsonInclude
	@Transient
	private Long rewardPoints;               // Total Reward Points

	@JsonInclude
	@Transient
	private Long[] rewardPerMonthInDesc;     // Reward Points per month 

	@OneToMany(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Transactions> transactions;  // Transactions of a customer

	
	public Customer() {
		super();
	}
	public Customer(Integer id, String customerName) {
		super();
		this.id = id;
		this.customerName = customerName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setRewardPoints(Long rewardPoints){
		this.rewardPoints = rewardPoints;
	}
	public Set<Transactions> getTransactions() {
		return transactions;
	} 
 	public void setTransactions(Set<Transactions> transactions) {
		this.transactions = transactions;
	}
	// Calculate Reward Points per month
	public Long[] getRewardPerMonthInDesc(){
		rewardPerMonthInDesc = new Long[3];   

		rewardPerMonthInDesc[0] = 0L;
		rewardPerMonthInDesc[1] = 0L;
		rewardPerMonthInDesc[2] = 0L;

		if (transactions == null || transactions.isEmpty()) return rewardPerMonthInDesc;
		// Calculate the Last/secondLast/thirdLast month
		Integer[] lastThreeMonthList = new Integer[3];			
		// Find the latest month
		lastThreeMonthList[0] = transactions.stream().sorted((a,b) -> b.getTransactionDate().compareTo(a.getTransactionDate()))
					.findFirst().get().getMonth();			
		// Calculate the second/third last month 
		if(lastThreeMonthList[0] -1 == 0){
			lastThreeMonthList[1] = lastThreeMonthList[0] - 1;
			lastThreeMonthList[2] = 10 + lastThreeMonthList[0];
		} else if (lastThreeMonthList[0] == 0){
			lastThreeMonthList[1] = 11 + lastThreeMonthList[0];
			lastThreeMonthList[2] = 10 + lastThreeMonthList[0];
		} else {
			lastThreeMonthList[1] = lastThreeMonthList[0] - 1;
			lastThreeMonthList[2] = lastThreeMonthList[0] - 2;
		}

		// Calculate the rewards per month
		for(int i=0; i<3; i++){
			Integer month = lastThreeMonthList[i];
			rewardPerMonthInDesc[i] = transactions.stream().filter(x -> x.getMonth() == month).map(
				x -> x.getPoints().intValue()).reduce(
					0, (a,b) -> a + b).longValue();
		} 			
		return rewardPerMonthInDesc;
	}
	// Calculate all reward points of a customer
	public Long getRewardPoints() {
		if (transactions == null || transactions.isEmpty()) return 0l;
		
		return transactions.stream().map(x -> x.getPoints().intValue()).reduce(0, (a,b) -> a + b).longValue();	
	}
	
}

