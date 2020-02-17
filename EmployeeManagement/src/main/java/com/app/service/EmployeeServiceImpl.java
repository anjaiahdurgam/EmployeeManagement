package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IEmployeeDao;
import com.app.entity.Address;
import com.app.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	IEmployeeDao iEmployeeDao;

	public int save(Employee employeepersistance) {
		int id = iEmployeeDao.save(employeepersistance);

		return id;
	}

	public List<Employee> findAllData() {
		List<Employee> emp = iEmployeeDao.getAllEmployee();
		return emp;
	}

	public Employee getById(int id) {
		Employee employee = iEmployeeDao.getById(id);

		return employee;
	}

	public void update(Employee employee) {

		iEmployeeDao.updateEmp(employee);
	}

	public void delete(int id) {
		iEmployeeDao.deleteEmp(id);

	}

	

	public Employee getByCredentisl(int empId, String password) {

		Employee emp = iEmployeeDao.getEmpByCredential(empId, password);

		return emp;
	}

	public Address getAddress(Employee emp) {

		Address address = iEmployeeDao.getAddress(emp);
		return address;
	}

}
