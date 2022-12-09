package com.projects.Student.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projects.Student.Entities.Student;
import com.projects.Student.Repository.IStudentRepository;

@Service
public class StudentManager implements IStudentService{

	IStudentRepository iStudentRepository;
	
	@Autowired
	public StudentManager(IStudentRepository iStudentRepository) {
		this.iStudentRepository = iStudentRepository;
	}

	@Override
	@Transactional
	public List<Student> getStudents() {
		return iStudentRepository.getStudents();
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		return iStudentRepository.getStudent(id);
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		iStudentRepository.addStudent(student);
	}

	@Override
	@Transactional
	public void deleteStudent(Student student) {
		iStudentRepository.deleteStudent(student);
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		iStudentRepository.updateStudent(student);
	}

}
