package com.cvpedgram.user.repository;


import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import lombok.Getter;


@Mapper
public interface UserRepository {

	public int insertUser(
			@Param("loginId")String loginId
			,@Param("password")String password
			,@Param("name")String name
			,@Param("email")String email);
	
	public int selectCountLoginId(@Param("loginId")String loginId);
	
	public User selectUser(
			@Param("loginId")String loginId
			,@Param("password")String password);
	
	public User selectUserById(@Param("id") int id);
}
