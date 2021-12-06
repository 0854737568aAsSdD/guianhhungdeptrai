package org.o7planning.hellospringmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.hellospringmvc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class HelloWorldController {

	@Autowired
	@Qualifier("person2")
	private Person person;

	@RequestMapping("/helloseobi" )
	public String show(ModelMap model) {
		model.addAttribute("meoseobi", person);
		return "xinchao";
	}

	@RequestMapping(value = {"/hello","/say/hello","/hello1"}, method = RequestMethod.POST)
	public ModelAndView hello(Model model, HttpSession session, HttpServletRequest request) {

		if (request.getParameter("but1") != null) {
			session.setAttribute("tam", "Xin chao session");
			String[] ds = { "Ha", "Long", "nam" };
			model.addAttribute("ds", ds);
			model.addAttribute("greeting", "Ok da qua phan nay !!!!!!!!!!");
		}
		return new ModelAndView("helloworld");

	}
	
	@RequestMapping("helloworld")
	public ModelAndView sayHello(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		request.setAttribute("meoseobi", person);
		return new ModelAndView("xinchao");
	}

}