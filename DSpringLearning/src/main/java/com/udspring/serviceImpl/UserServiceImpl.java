package com.udspring.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.udspring.Dto.UserDto;
import com.udspring.entity.User;
import com.udspring.exception.EmailAlreadyExistException;
import com.udspring.exception.ResourceNotFoundException;
import com.udspring.mapper.AutoUserMapper;
import com.udspring.mapper.UserMapper;
import com.udspring.repository.UserRepository;
import com.udspring.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	
	private UserRepository userRepository;
	
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		//convert UserDto into User JPA Entity
//		User user = UserMapper.mapToUser(userDto);
		
		/* in the map we use source and destination so userDto is source and 
		 * User is destination.
		 */
		
		//here we use modelMapper
//		User user = modelMapper.map(userDto, User.class);
		
		//here we use the mapStruct
		
		/*
		 * here we have to use source only in line below in Mapper
		 */
		
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		
		if(optionalUser.isPresent()) {
			throw new EmailAlreadyExistException("Email is already present,please use another email");
		}
		
		
		User user = AutoUserMapper.MAPPER.mapUser(userDto);
		
		
		User savedUser = userRepository.save(user);
		
		//convert USer JPA entity to UserDto
		
//		UserDto savedUserDto= modelMapper.map(user,UserDto.class);
		
		/*
		 * Source object =  Target object (convention in mapStruct)
		 */
		
		UserDto savedUserDto= AutoUserMapper.MAPPER.mapToUserDto(savedUser);
	
		return savedUserDto;
				
		
	}

	@Override
	public UserDto getUserById(Long id) {
		
		
		//Optional use for adding one layer of validations if id not exist then throe exception.
		User user =userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", id)
				
				);
		
		//if we you want something from the optional then you need to use .get meathod.
		//User user =optionUser.get();
		
//		return UserMapper.mapToUserDto(user);
//		return modelMapper.map(user, UserDto.class);
		
		
		
		return  AutoUserMapper.MAPPER.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users= userRepository.findAll();
//		return users.stream().map(UserMapper::mapToUserDto)
//				.collect(Collectors.toList());
//		return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
//				.collect(Collectors.toList());
//		
		return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
		.collect(Collectors.toList());
		
		
		
	}

	@Override
	public UserDto editUserById(UserDto user) {
		// TODO Auto-generated method stub
		/*
		 *we need to find out the existing user using this meathod.
		 */
		
		User existingUser =   userRepository.findById(user.getId()).orElseThrow(
				
				() ->  new ResourceNotFoundException("User", "id", user.getId())
				
				);
		existingUser.setFirst(user.getFirst());
		existingUser.setLast(user.getLast());
		existingUser.setEmail(user.getEmail());
		/*
		 * Set tin the existing user im the user
		 */
		
		User updateUser = userRepository.save(existingUser);
		
//		return UserMapper.mapToUserDto(updateUser);
		
//		return modelMapper.map(updateUser, UserDto.class);
		
		
		
		return AutoUserMapper.MAPPER.mapToUserDto(updateUser);
		
		
		
	}



	
}
