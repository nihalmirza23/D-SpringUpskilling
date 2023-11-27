package com.departmentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;
	
}
