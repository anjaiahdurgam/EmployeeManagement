package com.app.service;

import java.util.List;

import com.app.entity.Address;
import com.app.entity.Employee;

public interface IEmployeeService {

	public int save(Employee employeepersistance);

	public List<Employee> findAllData();

	public Employee getById(int id);

	public void update(Employee employeepersistance);

	public void delete(int id);

	public Employee getByCredentisl(int empId, String password);

	public Address getAddress(Employee emp);
}
