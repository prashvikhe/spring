package com.app.service;



import java.util.List;

import com.app.dto.StudentDTO;
import com.app.entities.Student;


public interface StudentService 
{
	List<Student> getallStudent();
	Student addStudent(StudentDTO student);
	String cancelAdmission(Long sid,Long cid);

}
