package com.mn.contactstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mn.contactstore.command.LoginCommand;
import com.mn.contactstore.command.UserCommand;

/*
 * This is the Controller of our Application
 * @author Md Nazish
 */

@Controller
public class PageController {

	@RequestMapping({ "/", "/home", "/index" })
	public ModelAndView page() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Login");
		model.addAttribute("userClickLogin", true);
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
