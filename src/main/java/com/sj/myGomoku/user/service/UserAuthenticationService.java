package com.sj.myGomoku.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sj.myGomoku.user.vo.UserDetailsVO;

public class UserAuthenticationService implements UserDetailsService {

	private SqlSessionTemplate sqlSession;
	
	public UserAuthenticationService(SqlSessionTemplate sqlSession) {
		  // TODO Auto-generated constructor stub
		  this.sqlSession = sqlSession;
		 }

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("select");
		Map<String, Object> user = sqlSession.selectOne("user.selectUser", username);
		
		if(user == null) throw new UsernameNotFoundException(username);
		
		List<GrantedAuthority> grantedAuth = new ArrayList<GrantedAuthority>();
		grantedAuth.add(new SimpleGrantedAuthority(user.get("authority").toString()));
		  
		
		return new UserDetailsVO(user.get("username").toString(), user.get("password").toString(), (Integer)user.get("enabled") == 1, true, true, true, grantedAuth, user.get("username").toString());


		
	
	}

}
