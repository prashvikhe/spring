package com.app.service;

import java.util.List;

import com.app.dto.CourseDTO;
import com.app.entities.Course;
import com.app.entities.Student;

public interface CoursesService 
{
	
	List<Course> courseList();
	
	Course addCourse(CourseDTO course);
	
	Course findCourse(Long cid);
	
	List<Student> getStudentList(String title);

	String updateFees(Long cid,double fees);
}
