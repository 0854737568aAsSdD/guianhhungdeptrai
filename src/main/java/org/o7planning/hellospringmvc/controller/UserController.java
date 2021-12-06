package org.o7planning.hellospringmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.o7planning.hellospringmvc.model.User;
import org.o7planning.hellospringmvc.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	UserServices userServices;

	@RequestMapping(value = "danh-sach", method = RequestMethod.GET)
	public String getAlluser(HttpServletRequest request) {
		List<User> users = userServices.getAllusers();
		request.setAttribute("users", users);
		return "user/listuser";
	}

	@RequestMapping(value = "chi-tiet-nguoi-dung/{userId}", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request, @PathVariable(value = "userId") int userId) {
		request.setAttribute("user", userServices.getUserbyId(userId));
		return "user/viewUser";
	}

	@RequestMapping(value = "them-khach-hang", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		request.setAttribute("user", new User());
		return "user/addUser";
	}

//	@RequestMapping(value = "them-khach-hang", method = RequestMethod.POST)
//	public String addUser(HttpServletRequest request) {
//		request.setAttribute("user", new User());
//		return "user/addUser";
//	}

}
