package com.projects.Student.Business;

import java.util.List;

import com.projects.Student.Entities.Student;

public interface IStudentService {

	List<Student> getStudents();
	Student getStudent(int id);
	void addStudent(Student student);
	void deleteStudent(Student student);
	void updateStudent(Student student);
}
