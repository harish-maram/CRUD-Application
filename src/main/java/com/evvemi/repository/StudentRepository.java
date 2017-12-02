package com.evvemi.repository;

import org.springframework.stereotype.Repository;

import com.evvemi.entity.Student;

import org.springframework.data.repository.*;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long>{

	public Student findByName(String name);
	
	
}
