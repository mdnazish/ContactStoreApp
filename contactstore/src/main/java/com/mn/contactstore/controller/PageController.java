package com.mn.contactstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mn.contactstore.command.LoginCommand;
import com.mn.contactstore.command.UserCommand;
import com.mn.contactstore.domain.User;
import com.mn.contactstore.exception.UserBlockedException;
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

	@RequestMapping("/login")
	public ModelAndView login(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("title", "Login");
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginHandler(@ModelAttribute("loginCommand") LoginCommand command, Model model, HttpSession session) {

		// call service method
		try {
			User user = userService.login(command.getLoginName(), command.getPassword());
			if (user == null) {
				// FAILED
				// add error message
				model.addAttribute("error", "Login Failed! Please Enter Valid loginName and Password.");
				model.addAttribute("title", "Login");
				return "login";
			} else {
				// SUCCESS
				// Check the role and redirect to appropriate dashboard
				if (user.getRole().equals(UserService.ROLE_ADMIN)) {

					// add admin details in http session (assign session to logged in user)
					addUserInSeesion(user, session);
					return "redirect:admin/dashboard";

				} else if (user.getRole().equals(UserService.ROLE_USER)) {

					// add user details in http session (assign session to logged in user)
					addUserInSeesion(user, session);
					return "redirect:user/dashboard";

				} else {
					// add error message
					model.addAttribute("error", "Login Failed! Invalid User.");
					model.addAttribute("title", "Login");
					return "login";
				}
			}
		} catch (UserBlockedException e) {
			// add error message
			model.addAttribute("error", e.getMessage());
			model.addAttribute("title", "Login");
			return "login";
		}
	}

	private void addUserInSeesion(User user, HttpSession session) {
		session.setAttribute("user", user);
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("role", user.getRole());
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login?action=logout";
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

		User user = userCommand.getUser();
		user.setRole(UserService.ROLE_USER);
		user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
		userService.register(user);
		
		return "redirect:login?action=register";
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
