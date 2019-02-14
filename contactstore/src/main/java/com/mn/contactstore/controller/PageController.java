package com.mn.contactstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mn.contactstore.command.UserCommand;
import com.mn.contactstore.domain.User;
import com.mn.contactstore.service.UserService;

/*
 * This is the Controller of our Application
 * @author Md Nazish
 */

@Controller
public class PageController {

	@Autowired
	private UserService userService;

	@RequestMapping({ "/", "/home", "/index" })
	public ModelAndView page() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping("/signup")
	public ModelAndView registerPage(Model model) {
		UserCommand userCommand = new UserCommand();

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userCommand", userCommand);
		mv.addObject("title", "Sign Up");
		mv.addObject("userClickRegister", true);
		return mv;
	}

	@RequestMapping("/register")
	public String registerUser(@ModelAttribute("userCommand") UserCommand userCommand, Model model) {
		try {
			User user = userCommand.getUser();
			user.setRole(UserService.ROLE_USER);
			user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
			userService.register(user);

			return "redirect:login?action=register"; // Login Page
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			model.addAttribute("error", "Login Name is already registered! Please enter another username.");
			model.addAttribute("title", "Sign Up");
			model.addAttribute("userClickRegister", true); // checking condition in Master Page (page.jsp)
			return "page"; // SignUp Page
		}

	}

	@RequestMapping("/user/dashboard")
	public ModelAndView userDashboard() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "User Dashboard");
		mv.addObject("userLoggedin", true);
		return mv;
	}

	@RequestMapping("/admin/dashboard")
	public ModelAndView adminDashboard() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Admin Dashboard");
		mv.addObject("adminLoggedin", true);
		return mv;
	}

}
