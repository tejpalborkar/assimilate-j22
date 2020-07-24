package com.assimilate.springboot.javafeb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.assimilate.springboot.javafeb.model.Student;

class StudentMapper implements RowMapper<Student> {
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
}
