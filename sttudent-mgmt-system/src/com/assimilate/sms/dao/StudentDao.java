package com.assimilate.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.assimilate.sms.model.Student;

public class StudentDao {

	public int save(Student student) {
		System.out.println("Saving stundent in db");
		int status = 0;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into student(name,mobile_no, roll_no, email,password) values (?,?,?,?,?)");
			ps.setString(1, student.getName());
			ps.setString(2, student.getMobile());
			ps.setInt(3, student.getRollNo());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getPassword());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("stundent saved successfully");
		return status;
	}

	public  int update(Student student) {
		int status = 0;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update student set name=?,mobile_no=?, roll_no=?,email=?, password=? where id=?");
			ps.setString(1, student.getName());
			ps.setString(2, student.getMobile());
			ps.setInt(3, student.getRollNo());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getPassword());
			ps.setInt(6, student.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public int delete(int id) {
		int status = 0;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public Student getStudentById(int id) {
		Student student = new Student();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setPassword(rs.getString("password"));
				student.setEmail(rs.getString("email"));
				student.setRollNo(rs.getInt("roll_no"));
				student.setMobile(rs.getString("mobile_no"));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return student;
	}

	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<Student>();
		System.out.println("Retriving Studentes from database...");
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setPassword(rs.getString("password"));
				student.setEmail(rs.getString("email"));
				student.setRollNo(rs.getInt("roll_no"));
				student.setMobile(rs.getString("mobile_no"));
				list.add(student);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Total Studentloyees returned from the database: " + list.size());
		return list;
	}

	public Student getStudentByEmailNameAndPassword(String email, String password) {

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from student where email=? AND password =?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setPassword(rs.getString("password"));
				student.setEmail(rs.getString("email"));
				student.setRollNo(rs.getInt("roll_no"));
				student.setMobile(rs.getString("mobile_no"));
				return student;
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;

	}
}