package com.spring4.restful.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring4.restful.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveEmployee(Employee employee) {
		try {
			sessionFactory.getCurrentSession().persist(employee);
		} catch (Exception exp) {
			exp.printStackTrace();
			return false;
		}
		return true;
	}


	public List<Employee> getAllEmployees() {
		Query query = sessionFactory.getCurrentSession().createQuery("From Employee");
		List<Employee> employees = query.list();
		if (employees.isEmpty()) {
			return null;
		}
		return employees;
	}

}
