package com.mkyong.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.mkyong.model.Customer;

@Repository("JdbcCustomerDAO")
public class JdbcCustomerDAO extends JdbcDaoSupport implements ICustomerDAO {
	
	@Autowired
	public JdbcCustomerDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void insert(Customer customer) {
		String sql = "INSERT INTO CUSTOMER " +
				"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] {
				customer.getCustId(), customer.getName(), customer.getAge()}
		);
	}

	@Override
	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
		 
		List<Map<String, Object>> custList = getJdbcTemplate().queryForList(sql,  new Object[] {custId});
		Customer customer = null;
		for(Map<String, Object> row: custList) {
			customer = new Customer();
			customer.setCustId((Long)(row.get("CUST_ID")));
			customer.setName((String)row.get("NAME"));
			customer.setAge((Long)row.get("AGE"));
		}
		
		return customer;
	}

}