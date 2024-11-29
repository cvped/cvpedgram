package com.cvped.gram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CvpedgramController {

	@GetMapping("/user/join-view")
	public String inputJoin() {
		return "/user/join";
	}
	
}
