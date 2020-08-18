package com.assimilate.springboot.hibernate.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assimilate.springboot.hibernate.example.dal.StudentDao;
import com.assimilate.springboot.hibernate.example.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Transactional
	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}

	@Override
	public Student update(Student student) {
		Student studentFromDb = studentDao.findById(student.getId().longValue());
		studentFromDb.setCourse(student.getCourse());
		studentFromDb.setLastName(student.getLastName());
		studentFromDb.setFirstName(student.getFirstName());
		studentFromDb.setMobile(student.getMobile());
		studentFromDb.setRollNo(student.getRollNo());
		
		return studentDao.update(studentFromDb);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

	@Override
	public Student findById(Long studentId) {
		// TODO Auto-generated method stub
		return studentDao.findById(studentId);
	}

	@Transactional
	@Override
	public void deleteById(Long studentId) {
		Student student = findById(studentId);
		studentDao.delete(student);
		System.out.println("Student deleted : " + studentId);
	}

}
