package com.udspring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.service.annotation.PutExchange;

import com.udspring.Dto.UserDto;
import com.udspring.entity.User;
import com.udspring.exception.ErrorDetails;
import com.udspring.exception.ResourceNotFoundException;
import com.udspring.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(
		name = "CRUD REST API FOR USER RESOURCE",
		description ="Create USer ,Update ,get all and get withId" 
		)
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

	
	//In controller class we need to create parametrised construction for the service
	
	private UserService userService;
	
	@Operation(
			summary = "Create User Rest Api",
			description = "create User Rest Api"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP status 201 created"
			
			)
	@PostMapping("/user")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
		UserDto saveuser=userService.createUser(user);
		return new ResponseEntity<>(saveuser,HttpStatus.OK);
	}
	
	
	
	@Operation(
			summary = "get User By Id Rest Api",
			description = "get User By Id  Api"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP status 200 created"
			
			)
	
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
		UserDto user=	userService.getUserById(id);
	return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getAllUsers(){
	List<UserDto> users=	userService.getAllUsers();
	return new ResponseEntity<>(users,HttpStatus.OK); 
	}
	
	@PutMapping("/change/{id}")
	public ResponseEntity<UserDto> editUserById(@PathVariable Long id,
											@Valid @RequestBody UserDto user ){
	user.setId(id);
	UserDto updateUser=userService.editUserById(user);
		return new ResponseEntity<>(updateUser,HttpStatus.OK);
	}
	
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//																		WebRequest webRequest){
//		ErrorDetails errorDetails= new ErrorDetails(
//				
//				LocalDateTime.now(),
//				exception.getMessage(),
//				webRequest.getDescription(false),
//				"USER_NOT_FOUND"
//				);
//		
//		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//	}
//	

	
	
}
