package com.perficient.CustomerRelationshipExample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
		return customer;
		
	}
	
}
