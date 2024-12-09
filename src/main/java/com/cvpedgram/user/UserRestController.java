package com.cvpedgram.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cvpedgram.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class UserRestController {

private UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	
	//API
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam("loginId")String loginId
			,@RequestParam("password")String password
			,@RequestParam("name")String name
			,@RequestParam("email")String email){
		
		Map<String,String> resultMap = new HashMap<>();
		
		if(userService.addUser(loginId, password, name, email)) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;	
	}
	
	
	// API
	@PostMapping("/login")
	public Map<String,String> login(
			@RequestParam("loginId")String loginId
			,@RequestParam("password")String password
			,HttpServletRequest request) {
		
		User user = userService.getUser(loginId, password);
		
		Map<String,String> resultMap = new HashMap<>();
		if(user != null) {
			
			HttpSession session = request.getSession();
			
			// user 객체에 id, user name 
			session.setAttribute("userId", ((HttpSession) user).getId());
			session.setAttribute("username",user.getName());
			
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
 
	
}
