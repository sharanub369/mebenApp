package com.spring4.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.spring4.restful.model.Employee;
import com.spring4.restful.model.Login;
import com.spring4.restful.services.LoginService;
import com.spring4.restful.util.Response;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	private Response response;

	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public Response loginController(@RequestBody Login login) {
		Employee emp = loginService.isLoginValid(login);
		response = new Response();
		if (emp != null) {
			response.setMessage("Success");
			response.setValid(true);
			response.setObject(emp);
		} else {
			response.setMessage("Failure");
			response.setValid(false);
			response.setObject(null);
		}
		return response;

	}
}
