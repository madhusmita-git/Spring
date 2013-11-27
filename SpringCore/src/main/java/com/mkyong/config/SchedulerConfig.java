package com.mkyong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mkyong.core.SchedulerBo;

@Configuration
public class SchedulerConfig {
	
	@Bean(name="scheduler")
	@Scope("prototype")
	public SchedulerBo schedulerBo (){
		return new SchedulerBo();
	}
}
