package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.Employee;
import com.app.entity.Hr;
import com.app.service.IHrService;

@Controller
public class HrController {

	@Autowired
	private IHrService iHrService;

	ModelAndView model = new ModelAndView();

	@RequestMapping(value = "/")
	public ModelAndView home() {

		model.setViewName("login");

		return model;
	}

	@RequestMapping(value = "/insertData")
	public ModelAndView insertTestData() {

		Hr hr = new Hr();

		iHrService.testData(hr);

		model.setViewName("login");

		return model;
	}

	@RequestMapping(value = "/log")
	public ModelAndView loginpage() {

		Hr hrDetails = iHrService.getHrCred(5, "1245");

		System.out.println(hrDetails);

		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/getAll")
	public ModelAndView findAllData() {

		List hrList = iHrService.findByAll();

		System.out.println(hrList);

		model.setViewName("login");

		return model;

	}

}
