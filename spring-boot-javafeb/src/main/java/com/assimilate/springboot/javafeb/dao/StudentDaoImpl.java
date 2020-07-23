package com.assimilate.springboot.javafeb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.assimilate.springboot.javafeb.model.Student;

@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Student student) {

		String sql = "insert into student(firstName, lastName, rollNo, mobile, course) values(?,?,?,?,?)";
		int update = jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getRollNo(),
				student.getMobile(), student.getCourse());

		System.out.println("Rows inserted: " + update);
		System.out.println("Student saved.");

	}

	@Override
	public void update(Student student) {
	
		System.out.println("Student updated.");
	}

	@Override
	public void delete(Integer studentId) {
		String sql=  "delete from student where id=?";
		int rowsDeleted = jdbcTemplate.update(sql, studentId);
		System.out.println("Student deleted: "+rowsDeleted);

	}

	@Override
	public List<Student> findAll() {

		String sql = "select * from student";
		List<Student> students = jdbcTemplate.query(sql, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				student.setRollNo(rs.getInt("rollNo"));
				student.setMobile(rs.getString("mobile"));
				student.setCourse(rs.getString("course"));
				return student;
			}

		});

		return students;
	}

	@Override
	public void findById(Integer id) {
		// TODO Auto-generated method stub

	}

}
