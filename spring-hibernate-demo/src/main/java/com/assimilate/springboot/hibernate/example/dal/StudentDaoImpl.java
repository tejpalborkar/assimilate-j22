package com.assimilate.springboot.hibernate.example.dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.assimilate.springboot.hibernate.example.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Student save(Student student) {
		Session session = sessionFactory.openSession();
		session.save(student);
		session.close();
		return student;
	}

	@Override
	public Student update(Student student) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(student);
		session.close();
		return student;
	}

	//@Transactional
	@Override
	public Student delete(Student student) {
		Session session = sessionFactory.openSession();
		System.out.println("Deleting student by Id: "+student.getId());
		session.delete(student);
		session.beginTransaction().commit();
		return student;
	}

	@Override
	public List<Student> findAll() {
		Session session = sessionFactory.openSession();
		List<Student> list = session.createCriteria(Student.class).list();
		return list;
	}

	@Override
	public Student findById(Long studentId) {
		Session session = sessionFactory.openSession();
		System.out.println("Getting student by Id: "+studentId);
		return session.get(Student.class, studentId.intValue());
	}

}
