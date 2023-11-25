package com.udspring.Dto;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	
	private Long id;
	
	@NotEmpty(message = "User First name was Not empty and null")
	//user first name should not be null
	private String first;
	
	@NotEmpty(message = "User last name was Not empty and null")
	//user first name should not be null
	private String last;
	
	@NotEmpty(message = "Email was Not empty and null")
	@Email(message = "contains only valid emails")
	private String email;
	
	
	
}
