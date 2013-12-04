package com.mkyong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.dao.CustomerDAO;

@Service
public class CustomerService {
	@Autowired(required=false)
	CustomerDAO customerDAO;
	
	public CustomerService() {
		System.out.println("In CustomerService constructor");
	}	
	 
	@Override
	public String toString() {
		return "CustomerService [customerDAO=" + customerDAO + "]";
	}
}
