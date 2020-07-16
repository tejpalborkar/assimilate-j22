package com.assimilate.sms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.assimilate.sms.model.Student;

public class StudentDao {

	public boolean insertStudent(Student student) {
		Connection connection = DatabaseConnection.getConnection();
		String sql = "insert into student(firstName, lastName, rollNo, mobile, course) values(?,?,?,?,?)";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, student.getFirstName());
			prepareStatement.setString(2, student.getLastName());
			prepareStatement.setInt(3, student.getRollNo());
			prepareStatement.setString(4, student.getMobile());
			prepareStatement.setString(5, student.getCourse());
			int executeUpdate = prepareStatement.executeUpdate();
			System.out.println("Student inserted: " + executeUpdate);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Student> fetchAllStudents() {

		List<Student> students = new ArrayList<Student>();
		
		Connection connection = DatabaseConnection.getConnection();
		String query = "select * from student";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				student.setRollNo(rs.getInt("rollNo"));
				student.setMobile(rs.getString("mobile"));
				student.setCourse(rs.getString("course"));
				students.add(student);;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

}
