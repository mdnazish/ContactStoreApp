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

	@RequestMapping("/login")
	public ModelAndView login(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("title", "Login");
		return mv;
	}

	private void addUserInSeesion(User user, HttpSession session) {
		session.setAttribute("user", user);
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("role", user.getRole());
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

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login?action=logout";
	}
}
