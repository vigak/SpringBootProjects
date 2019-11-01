package com.vignesh.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vignesh.flightreservation.model.User;
import com.vignesh.flightreservation.repos.UserRepository;
import com.vignesh.flightreservation.service.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder BCryptPasswordEncoder;
	
	@Autowired
	SecurityService securityService;
	
	@RequestMapping("/showReg")
	public String showRegistration() {
		return "login/registerUser";
	}
	
	@RequestMapping(value="registerUser", method=RequestMethod.GET)
	public String registerUser(@ModelAttribute("user") User user) {
		user.setPassword(BCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(@ModelAttribute("email") String email, @ModelAttribute("password") String password, ModelMap modelMap) {
		User user = userRepository.findByEmail(email);
		
		boolean loginResult = securityService.login(email, password);
		if (loginResult) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid username or password provided for login");
			return "login/login";
		}
	}

}
