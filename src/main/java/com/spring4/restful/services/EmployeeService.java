package com.spring4.restful.services;

import java.util.List;

import com.spring4.restful.model.Employee;

public interface EmployeeService {
	boolean saveEmployee(Employee employee);
	 List<Employee> getAllEmployees();
}
