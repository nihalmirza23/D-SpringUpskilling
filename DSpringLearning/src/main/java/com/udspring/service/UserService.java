package com.udspring.service;

import java.util.List;

import com.udspring.Dto.UserDto;
import com.udspring.entity.User;

public interface UserService {

	UserDto createUser(UserDto user);
	
	UserDto getUserById(Long id);
	
	List<UserDto> getAllUsers();
	
	UserDto editUserById(UserDto user);
}
