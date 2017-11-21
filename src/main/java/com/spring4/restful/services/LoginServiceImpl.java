package com.spring4.restful.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring4.restful.dao.LoginDao;
import com.spring4.restful.model.Employee;
import com.spring4.restful.model.Login;

@Service("loginServices")
public class LoginServiceImpl implements LoginService{

	
	@Autowired
	private LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}


	public Employee isLoginValid(Login login) {
		System.out.println("=====LoginServiceImpl=====>"+login.getUserName());
		return loginDao.isLoginValid(login);
	}

}
