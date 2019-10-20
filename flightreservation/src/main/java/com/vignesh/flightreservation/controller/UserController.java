package com.vignesh.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vignesh.flightreservation.model.User;
import com.vignesh.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegistration() {
		return "login/registerUser";
	}
	
	@RequestMapping(value="registerUser", method=RequestMethod.GET)
	public String registerUser(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(@ModelAttribute("email") String email, @ModelAttribute("password") String password, ModelMap modelMap) {
		User user = userRepository.findByEmail(email);
		if (user.getPassword().equals(password)) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid username or password provided for login");
			return "login/login";
		}
	}

}
