package com.mn.contactstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Login");
		mv.addObject("userClickLogin", true);
		return mv;
	}
	
	@RequestMapping("/signup")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Sign Up");
		mv.addObject("userClickRegister", true);
		return mv;
	}
	
	@RequestMapping("/user/dashboard")
	public ModelAndView userDashboard() {
		ModelAndView mv = new ModelAndView("dashboard_user");
		mv.addObject("title", "User Dashboard");
		mv.addObject("userLoggedin", true);
		return mv;
	}
	
	@RequestMapping("/admin/dashboard")
	public ModelAndView adminDashboard() {
		ModelAndView mv = new ModelAndView("dashboard_admin");
		mv.addObject("title", "Admin Dashboard");
		mv.addObject("adminLoggedin", true);
		return mv;
	}

}
