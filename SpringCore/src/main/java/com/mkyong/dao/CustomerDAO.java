package com.mkyong.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {
	public CustomerDAO() {
		System.out.println("In CustomerDAO constructor");
	}
	
	@Override
	public String toString() {
		return "Hello , This is CustomerDAO";		
	}

}
