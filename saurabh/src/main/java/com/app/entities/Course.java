package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Courses")
@JsonIgnoreType
@ToString
public class Course extends BaseEntity
{
	
	// course title(unique) , start date , end date , fees , min scorer
	@Column(unique = true,nullable = false)
	private String title;
	@Column(name = "start_Date")
	private LocalDate startDate;
	@Column(name = "end")
	private LocalDate endDate;
	private double fees;
	@Column(name = "min_Score")
	private int minscore;
	@OneToMany(mappedBy = "cid" ,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Student> studentList=new ArrayList<>();
	
	public Course(String title, LocalDate startDate, LocalDate endDate, double fees, int minscore)
	{
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.minscore = minscore;
	}
	public void addStudent(Student student)
	{
		studentList.add(student);
	}
	public void removeStudent(Student student)
	{
		studentList.remove(student);
		student.setCid(null);
	}
}
