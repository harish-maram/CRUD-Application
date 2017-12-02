package com.evvemi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evvemi.entity.Student;
import com.evvemi.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value="/student",method=RequestMethod.GET)
	@ResponseBody
	public Object index()
	{
	return studentService.findAll();
	}

	@RequestMapping(value="/create",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(@RequestBody Student student)
	{
	String userId="";
	try{
		studentService.save(student);
		userId=String.valueOf(student.getId());
		}
		catch(Exception ex) {
		return "Error creating the user:" + ex.toString();
		}
		return "User successfully created with id = "+userId;
	}

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable long id) {

	try {

	Student student=studentService.findById(id);
	studentService.delete(student);

	}
	catch(Exception ex) {
	return "Error deleting the user:" + ex.toString();
	}
	return "User successfully deleted";
	}

	@RequestMapping("/get-by-name")
	@ResponseBody
	public String getByName(String name)
	{
	String userId="";
	try{
		Student student=studentService.findByName(name);
		userId=String.valueOf(student.getId());
		}
		catch(Exception ex) {
		return "User not found";
		}
		return "The user id is: "+userId;
	}	

	@RequestMapping("/update/{id}")
	@ResponseBody
	public String updateStudent(@RequestBody Student student,@PathVariable long id) {

	try {
	student.setId(id);
	studentService.save(student);

	}
	catch(Exception ex) {
	return "Error updating the user:" + ex.toString();
	}
	return "User successfully updated";
	}


	
}
