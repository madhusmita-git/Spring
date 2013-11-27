package com.mkyong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mkyong.core.CustomerBo;

@Configuration
public class CustomerConfig {
	
	@Bean(name="customer")
	@Scope("singleton")
	public CustomerBo customerBo(){
		return new CustomerBo();
	}
}
