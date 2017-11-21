package com.spring4.restful.dao;

import java.util.List;

import com.spring4.restful.model.Employee;
import com.spring4.restful.model.Login;

public interface LoginDao {
	Employee isLoginValid(Login login);
}
