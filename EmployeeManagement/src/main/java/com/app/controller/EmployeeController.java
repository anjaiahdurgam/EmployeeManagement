package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.IAdminDAO;
import com.app.entity.Address;
import com.app.entity.Admin;
import com.app.entity.Employee;
import com.app.service.IAdminService;
import com.app.service.IEmployeeService;
import com.app.util.CommanUtility;
import com.app.util.GetUserFromSession;

@Controller
public class EmployeeController {

	//saving the space
	@Autowired
	private IEmployeeService iemployeeService;
	@Autowired
	private IAdminService iadminService;

	ModelAndView model = new ModelAndView();

	// Home1 page or Login page this is Srini
	@RequestMapping(value = { "/", "/dashboard" })

	public ModelAndView home() {

		model.setViewName("login");

		return model;
	}

	// Open Registration or signup page
	@RequestMapping(value = "/signup")
	public ModelAndView signupcreateService() {

		model.setViewName("Registration");

		return model;
	}

	// saved registration data
	@RequestMapping(value = "/*", method = RequestMethod.POST)
	public ModelAndView signupserviceCreation(@ModelAttribute() Employee employee) {

		employee.setPassowrd(CommanUtility.getPassword());
		int empId = iemployeeService.save(employee);
		if (empId > 0) {
			model.setViewName("login");
			model.getModelMap().addAttribute("msg",
					"Your are registered succesfully and credential has been sent to ur email..");
		} else {
			model.setViewName("Registration");
			model.getModelMap().addAttribute("msg", "plzz try again.....");
		}
		return model;

	}

	// loged Home page
	@RequestMapping(value = "/loginHome", method = RequestMethod.POST)
	public ModelAndView loginCredent(@RequestParam("id") int empId, @RequestParam("passowrd") String password,
			HttpServletRequest req, @RequestParam("emptype") String emptype) {

		if (emptype.equals("Manager")) {
			model.setViewName("manager/adminhome");
			Admin admin = iadminService.getByCredentisl(empId, password);

			if (admin.getAdminId() != 0) {

				GetUserFromSession.setUser(req, admin);
			} else {
				model.setViewName("login");
				model.addObject("msg", "Username or password invalid please try again..");
			}

		}
		if (emptype.equals("Employee")) {
			model.setViewName("employeehome");
			Employee employee = iemployeeService.getByCredentisl(empId, password);

			if (employee.getId() != 0) {

				model.setViewName("employeehome");
				GetUserFromSession.setUser(req, employee);
			} else {
				model.setViewName("login");
				model.addObject("msg", "Username or password invalid please try again..");
			}
		}
		return model;

	}

	// Profile View Page
	@RequestMapping(value = "/profileView", method = RequestMethod.GET)
	public ModelAndView empProfile(HttpServletRequest req) {

		Employee emp = (Employee) GetUserFromSession.getUser(req);

		Address add = iemployeeService.getAddress(emp);
		Employee employee2 = iemployeeService.getById(emp.getId());
		employee2.setAddress(add);

		model.setViewName("profile");
		model.getModelMap().addAttribute("userdata", employee2);
		model.getModelMap().addAttribute("data", add);
		return model;

	}

	// Open Update page
	@RequestMapping(value = "/empUpdate", method = RequestMethod.GET)
	public ModelAndView empUpdatePage(/* @RequestParam("id") int empid, */HttpServletRequest req) {

		Employee emp = (Employee) GetUserFromSession.getUser(req);
		Employee employee2 = iemployeeService.getById(emp.getId());
		Address add = iemployeeService.getAddress(emp);
		employee2.setAddress(add);
		model.setViewName("editProfile_emp");
		model.getModelMap().addAttribute("empdata", employee2);
		model.getModelMap().addAttribute("data", add);

		return model;

	}

	@RequestMapping(value = "/updatedRec", method = RequestMethod.POST)
	public String updatedRec(@ModelAttribute("employee") Employee employee) {

		iemployeeService.update(employee);
		return "employeehome";
	}

	@RequestMapping(value = "/dummy", method = RequestMethod.POST)
	public String dummy(@ModelAttribute("employee") Employee employee) {

		iemployeeService.update(employee);
		return "employeehome";
	}

	@RequestMapping("/leavePage")
	public ModelAndView getLeavePage() {
		model.setViewName("applyLeavePage");
		return model;
	}

	@RequestMapping("/getSlip")
	public ModelAndView getPaySlipPage() {
		model.setViewName("downloadPaySlip");
		return model;
	}

	@RequestMapping("/getAttenPage")
	public ModelAndView getAttenPage() {
		model.setViewName("myattend");
		return model;
	}
	
	//this is adding for sreeeni 
	
	@RequestMapping("/getAttenPage")
	public ModelAndView getAttenPage1() {
		model.setViewName("myattend");
		return model;
	}
	
	@RequestMapping("/getAttenPage")
	public ModelAndView getAttenPage2() {
		model.setViewName("myattend");
		return model;
	}
	
	@RequestMapping("/getAttenPage")
	public ModelAndView getAttenPage3() {
		model.setViewName("myattend");
		return model;
	}
	
	@RequestMapping("/getAttenPage")
	public ModelAndView getAttenPage4() {
		model.setViewName("myattend");
		return model;
	}

	
}