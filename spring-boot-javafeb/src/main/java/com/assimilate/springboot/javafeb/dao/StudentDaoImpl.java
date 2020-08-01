package com.assimilate.springboot.javafeb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.assimilate.springboot.javafeb.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Student student) {

		String sql = "insert into student(firstName, lastName, rollNo, mobile, course) values(?,?,?,?,?)";
		int rowsUpdated = jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getRollNo(),
				student.getMobile(), student.getCourse());

		System.out.println("Rows inserted: " + rowsUpdated);
		System.out.println("Student saved.");
		
		return rowsUpdated;

	}

	@Override
	public int update(Student student) {

		System.out.println("Student updated.");
		return 1;
	}

	@Override
	public int delete(Integer studentId) {
		String sql = "delete from student where id=?";
		int rowsDeleted = jdbcTemplate.update(sql, studentId);
		System.out.println("Student deleted: " + rowsDeleted);
		return rowsDeleted;

	}

	@Override
	public List<Student> findAll() {
		String sql = "select * from student";
		List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
		return students;
	}

	@Override
	public Student findById(Integer id) {
		String sql = "select * from student where id = ?";
		List<Student> students = jdbcTemplate.query(sql, new StudentMapper(), id);
		if (students.isEmpty()) {
			return null;
		} else {
			return students.get(0);
		}
//		Student student = jdbcTemplate.queryForObject(sql, new Object[] { id },
//				new BeanPropertyRowMapper<Student>(Student.class));
//		return student;
	}

	@Override
	public Student findByRollNo(Integer rollNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student search(Integer rollNo, String firstName, String mobile) {
		String sql = "select * from student where";

		if (rollNo != null) {
			sql += " rollNo=?";
		}

		if (firstName != null) {
			sql += " firstName=?";
		}
		if (mobile != null) {
			sql += " mobile=?";
		}
		System.out.println(sql);
		List<Student> students = jdbcTemplate.query(sql, new StudentMapper(), rollNo);
		return null;
	}

}
