package com.spring4.restful.dao;

import java.util.List;

import com.spring4.restful.model.Employee;

public interface EmployeeDao {
	
	boolean saveEmployee(Employee employee);

	List<Employee> getAllEmployees();
}
