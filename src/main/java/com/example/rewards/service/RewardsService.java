package com.example.rewards.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rewards.entity.Customer;
import com.example.rewards.model.CustomerRewards;
import com.example.rewards.repository.CustomerRepository;

@Service
public class RewardsService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	// test two: model.CustomerRewards
	public CustomerRewards getCustomerRewardsById(Integer customerId){
		Customer customer= customerRepository.findById(customerId).orElse(null);
		CustomerRewards customerRewards = new CustomerRewards();
		// Get Customer Rewards
		if(customer == null)
		{
			customerRewards = null;
		}
		else
		{
			String name = customer.getCustomerName();
			// Get Reward Points per month
			Long[] rewardPerMonthInDesc = customer.getRewardPerMonthInDesc();

			Long lastMonthRewardPoints = rewardPerMonthInDesc[0];	
			Long lastSecondMonthRewardPoints = rewardPerMonthInDesc[1];	
			Long lastThirdMonthRewardPoints = rewardPerMonthInDesc[2];	
			// Get total reward points of three month
			Long totalRewardPoints = lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints;	
			
			customerRewards.setCustomerId(customerId);
			customerRewards.setName(name);
			customerRewards.setTotalRewardPoints(totalRewardPoints);
			customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
			customerRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
			customerRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
		}
		return customerRewards;

	}








   // test one: @Query
/* 	public List<Object[]> getCustomerAll() {
			List<Object[]> customers = customerRepository.getCustomerRewardPoints();
		return customers; 
	}	 */

/* 	public List<Object> getCustomerById(Integer customerId) {

		List<Object> customer = customerRepository.findCustomerById(customerId);
		return customer;
	} */



	// public ResponseEntity<Customer> getCustomerById(Integer customerId) {
	// 	Customer customer = customerRepository.findById(customerId).orElse(null);
	// 	return new ResponseEntity<Customer>(customer, HttpStatus.NOT_FOUND);
	// }

}
