package com.example.rewards.controller;
/*
 * Create a web controller for the rewards application
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.rewards.exceptions.CustomerIdNotFoundException;
import com.example.rewards.model.CustomerRewards;
import com.example.rewards.service.RewardsService;
import org.springframework.http.MediaType;


@RestController
public class RewardsController {
	
	@Autowired
	private RewardsService rewardsService;    // Inject RewardsService
		
	@GetMapping(value = "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerRewards> getRewardsByCustomerId(@PathVariable Integer id) {
		CustomerRewards customerRewards = rewardsService.getCustomerRewardsById(id);
		if(customerRewards == null)  
		{     // Throw an exception if the customerRewards can not be found by the customerId
			throw new CustomerIdNotFoundException();
		}
		return new ResponseEntity<CustomerRewards>(customerRewards, HttpStatus.OK);
	}
	
}
