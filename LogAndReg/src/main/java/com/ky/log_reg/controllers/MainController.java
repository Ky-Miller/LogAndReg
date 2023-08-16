package com.ky.log_reg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ky.log_reg.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

//	private final UserService userServ;
	
	public MainController() {}
	
	@Autowired
	private UserService userServ;

	@GetMapping("/")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null){
			return "redirect:/users/login/register";
		}
		model.addAttribute("loginUser", userServ.getUser((Long)session.getAttribute("user_id")));
		return "main/dashboard.jsp";
	}
}
