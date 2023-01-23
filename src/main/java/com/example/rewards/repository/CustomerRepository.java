package com.example.rewards.repository;
/*
 * Create a repository CustomerRepository
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rewards.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
   
}
