package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.Employee;
import com.app.service.IEmployeeService;

@Controller
public class ManagerController {

	@Autowired
	IEmployeeService employeeService;

	ModelAndView model = new ModelAndView();

	@RequestMapping(value = "/getAllData", method = RequestMethod.GET)
	public ModelAndView findAllData() {
		List<Employee> employee2 = employeeService.findAllData();
		model.setViewName("manager/viewall");
		model.getModelMap().addAttribute("getdata", employee2);
		return model;

	}

	@RequestMapping(value = "/viewProfile")
	public ModelAndView viewEmpDetails(@RequestParam("id") int id) {

		Employee employee = employeeService.getById(id);
		System.out.println("viewdata" + employee);
		model.setViewName("manager/viewEmpProfile");
		model.getModelMap().addAttribute("userdata", employee);
		return model;
	}

	@RequestMapping(value = "/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int id) {
		System.out.println("get delete ....");
		employeeService.delete(id);
		System.out.println("deleted.....");
		return "redirect:/getAllData";
	}

}
