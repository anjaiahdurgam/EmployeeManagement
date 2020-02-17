package com.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.app.controller.EmployeeController;
import com.app.dao.IEmployeeDao;
import com.app.entity.Address;
import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.util.CommanUtility;

public class EmployeeServiceTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@Mock
	IEmployeeDao iEmployeeDao;

	@Mock
	CommanUtility commanUtility;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	private Employee getEmployeeDetails() throws ParseException {
		Employee emp = new Employee();
		emp.setId(1001);
		emp.setLastName("Anjaiah");
		emp.setEmail("danji506@gmail.com");
		emp.setDesignation("SE");
		emp.setPassowrd(CommanUtility.getPassword());
		emp.setContact("8978685930");
		emp.setStatus(true);
		// emp.setProfilepic(sdfghjk);
		Date dob = new SimpleDateFormat("MM-dd-yyyy").parse("10-12-1993");
		emp.setDob(dob);
		emp.setGender("Male");
		emp.setSalConfigured("IT");

		Address addr = new Address();
		addr.setAddressId(1001);
		addr.setPostalAddr("Dontha poor");
		addr.setStreet("Maggidi");
		addr.setCity("Karim Nagar");
		addr.setState("Telanganna");
		addr.setPinCode("505425");
		emp.setAddress(addr);
		Department dept = new Department();
		dept.setDeptId(1001);
		dept.setDeptName("IT");
		emp.setDepartment(dept);
		return emp;
	}

	@Test
	public void saveTest() throws ParseException {
		Employee emppersist = getEmployeeDetails();
		when(iEmployeeDao.save(emppersist)).thenReturn(emppersist.getId());
		int emp = employeeServiceImpl.save(emppersist);
		assertNotNull(emp);

	}

	private List<Employee> getEmployeeList() throws ParseException {
		List<Employee> empList = new ArrayList<Employee>();

		Employee emp = new Employee();
		emp.setId(1001);
		emp.setLastName("Anjaiah");
		emp.setEmail("danji506@gmail.com");
		emp.setDesignation("SE");
		emp.setPassowrd(CommanUtility.getPassword());
		emp.setContact("8978685930");
		emp.setStatus(true);
		// emp.setProfilepic(sdfghjk);
		Date dob = new SimpleDateFormat("MM-dd-yyyy").parse("10-12-1993");
		emp.setDob(dob);
		emp.setGender("Male");
		emp.setSalConfigured("IT");

		Address addr = new Address();
		addr.setAddressId(1001);
		addr.setPostalAddr("Dontha poor");
		addr.setStreet("Maggidi");
		addr.setCity("Karim Nagar");
		addr.setState("Telanganna");
		addr.setPinCode("505425");
		emp.setAddress(addr);
		Department dept = new Department();
		dept.setDeptId(1001);
		dept.setDeptName("IT");
		emp.setDepartment(dept);

		Employee emp2 = new Employee();
		emp2.setId(1001);
		emp2.setLastName("Anjaiah");
		emp2.setEmail("danji506@gmail.com");
		emp2.setDesignation("SE");
		emp2.setPassowrd(CommanUtility.getPassword());
		emp2.setContact("8978685930");
		emp2.setStatus(true);
		// emp2.setProfilepic(sdfghjk);
		Date dob2 = new SimpleDateFormat("MM-dd-yyyy").parse("10-12-1993");
		emp2.setDob(dob2);
		emp2.setGender("Male");
		emp2.setSalConfigured("IT");

		Address addr2 = new Address();
		addr2.setAddressId(1001);
		addr2.setPostalAddr("Dontha poor");
		addr2.setStreet("Maggidi");
		addr2.setCity("Karim Nagar");
		addr2.setState("Telanganna");
		addr2.setPinCode("505425");
		emp2.setAddress(addr2);
		Department dept2 = new Department();
		dept2.setDeptId(1001);
		dept2.setDeptName("IT");
		emp2.setDepartment(dept2);

		empList.add(emp);
		empList.add(emp2);
		return empList;
	}

	@Test
	public void findAllData() throws ParseException {

		List<Employee> empList = getEmployeeList();

		System.out.println(empList);

		// empList = employeeService.findAllData();
		when(iEmployeeDao.getAllEmployee()).thenReturn(empList);
		List<Employee> model1 = employeeServiceImpl.findAllData();
		assertNotNull(model1);
	}

	@Test
	public void getById() throws ParseException {

		Employee emp = getSingleRecord();
		when(iEmployeeDao.getById(emp.getId())).thenReturn(emp);
		Employee model1 = employeeServiceImpl.getById(emp.getId());
		assertNotNull(model1);
	}

	@SuppressWarnings("unused")
	private Employee getSingleRecord() throws ParseException {
		Employee emp = new Employee();
		emp.setId(1001);
		emp.setLastName("Anjaiah");
		emp.setEmail("danji506@gmail.com");
		emp.setDesignation("SE");
		emp.setPassowrd(CommanUtility.getPassword());
		emp.setContact("8978685930");
		emp.setStatus(true);
		// emp.setProfilepic(sdfghjk);
		Date dob = new SimpleDateFormat("MM-dd-yyyy").parse("10-12-1993");
		emp.setDob(dob);
		emp.setGender("Male");
		emp.setSalConfigured("IT");

		Address addr = new Address();
		addr.setAddressId(1001);
		addr.setPostalAddr("Dontha poor");
		addr.setStreet("Maggidi");
		addr.setCity("Karim Nagar");
		addr.setState("Telanganna");
		addr.setPinCode("505425");
		emp.setAddress(addr);
		Department dept = new Department();
		dept.setDeptId(1001);
		dept.setDeptName("IT");
		emp.setDepartment(dept);
		return emp;
	}

	@Test
	public void update() throws ParseException {

		// iEmployeeDao.updateEmp(employee);

		Employee emp = getEmployeeDetails();
		iEmployeeDao.updateEmp(emp);
		employeeServiceImpl.update(emp);
		assertNotNull(emp);
	}

	/*@Test
	public void delete() throws ParseException {
		// iEmployeeDao.deleteEmp(id);
		Employee emp1 = getSingleRecord();
		((EmployeeServiceTest) iEmployeeDao).delete();
		employeeServiceImpl.delete(emp1.getId());
		String model1 = managerController.deleteEmployee(emp1.getId());
		assertNotNull(emp1);

	}
*/
	public Employee getByCredentisl(int empId, String password) {

		Employee emp = iEmployeeDao.getEmpByCredential(empId, password);

		return emp;
	}

	public Address getAddress(Employee emp) {

		Address address = iEmployeeDao.getAddress(emp);
		return address;
	}
}
