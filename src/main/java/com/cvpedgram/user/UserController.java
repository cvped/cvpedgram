package com.cvpedgram.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {

	@GetMapping("/join-view")
	public String inputjoin() {
		return "/user/join";
	}
	
	@GetMapping("/login-view")
	public String inputlogin() {
		return "/user/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		
		
		return "redirect:/user/login-view";
		
	}
}
