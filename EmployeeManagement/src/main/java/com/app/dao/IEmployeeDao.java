package com.app.dao;

import java.util.List;

import com.app.entity.Address;
import com.app.entity.Employee;

public interface IEmployeeDao {
	

	public Employee getEmpByCredential(int empId, String password);

	public int save(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee getById(int empId);

	public void updateEmp(Employee employee);

	public void deleteEmp(int id);
	
	public Address getAddress(Employee emp);

}
