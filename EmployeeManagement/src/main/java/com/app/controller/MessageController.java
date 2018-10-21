package com.app.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.IMessageDAO;
import com.app.entity.Address;
import com.app.entity.Employee;
import com.app.entity.Message;
import com.app.service.IEmployeeService;
import com.app.service.IMessageService;
import com.app.util.GetUserFromSession;

@Controller
public class MessageController {

	@Autowired
	IEmployeeService employeeService;

	@Autowired
	IMessageService iMessageService;
	ModelAndView model = new ModelAndView();

	@RequestMapping(value = "/sendMe")
	public ModelAndView mesageHome() {

		model.setViewName("sendMes");
		List<Employee> empList = employeeService.findAllData();
		model.getModelMap().addAttribute("messageAll", empList);

		return model;

	}

	@RequestMapping(value = "/savemessage", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("message") Message message, HttpServletRequest req) {
		Employee emp = (Employee) GetUserFromSession.getUser(req);
		message.setSendDate(new Date());
		message.setSenderId(emp.getId());
		message.setStatus("notread");
		message.setId(1);

		int msgsave = iMessageService.insert(message);
		model.setViewName("sendMes");
		List<Employee> empList = employeeService.findAllData();
		model.getModelMap().addAttribute("messageAll", empList);

		return model;
	}

	@RequestMapping(value = "/viewAllMsg", method = RequestMethod.GET)
	public ModelAndView viewAllMsg() {
		System.out.println("senddddddddddddd.....");
		List<Message> list = iMessageService.findAll();
		System.out.println("sentttttttttttttt.....");
		model.setViewName("viewAllMes");
		model.getModelMap().addAttribute("viewdata", list);
		return model;

	}

	
	@RequestMapping(value = "/viewMsgs")
	public ModelAndView viewMsgDetails(@RequestParam("id") int id) {

		Message message = iMessageService.findById(id);
		System.out.println("viewdata" + message);
		model.setViewName("viewMessageBySnd");
		model.getModelMap().addAttribute("userdata", message);
		return model;
	}

	@RequestMapping(value = "/deleteMsg")
	public String deleteMsg(@RequestParam("id") int id) {
		System.out.println("get delete ....");
		iMessageService.delete(id);
		System.out.println("deleted.....");
		return "redirect:/viewAllMsg";
	}

	
	
}
