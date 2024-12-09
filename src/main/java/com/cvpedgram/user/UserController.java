package com.cvpedgram.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user/join-view")
	public String inputjoin() {
		return "/user/join";
	}
	
	@GetMapping("/user/login-view")
	public String inputlogin() {
		return "/user/login";
	}
}
