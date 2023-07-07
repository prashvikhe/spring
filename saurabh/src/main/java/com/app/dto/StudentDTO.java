package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO 
{

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double Score;
	private long cid ;

}
