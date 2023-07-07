package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseDTO;
import com.app.entities.Course;
import com.app.service.CoursesService;

@RestController
@RequestMapping("/course")
public class CourseController 
{
	@Autowired
	 private CoursesService course;
	

	@GetMapping("/list")
	public List<Course> getAllCourse(){
		System.out.println(course.courseList());
		return course.courseList();
	}
	
	@PostMapping("/addcourse")
	public Course addCourse(@RequestBody CourseDTO cr)
	{
		return course.addCourse(cr);
	}
	
	@GetMapping("/studentList/{title}")
	public ResponseEntity<?> studnetList(@PathVariable String title)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(course.getStudentList(title));
	}
	
	@PutMapping("/{cid}/fees/{fee}")
	public ResponseEntity<?> updatFees(@PathVariable Long cid,@PathVariable double fee)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(course.updateFees(cid,fee));
	}

}
