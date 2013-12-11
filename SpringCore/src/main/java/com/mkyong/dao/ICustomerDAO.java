package com.mkyong.dao;

import com.mkyong.model.Customer;

public interface ICustomerDAO 
{
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}