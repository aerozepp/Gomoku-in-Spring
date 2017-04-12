package com.sj.myGomoku;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sj.myGomoku.dao.ContentDao;
import com.sj.myGomoku.dao.Dao;
import com.sj.myGomoku.dto.GomokuUserDTO;


@Controller
public class GomokuController {

	/*@Autowired
	private SignupDAO dao;*/

	ContentDao dao;
	
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	public void setDao(ContentDao dao){
		this.dao = dao;
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)

	public String signup(HttpServletRequest req) throws Exception {
		
		System.out.println("signup requested by @Controller");
		
		String username = (String)req.getParameter("username");
		String password = (String)req.getParameter("password");
		
		System.out.println("username: " + username + " password: " + password);
		
		GomokuUserDTO user = new GomokuUserDTO();
		user.setUsername(username);
		user.setPassword(password);
		
		Dao dao =  sqlSession.getMapper(Dao.class);
		dao.signup(user);
				
		return "signup success";
	}

}
