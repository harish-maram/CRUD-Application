package com.evvemi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evvemi.entity.Student;
import com.evvemi.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Object findAll()
	{
	return studentRepository.findAll();
	}

	public Student findById(long id)
	{
	return studentRepository.findOne(id);
	}


	public Student save(Student student)
	{
	return studentRepository.save(student);
	}

	public void delete(Student student)
	{
	studentRepository.delete(student);
	return;
	}
			
	public Student findByName(String name)
	{
	return null;
	}	

}
