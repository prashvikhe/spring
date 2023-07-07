package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Students") 
public class Student extends BaseEntity
{
	//first name , last name , email , course title,score obtained.
	@Column(name = "First_Name")
	private String firstName;
	@Column(name="Last_Name")
	private String lastName;
	@Column(unique = true,nullable = false)
	private String email;
	private String password;
	private double Score;
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course cid ;
}
