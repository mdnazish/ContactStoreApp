package com.mn.contactstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * This is the Testing of our Application
 * @author Md Nazish
 */

@Controller
public class TestController {

	@RequestMapping("/test")
	public String hello() {
		return "hello"; // is equal to -> /WEB-INF/views/hello.jsp
	}
	
	@RequestMapping("/test/greeting")
	public ModelAndView helloGreeting(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("greeting","Project Tested Successfully");
		return mv;
	}
}
