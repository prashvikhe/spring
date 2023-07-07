package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDTO;
import com.app.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentsController 
{
	@Autowired
	private StudentService studser;
	@Autowired
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getallStudent()
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(studser.getallStudent());
	}
	
	@PostMapping("/addstudent")
	public ResponseEntity<?> addStudent(@RequestBody StudentDTO student)
	{
		return new ResponseEntity<>(studser.addStudent(student),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{sid}/course/{cid}")
	public ResponseEntity<?> cancelAdmission(@PathVariable Long sid,@PathVariable Long cid)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(studser.cancelAdmission(sid, cid));
	}
	
}
