package com.mn.contactstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mn.contactstore.command.LoginCommand;
import com.mn.contactstore.command.UserCommand;
import com.mn.contactstore.domain.User;
import com.mn.contactstore.exception.UserBlockedException;
import com.mn.contactstore.service.UserService;

/**
 * @author Md Nazish
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// adding user in session
	private void addUserInSeesion(User user, HttpSession session) {
		session.setAttribute("user", user);
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("role", user.getRole());
	}

	/**
	 * the method is handling login functionality 1. showing the error message
	 * related to login failed or user not-exist or invalid user 2. showing
	 * Dashboard based on ROLE (either USER or ADMIN)
	 * 
	 * @param command
	 * @param model
	 * @param session
	 * @return
	 */
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
				model.addAttribute("userClickLogin", true); // checking condition in Master Page (page.jsp)
				return "page"; // Login Page
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
					model.addAttribute("userClickLogin", true); // checking condition in Master Page (page.jsp)
					return "page"; // Login Page
				}
			}
		} catch (UserBlockedException e) {
			// add error message
			model.addAttribute("error", e.getMessage());
			model.addAttribute("title", "Login");
			model.addAttribute("userClickLogin", true); // checking condition in Master Page (page.jsp)
			return "page"; // Login Page
		}
	}

	// performing logout operation
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login?action=logout";
	}

	/**
	 * the method is handling user registeration functionality 1. showing the error
	 * message related to registeration failed 2. showing login page after sucessful
	 * registeration
	 * 
	 * @param userCommand
	 * @param model
	 * @return
	 */
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
			model.addAttribute("error", "Login Name is already exist! Please enter another login username.");
			model.addAttribute("title", "Sign Up");
			model.addAttribute("userClickRegister", true); // checking condition in Master Page (page.jsp)
			return "page"; // SignUp Page
		}

	}
}
