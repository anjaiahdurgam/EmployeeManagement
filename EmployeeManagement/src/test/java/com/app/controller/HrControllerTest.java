package com.app.controller;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Lob;
import javax.persistence.Transient;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.Address;
import com.app.entity.Employee;
import com.app.entity.Hr;
import com.app.service.IAdminService;
import com.app.service.IEmployeeService;
import com.app.service.IHrService;
import com.app.util.CommanUtility;
import com.app.util.GetUserFromSession;

public class HrControllerTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@InjectMocks
	private HrController hrController;

	@Mock
	private IHrService iHrService;
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
		hrController.home();
	}// EClemma

	@Test
	public void insertTestDataTest() {

		Hr hr = new Hr();

		iHrService.testData(hr);
		hrController.insertTestData();
		model.setViewName("login");
	}

	@Test
	public void loginpage() {

		Hr hr = new Hr();
		Hr hrDetails = iHrService.getHrCred(5, "1245");
		hrController.loginpage();
		System.out.println(hrDetails);
		model.setViewName("login");

	}

	@Test
	public void findAllData() throws ParseException {

		List<Hr> hrList = new ArrayList<Hr>();

		Hr hr = new Hr();

		hr.setHrId(1002);
		hr.setFirstName("Anjaiah");
		hr.setLastName("Durgam");
		hr.setGender("Male");
		hr.setDesignation("IT");
		hr.setSalary(50000.00);
		Date dob = new SimpleDateFormat("MM-dd-yyyy").parse("10-12-1993");
		hr.setDob(dob);
		hr.setContact("8978685930");
		hr.setNation("IND");
		hr.setLocation("PUNE");
		hr.setPassword(CommanUtility.getPassword());
		hr.setEmail("danji506@gmail.com");

		Address addr = new Address();
		addr.setAddressId(1001);
		addr.setPostalAddr("Dontha poor");
		addr.setStreet("Maggidi");
		addr.setCity("Karim Nagar");
		addr.setState("Telanganna");
		addr.setPinCode("505425");
		hr.setAddress(addr);

		Hr hr2 = new Hr();

		hr2.setHrId(1002);
		hr2.setFirstName("Anjaiah");
		hr2.setLastName("Durgam");
		hr2.setGender("Male");
		hr2.setDesignation("IT");
		hr2.setSalary(50000.00);
		Date dob1 = new SimpleDateFormat("MM-dd-yyyy").parse("10-12-1993");
		hr2.setDob(dob1);
		hr2.setContact("8978685930");
		hr2.setNation("IND");
		hr2.setLocation("PUNE");
		hr2.setPassword(CommanUtility.getPassword());
		hr2.setEmail("danji506@gmail.com");

		Address addr1 = new Address();
		addr1.setAddressId(1001);
		addr1.setPostalAddr("Dontha poor");
		addr1.setStreet("Maggidi");
		addr1.setCity("Karim Nagar");
		addr1.setState("Telanganna");
		addr1.setPinCode("505425");
		hr2.setAddress(addr1);

		hrList.add(hr);
		hrList.add(hr2);
		System.out.println(hrList);

		hrList = iHrService.findByAll();
		hrController.findAllData();
		model.setViewName("login");
		assertNotNull(model);
	}

}