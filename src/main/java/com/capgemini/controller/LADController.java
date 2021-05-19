package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.CustomerLoanRequest;
import com.capgemini.entities.LoanStatus;
import com.capgemini.repository.LoanStatusRepository;
import com.capgemini.service.CustomerLoanRequestImpl;
import com.capgemini.service.ICustomerLoanReportImpl;

@RestController
@RequestMapping("api/lad/")
public class LADController {
	@Autowired
	ICustomerLoanReportImpl icustomerloanreportimpl;
	
	
	
	@GetMapping("/{id}")
	public String checklad(@PathVariable int id) {
		String s1=icustomerloanreportimpl.hello(id);
		return s1;
	}
	
	@GetMapping("/allrecords")
	public List<LoanStatus> allrecords(){
		return icustomerloanreportimpl.findallrecord();
	}
	
	@DeleteMapping("{id}")
	public String deletelad(@PathVariable int id) {
		String s1 = icustomerloanreportimpl.deleteById(id);
		return s1;
		
		}

}