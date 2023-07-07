package com.app.service;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dto.CourseDTO;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repositiory.CourseRepository;


@Service
@Transactional
public class CourseServiceImpl implements CoursesService
{
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public Course addCourse(CourseDTO cd) 
	{
		
		Course course=mapper.map(cd,Course.class);
		return courseRepo.save(course) ;
	}

	@Override
	public List<Course> courseList() {
		
		courseRepo.findAll().forEach(System.out::println);
		return courseRepo.findAll();
	}

	@Override
	public Course findCourse(Long cid)throws RuntimeErrorException 
	{
		
		return courseRepo.findById(cid).orElseThrow();
	}

	@Override
	public List<Student> getStudentList(String title) {
		
		Course course=courseRepo.findByTitle(title);
		System.out.println(course);
		return course.getStudentList();
	}

	@Override
	public String updateFees(Long cid, double fees) 
	{
		Course course=courseRepo.findById(cid).orElseThrow();
		course.setFees(fees);
		return "Data updated";
	}
	
	
}
