package com.udspring.mapper;

import com.udspring.Dto.UserDto;
import com.udspring.entity.User;

public class UserMapper {

	
	//convert User JPa entity into UserDto
	 public static UserDto mapToUserDto(User user) {
		 UserDto userDto=new UserDto(
				 
				 user.getId(),
				 user.getFirst(),
				 user.getLast(),
				 user.getEmail()	 
				 );
		 return userDto;		 
	 }
	 
	 //again it convert the Entity class into User Jpa Entity
	 
	 public static User mapToUser(UserDto userDto) {
		 
		 User user=new User(
				 userDto.getId(),
				 userDto.getFirst(),
				 userDto.getLast(),
				 userDto.getEmail()
				 
				 );
		
		 return user;
	 }
	 
	 
	
}
