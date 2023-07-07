package com.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
	

}
