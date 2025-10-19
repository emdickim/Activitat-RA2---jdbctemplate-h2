package com.ra2.jdbctemplate_h2.controllers;

import com.ra2.jdbctemplate_h2.model.Customer;
import com.ra2.jdbctemplate_h2.repository.CustomerRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/jdbctemplate")
public class Ra2Controller {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public String jdbctemp() {
		
		return "hello";
	}
	@PostMapping("/init-db")
	public String initializeDatabase() {
		customerRepository.createTableCustomers();
		customerRepository.insertSampleData();
		return "Base de dades inicialitzada correctament";
	}
	
	@GetMapping("/findAllCustomers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
}