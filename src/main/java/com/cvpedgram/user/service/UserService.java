package com.cvpedgram.user.service;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvpedgram.common.MD5HashingEncoder;
import com.cvpedgram.user.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	// autowired 을 위한 생성자지만 존재하는 경우 생략 가능
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public boolean addUser(
			String loginId
			,String password
			,String name
			,String email) {
		
		String encodingPassword = MD5HashingEncoder.encode(password);
		
		
		int  count = userRepository.insertUser(loginId, password, name, email);
		
		if(count == 1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public User getUser(String loginId,String password) {
		
		String encodingPassword = MD5HashingEncoder.encode(password);
		
		return  userRepository.selectUser(loginId, password);
		
	}
	
}
