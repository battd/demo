package com.trades.processor.utils;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class ProcessorDAO {
	
	public static String JDBC_URL = "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=Securities;integratedSecurity=true";
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;	
	
	public ProcessorDAO(DataSource dataSource) {
	    this.dataSource = dataSource;
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void getBooks()
	{		    
			List<Map<String,Object>> returnMap = jdbcTemplate.queryForList("exec getBooks");
			System.out.println("HHHHHHH");
			System.out.println(returnMap);			
	}
		
}


