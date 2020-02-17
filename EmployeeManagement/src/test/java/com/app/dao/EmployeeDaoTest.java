package com.app.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.app.entity.Address;
import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.util.CommanUtility;

public class EmployeeDaoTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	private EmployeeDaoImpl employeeDaoImpl;
	@Mock
	private SessionFactory sessionFactory;

	@Mock
	private Session session;

	@Mock
	private Criteria criteria;

	@Mock
	private Query query;

	@Mock
	CommanUtility commanUtility;

	// login dao
	@Test
	public void getEmpByCredentialTest() {
		Employee emp = new Employee();
		emp.setPassowrd(UUID.randomUUID().toString());
		emp.setId(11);
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(emp);
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		when(session.createCriteria(Employee.class)).thenReturn(criteria);
		when(criteria.list()).thenReturn(empList);
		emp = employeeDaoImpl.getEmpByCredential(emp.getId(), emp.getPassowrd());
		// System.out.println(emp);
		assertNotNull(emp);
	}

	// Save record
	@Test
	public void saveTest() throws ParseException {
		Employee emp = getEmployeeDetails();
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		when(session.save(emp)).thenReturn(10);
		int id = employeeDaoImpl.save(emp);
		assertNotNull(id);

	}

	@SuppressWarnings("unused")
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
		// Setting Employee addeess
		emp.setAddress(addr);
		Department dept = new Department();
		dept.setDeptId(1001);
		dept.setDeptName("IT");
		emp.setDepartment(dept);
		return emp;
	}

	// get All Record

	@Test
	public void getAllEmployeeTest() {
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = new Employee();
		try {
			emp = getEmployeeDetails();
		} catch (ParseException e) {

			e.printStackTrace();
		}
		empList.add(emp);

		String string = "from Employee e where status=:status";
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		when(session.createQuery(string)).thenReturn(query);
		when(query.setParameter("status", true)).thenReturn(query);
		when(query.list()).thenReturn(empList);
		// when(sessionFactory.getCurrentSession().createQuery(string).setParameter("status",
		// true).list())
		// .thenReturn(empList);
		employeeDaoImpl.getAllEmployee();

	}

	// Get Single Record By Id
	@Test
	public void getById() throws ParseException {
		Employee emp = new Employee();
		emp = getEmployeeDetails();
		emp.setId(10);
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		when(session.get(Employee.class, emp)).thenReturn(10);
		employeeDaoImpl.getById(emp.getId());

	}


	/*
	 * * // Update Singal record public void updateEmp(Employee employee) {
	 * Session session = sessionFactory.getCurrentSession();
	 * session.update(employee); }
	 * 
	 * // Delate Record public void deleteEmp(int id) { Session session =
	 * sessionFactory.getCurrentSession(); Employee employee = (Employee)
	 * sessionFactory.getCurrentSession().get(Employee.class, id);
	 * employee.setStatus(false);
	 * 
	 * if (session != null) { session.update(employee); } }
	 * 
	 * // Get Address data with Respect Employee Class@OneToOne // private
	 * Employee employee;select * from address_tb where employee_id=1; public
	 * Address getAddress(Employee emp) {
	 * 
	 * String string = "from Address a where a.employee =:emp"; Query a =
	 * sessionFactory.getCurrentSession().createQuery(string);
	 * 
	 * a.setParameter("emp", emp); Address address = (Address) a.list().get(0);
	 * return address;
	 * 
	 * }
	 */

}
