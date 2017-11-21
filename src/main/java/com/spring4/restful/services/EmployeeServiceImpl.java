package com.spring4.restful.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring4.restful.dao.EmployeeDao;
import com.spring4.restful.model.Employee;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao empDao;
	
	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	public boolean saveEmployee(Employee employee) {
		return empDao.saveEmployee(employee);
	}

	public List<Employee> getAllEmployees() {
		return empDao.getAllEmployees();
	}

}
