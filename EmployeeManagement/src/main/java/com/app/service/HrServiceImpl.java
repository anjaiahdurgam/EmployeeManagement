package com.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IHrDAO;
import com.app.entity.Address;
import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.entity.Hr;

@Service
public class HrServiceImpl implements IHrService {
	@Autowired
	private IHrDAO iHrDAO;

	public int save(Hr hrPersistance) {
		return 0;
	}

	public List<Hr> findByAll() {
		List<Hr> list = iHrDAO.findAllDetails();
		return list;
	}

	public Hr getById(int id) {
		return null;
	}

	public Hr update(Hr hr) {

		return null;
	}

	public void delete(int id) {

	}

	public void testData(Hr hr) {

		hr = new Hr();
		// hr.setHrId(1001);
		hr.setFirstName("anjaiah_3");
		hr.setLastName("durgam");
		hr.setGender("FeMale");
		hr.setDesignation("Hr");
		hr.setSalary(60000);
		hr.setDob(new Date());
		hr.setNation("india");
		hr.setLocation("pune");
		hr.setPassword("1245");
		hr.setEmail("d1anji506@gmail.com");
		Address add1 = new Address();
		// add1.setAddressId(1001);
		add1.setCity("donthapoor");
		add1.setPinCode("505425");
		add1.setPostalAddr("dharmapuri");
		add1.setState("TnG");
		add1.setStreet("TNG");

		hr.setAddress(add1);
		iHrDAO.testData(hr);
	}
	/*
	 * public Employee getByCredentisl(int empId, String password) {
	 * 
	 * Employee emp = iEmployeeDao.getEmpByCredential(empId, password);
	 * 
	 * return emp; }
	 */

	public Hr getHrCred(long hrId, String password) {
		Hr hr = iHrDAO.getHrCred(hrId, password);
		return hr;
	}
}
