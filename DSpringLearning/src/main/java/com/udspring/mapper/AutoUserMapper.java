package com.udspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.udspring.Dto.UserDto;
import com.udspring.entity.User;

@Mapper
public interface AutoUserMapper {

	/*
	 * This will provide implememtation for interface 
	 *at the compile time and you are able to use this
	 *this Mapper Instance to call there mapping meathods
	 */ 
	
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	
	 UserDto mapToUserDto(User user);
	 
	 User mapUser(UserDto userDto);
	 
	 
	 
}
