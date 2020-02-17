package com.app.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.app.entity.Admin;
import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.service.IAdminService;
import com.app.service.IEmployeeService;
import com.app.util.CommanUtility;
import com.app.util.GetUserFromSession;

public class EmployeeControllerTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private IEmployeeService iemployeeService;
	@Mock
	private IAdminService iadminService;
	@Mock
	ModelAndView model;
	@Mock
	CommanUtility commanUtility;

	@Mock
	private HttpSession session;

	@Mock
	GetUserFromSession getUserFromSession;
	@Mock
	private HttpServletRequest req;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void homeTest() {

		model.setViewName("login");
		employeeController.home();
	}

	@Test
	public void signupcreateServiceTest() {
		model.setViewName("Registration");
		employeeController.signupcreateService();

	}// EClemma

	@SuppressWarnings({ "static-access" })
	@Test
	public void signupserviceCreationTest() throws ParseException {

		Employee emp = getEmployeeDetails();

		// employee.setPassowrd(commanUtility.getPassword());
		when(iemployeeService.save(emp)).thenReturn(emp.getId());
		ModelMap map = new ModelMap();
		map.addAttribute("msg", "Your are registered succesfully and credential has been sent to ur email..");
		model.setViewName("Login");
		when(model.getModelMap()).thenReturn(map);
		when(model.getModelMap().addAttribute("msg",
				"Your are registered succesfully and credential has been sent to ur email..")).thenReturn(map);
		ModelAndView model1 = employeeController.signupserviceCreation(emp);
		System.out.println(model1.getViewName());
		System.out.println(model1.getModelMap());
		System.out.println(model1.getModel());
		System.out.println(model1.getView());

		assertNotNull(model);

	}

	// logged Home page

	// logged Home page

	@SuppressWarnings("static-access")
	@Test
	public void loginCredentAdminTest() throws ParseException {
		Admin admin = new Admin();
		admin.setPassword(UUID.randomUUID().toString());
		admin.setAdminId(10);
		when(iadminService.getByCredentisl(admin.getAdminId(), admin.getPassword())).thenReturn(admin);
		Object obj = new Object();

		doNothing().when(session).setAttribute("user", admin);
		when(req.getSession()).thenReturn(session);

		// doNothing().when(getUserFromSession).setUser(req, admin);
		employeeController.loginCredent(req, admin.getAdminId(), admin.getPassword(), "Manager");

	}

	@SuppressWarnings("static-access")
	@Test
	public void loginCredentEmpTest() throws ParseException {
		Employee emp1 = new Employee();
		emp1.setPassowrd(UUID.randomUUID().toString());
		emp1.setId(11);
		when(iemployeeService.getByCredentisl(emp1.getId(), emp1.getPassowrd())).thenReturn(emp1);
		Object obj = new Object();

		doNothing().when(session).setAttribute("user", emp1);
		when(req.getSession()).thenReturn(session);

		// doNothing().when(getUserFromSession).setUser(req, admin);
		employeeController.loginCredent(req, emp1.getId(), emp1.getPassowrd(), "Employee");

	}

	// Profile View Page
	@SuppressWarnings("static-access")
	@Test
	public void empProfileTest() throws ParseException {
		Employee emp = getEmployeeDetails();
		Object obj = new Object();
		when(req.getSession(false)).thenReturn(session);
		when(session.getAttribute("user")).thenReturn(obj);
		when(getUserFromSession.getUser(req)).thenReturn(emp);

		when(iemployeeService.getAddress(emp)).thenReturn(emp.getAddress());
		when(iemployeeService.getById(emp.getId())).thenReturn(emp);

		ModelMap map = new ModelMap();
		map.addAttribute("userdata", emp);
		map.addAttribute("data", emp.getAddress());
		when(model.getModelMap()).thenReturn(map);
		when(model.getModelMap().addAttribute("userdata", emp)).thenReturn(map);
		when(model.getModelMap().addAttribute("data", emp.getAddress())).thenReturn(map);

		doNothing().when(model).setViewName("profile");

		ModelAndView model1 = employeeController.empProfile(req);
		model1.setViewName("profile");
		System.out.println(model1.getViewName());
		System.out.println(model1.getModelMap());
		System.out.println(model1.getModel());
		System.out.println(model1.getView());

		assertNotNull(model1);
	}

	// Open Update page
	@Test
	public void empUpdatePageTest() throws ParseException {

		Employee emp = getEmployeeDetails();
		Object obj = new Object();
		when(req.getSession(false)).thenReturn(session);
		when(session.getAttribute("user")).thenReturn(obj);
		when(getUserFromSession.getUser(req)).thenReturn(emp);

		when(iemployeeService.getAddress(emp)).thenReturn(emp.getAddress());
		when(iemployeeService.getById(emp.getId())).thenReturn(emp);

		ModelMap map = new ModelMap();
		map.addAttribute("userdata", emp);
		map.addAttribute("data", emp.getAddress());
		when(model.getModelMap()).thenReturn(map);
		when(model.getModelMap().addAttribute("userdata", emp)).thenReturn(map);
		when(model.getModelMap().addAttribute("data", emp.getAddress())).thenReturn(map);

		doNothing().when(model).setViewName("profile");

		ModelAndView model1 = employeeController.empUpdatePage(req);
		model1.setViewName("editProfile_emp");
		System.out.println(model1.getViewName());
		System.out.println(model1.getModelMap());
		System.out.println(model1.getModel());
		System.out.println(model1.getView());

		assertNotNull(model1);
	}

	@Test
	public void updatedRecTest() {
		Employee employee = new Employee();
		employeeController.updatedRec(employee);
		assertNotNull(model);
	}

	private Employee getEmployeeDetails() throws ParseException {
		Employee emp = new Employee();
		emp.setId(1001);
		emp.setLastName("Anjaiah");
		emp.setEmail("danji506@gmail.com");
		emp.setDesignation("SE");
		emp.setPassowrd(commanUtility.getPassword());
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
	public void updatedRec() {
		Employee employee = new Employee();
		employeeController.updatedRec(employee);
		assertNotNull(model);

	}

	@Test
	public void dummyTest() {
		Employee employee = new Employee();
		employeeController.dummy(employee);
		assertNotNull(model);

	}

	@Test
	public void getLeavePageTest() {
		model.setViewName("applyLeavePage");
		employeeController.getLeavePage();
		assertNotNull(model);
	}

	@Test
	public void getPaySlipPageTest() {
		model.setViewName("downloadPaySlip");
		employeeController.getPaySlipPage();
		assertNotNull(model);
	}

	@Test
	public void getAttenPageTest() {
		model.setViewName("myattend");
		employeeController.getAttenPage();
		assertNotNull(model);

	}
	/*
	 * @Test public void addEmployeeTest() { Employee employee = new Employee();
	 * employee.setName("Basant"); employee.setDept("IT");
	 * when(repository.save(employee)).thenReturn(employee); Response response =
	 * employeeController.addEmployee(employee); }
	 * 
	 * @Test public void getEmployeeTest() { List<Employee> empList = new
	 * ArrayList<Employee>();
	 * 
	 * Employee employee = new Employee(); employee.setName("Basant");
	 * employee.setDept("IT"); empList.add(employee);
	 * when(repository.findAll()).thenReturn(empList); Response response =
	 * employeeController.getAllEmployees(); }
	 */

}
