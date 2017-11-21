package com.spring4.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring4.restful.model.Employee;
import com.spring4.restful.services.EmployeeService;
import com.spring4.restful.util.Response;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	Response response;

	public void setEmpService(EmployeeService empService) {
		this.empService = empService;
	}

	@RequestMapping("/saveEmp")
	@ResponseBody
	public Employee saveEmployee(@RequestBody Employee emp) {
		boolean status = empService.saveEmployee(emp);
		return emp;
	}

	@RequestMapping("/getEmployees")
	@ResponseBody
	public Response getAllEmployees() {
		response = new Response();
		List<Employee> employees = empService.getAllEmployees();
		if (!employees.isEmpty()) {
			response.setMessage("Success");
			response.setValid(true);
			response.setObject(employees);
		} else {
			response.setMessage("Failure");
			response.setValid(false);
			response.setObject(null);
		}
		
		return response;
	}
}
