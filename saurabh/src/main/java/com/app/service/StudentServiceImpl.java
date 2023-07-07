package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.StudentDTO;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repositiory.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService 
{
	@Autowired
	private StudentRepository data;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CoursesService crservice;
 
	@Override
	public Student addStudent(StudentDTO studDTO)
	{
		Course course=crservice.findCourse(studDTO.getCid());
		Student student=mapper.map(studDTO, Student.class);
		student.setCid(course);
		course.addStudent(student);
		return data.save(student);
	}

	@Override
	public List<Student> getallStudent() 
	{
		return data.findAll();
	}

	@Override
	public String cancelAdmission(Long sid, Long cid) {
		Student student=data.findById(sid).orElseThrow();
		Course course=crservice.findCourse(cid);
		course.removeStudent(student);
		return "Data Remove Successfully";
	}

}
