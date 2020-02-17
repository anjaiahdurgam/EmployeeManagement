package com.app.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.app.entity.Address;
import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.service.IEmployeeService;
import com.app.util.CommanUtility;

public class ManagerControllerTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@InjectMocks
	private ManagerController managerController;

	@Mock
	IEmployeeService employeeService;

	@Mock
	ModelAndView model;

	@Mock
	CommanUtility commanUtility;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findAllData() throws ParseException {

		List<Employee> empList = getEmployeeList();

		System.out.println(empList);

		// empList = employeeService.findAllData();
		when(employeeService.findAllData()).thenReturn(empList);
		ModelMap map = new ModelMap();
		map.addAttribute("getData", empList);
		when(model.getModelMap()).thenReturn(map);
		when(model.getModelMap().addAttribute("getData", empList)).thenReturn(map);
		ModelAndView model1 = managerController.findAllData();
		// model1.setViewName("manager/viewall");
		// model.getModelMap().addAttribute("getdata", empList);
		assertNotNull(model1);

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
	public void viewEmpDetailsTest() throws ParseException {

		Employee emp = getSingleRecord();
		when(employeeService.getById(emp.getId())).thenReturn(emp);

		ModelMap map = new ModelMap();
		map.addAttribute("manager/viewEmpProfile", emp);
		when(model.getModelMap()).thenReturn(map);
		when(model.getModelMap().addAttribute("userData", emp)).thenReturn(map);
		ModelAndView model1 = managerController.viewEmpDetails(emp.getId());
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
	public void deleteEmployeeTest() throws ParseException {

		Employee emp1 = getSingleRecord();
		employeeService.delete(emp1.getId());
		ModelMap map = new ModelMap();
		map.addAttribute("manager/viewEmpProfile", emp1);
		when(model.getModelMap()).thenReturn(map);
		when(model.getModelMap().addAttribute("userData", emp1)).thenReturn(map);
		String model1 = managerController.deleteEmployee(emp1.getId());
		assertNotNull(model1);
		// return "redirect:/getAllData";
	}

}
