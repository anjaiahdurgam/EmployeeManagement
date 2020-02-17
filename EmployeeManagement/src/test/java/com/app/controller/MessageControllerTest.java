package com.app.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.Address;
import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.entity.Message;
import com.app.service.IAdminService;
import com.app.service.IEmployeeService;
import com.app.service.IMessageService;
import com.app.util.CommanUtility;
import com.app.util.GetUserFromSession;

public class MessageControllerTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@InjectMocks
	private MessageController messageController;

	@Mock
	private IEmployeeService iemployeeService;
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

	@Mock
	IMessageService iMessageService;

	@Test
	public void mesageHomeTest() throws ParseException {

		List<Employee> empList = getEmployeeLists();

		when(iemployeeService.findAllData()).thenReturn(empList);
		ModelMap map = new ModelMap();
		map.addAttribute("messageAll", empList);
		when(model.getModelMap()).thenReturn(map);
		when(model.getModelMap().addAttribute("getData", empList)).thenReturn(map);
		ModelAndView model1 = messageController.mesageHome();
		model.setViewName("sendMes");
		assertNotNull(model1);

	}

	@SuppressWarnings("unused")
	private List<Employee> getEmployeeLists() throws ParseException {
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

	/*
	 * @RequestMapping(value = "/savemessage", method = RequestMethod.POST)
	 * public ModelAndView save(@ModelAttribute("message") Message message,
	 * HttpServletRequest req) { Employee emp = (Employee)
	 * GetUserFromSession.getUser(req); message.setSendDate(new Date());
	 * message.setSenderId(emp.getId()); message.setStatus("notread");
	 * message.setId(1);
	 * 
	 * int msgsave = iMessageService.insert(message);
	 * model.setViewName("sendMes"); List<Employee> empList =
	 * employeeService.findAllData();
	 * model.getModelMap().addAttribute("messageAll", empList);
	 * 
	 * return model; }
	 * 
	 * @RequestMapping(value = "/viewAllMsg", method = RequestMethod.GET) public
	 * ModelAndView viewAllMsg() { System.out.println("senddddddddddddd.....");
	 * List<Message> list = iMessageService.findAll();
	 * System.out.println("sentttttttttttttt.....");
	 * model.setViewName("viewAllMes");
	 * model.getModelMap().addAttribute("viewdata", list); return model;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/viewMsgs") public ModelAndView
	 * viewMsgDetails(@RequestParam("id") int id) {
	 * 
	 * Message message = iMessageService.findById(id);
	 * System.out.println("viewdata" + message);
	 * model.setViewName("viewMessageBySnd");
	 * model.getModelMap().addAttribute("userdata", message); return model; }
	 */
	@Test
	public void deleteMsgTest() throws ParseException {
		
		Employee employee = getSingleempRecord();
		iMessageService.delete(employee.getId());
		ModelMap map = new ModelMap();
		map.addAttribute("viewAllMsg", employee);
		when(model.getModelMap()).thenReturn(map);
		when(model.getModelMap().addAttribute("userData", employee)).thenReturn(map);
		String model1 = messageController.deleteMsg(employee.getId());
		assertNotNull(model1);
		// return "redirect:/viewAllMsg";
	}

	@SuppressWarnings("unused")
	private Employee getSingleempRecord() throws ParseException {
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

}
