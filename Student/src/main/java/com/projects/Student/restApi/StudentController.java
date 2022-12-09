package com.projects.Student.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.Student.Business.IStudentService;
import com.projects.Student.Entities.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private final IStudentService iStudentService;
	

	public StudentController(IStudentService iStudentService) {
		super();
		this.iStudentService = iStudentService;
	}

	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return iStudentService.getStudents();
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		return iStudentService.getStudent(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Student student) {
		this.iStudentService.addStudent(student);
	}
	
	@DeleteMapping("/delete")
	public void deleteStudent(@RequestBody Student student) {
		this.iStudentService.deleteStudent(student);
	}
	
	@PutMapping("/update")
	public void updateStudent(@RequestBody Student student) {
		this.iStudentService.updateStudent(student);
	}
}
