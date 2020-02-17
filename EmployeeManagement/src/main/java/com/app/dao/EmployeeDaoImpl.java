package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Address;
import com.app.entity.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	SessionFactory sessionFactory;

	public EmployeeDaoImpl() {
	}

	public EmployeeDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Employee getEmpByCredential(int empId, String password) {
		System.out.println(empId);

		/*
		 * // By using HQL Query String
		 * string="from Employee e where e.id=:empId and e.passowrd=:password";
		 * Session session=sessionFactory.getCurrentSession(); Query
		 * query=session.createQuery(string); query.setParameter("id", empId);
		 * query.setParameter("passowrd", password); List list=query.list();
		 * Employee employee=(Employee) list.get(0); return employee;
		 */
		// By Using Criteria
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", empId));
		criteria.add(Restrictions.eq("passowrd", password));
		List<Employee> empList = criteria.list();

		Employee emp = new Employee();
		if (empList.size() > 0) {
			emp = empList.get(0);

		}

		return emp;
	}

	// Save record
	public int save(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(employee);

		employee.getAddress().setEmployee(employee);
		session.save(employee.getAddress());
		// session.save(employee.getDepartment());
		return id;
	}

	// get All Record
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {

		String string = "from Employee e where status=:status";
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			employeeList = sessionFactory.getCurrentSession().createQuery(string)
					.setParameter("status", true).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}

	// Get Single Record By Id
	public Employee getById(int empId) {
		Employee empIds = (Employee) sessionFactory.getCurrentSession().get(Employee.class, empId);
		return empIds;
	}

	// Update Singal record
	public void updateEmp(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
	}

	// Delate Record
	public void deleteEmp(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
		employee.setStatus(false);

		if (session != null) {
			session.update(employee);
		}
	}

	// Get Address data with Respect Employee Class@OneToOne
	// private Employee employee;select * from address_tb where employee_id=1;
	public Address getAddress(Employee emp) {

		String string = "from Address a where a.employee =:emp";
		Query a = sessionFactory.getCurrentSession().createQuery(string);

		a.setParameter("emp", emp);
		Address address = (Address) a.list().get(0);
		return address;

	}

}
