package com.spring4.restful.services;

import com.spring4.restful.model.Employee;
import com.spring4.restful.model.Login;

public interface LoginService {
	Employee isLoginValid(Login login);
}
