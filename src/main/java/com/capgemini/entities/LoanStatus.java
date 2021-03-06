package com.capgemini.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class LoanStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statusid;
	private double customerrefid;
	private String customerloantype;
	private double loanamount;
	private double emi;

}