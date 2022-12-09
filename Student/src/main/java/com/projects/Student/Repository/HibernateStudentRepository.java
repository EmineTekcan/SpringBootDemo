package com.projects.Student.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projects.Student.Entities.Student;

@Repository
public class HibernateStudentRepository implements IStudentRepository{

	@Autowired
	EntityManager entityManager;
	
	
	public HibernateStudentRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Student> getStudents() {
		Session session=entityManager.unwrap(Session.class);
		List<Student> students=session.createQuery("FROM Student", Student.class).getResultList();
		return students;
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		Session session=entityManager.unwrap(Session.class);
		Student student=session.get(Student.class,id);
		return student;
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(student);
	}

	@Override
	@Transactional
	public void deleteStudent(Student student) {
		Session session=entityManager.unwrap(Session.class);
		int id=student.getId();
		Student delStudent=session.get(Student.class, id);
		session.delete(delStudent);	
	}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(student);
	}

}
