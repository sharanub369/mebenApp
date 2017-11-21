package com.spring4.restful.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring4.restful.model.Employee;
import com.spring4.restful.model.Login;

@Repository("loginDao")
@Transactional
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Employee isLoginValid(Login login) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Employee where user_name=:userName and password=:password");
		List employeeList = query.setParameter("userName", login.getUserName())
				.setParameter("password", login.getPassword()).list();
		Employee emp = null;
		for (int i = 0; i < employeeList.size(); i++) {
			emp = (Employee) employeeList.get(i);
		}
		return emp;
	}
}
