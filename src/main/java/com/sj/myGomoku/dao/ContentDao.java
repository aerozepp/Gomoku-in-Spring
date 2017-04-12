package com.sj.myGomoku.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sj.myGomoku.dto.GomokuUserDTO;

public class ContentDao implements Dao {
	
	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template){
		this.template = template;
	}

	@Override
	public void signup(GomokuUserDTO user) {
		// TODO Auto-generated method stub
		System.out.println("signup");
	}
	

}
