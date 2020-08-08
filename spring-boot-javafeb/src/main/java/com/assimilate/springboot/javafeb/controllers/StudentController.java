package com.assimilate.springboot.javafeb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.assimilate.springboot.javafeb.dao.StudentRepository;
import com.assimilate.springboot.javafeb.model.Student;
import com.assimilate.springboot.javafeb.model.StudentVo;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentDao;

	@GetMapping("/students")
	public ModelAndView viewAllStudents() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("students");
		List<Student> studentList = studentDao.findAll();
		System.out.println("Students fetched from db : " + studentList.size());
		modelAndView.addObject("students", studentList);

		return modelAndView;
	}

	@PreAuthorize(value = "hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') ")
	@GetMapping("/students/addStudent")
	public ModelAndView addStudent() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addStudent");
		modelAndView.addObject("student", new StudentVo());
		return modelAndView;
	}

	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PostMapping("/students/addStudent")
	public ModelAndView createStudent(@Valid @ModelAttribute StudentVo studentVo) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(studentVo);

		Student student = new Student();
		student.setFirstName(studentVo.getFirstName());
		student.setLastName(studentVo.getLastName());
		student.setMobile(studentVo.getMobile());
		student.setRollNo(studentVo.getRollNo());
		student.setCourse(studentVo.getCourse());

		student = studentDao.save(student);
		if (student != null) {
			String message = "Student added successfully...";
			modelAndView.addObject("message", message);

		} else {
			String message = "Student not added...";
			modelAndView.addObject("message", message);

		}
		modelAndView.setViewName("students");
		List<Student> studentList = studentDao.findAll();
		System.out.println("Students fetched from db : " + studentList.size());
		modelAndView.addObject("students", studentList);

		return modelAndView;
	}

	@GetMapping("/students/edit/{id}")
	public ModelAndView editStudent(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editStudent");

		Student studentFromDb = studentDao.findById(id).get();
		StudentVo studentVo = new StudentVo();

		studentVo.setFirstName(studentFromDb.getFirstName());
		studentVo.setLastName(studentFromDb.getLastName());
		studentVo.setMobile(studentFromDb.getMobile());
		studentVo.setRollNo(studentFromDb.getRollNo());
		studentVo.setCourse(studentFromDb.getCourse());

		modelAndView.addObject("student", studentVo);

		return modelAndView;
	}

	@PostMapping("/students/update")
	public ModelAndView updateStudent(@ModelAttribute StudentVo studentVo) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(studentVo);

		Student student = new Student();
		student.setId(studentVo.getId());
		student.setFirstName(studentVo.getFirstName());
		
		student.setLastName(studentVo.getLastName());
		student.setMobile(studentVo.getMobile());
		student.setRollNo(studentVo.getRollNo());
		student.setCourse(studentVo.getCourse());

		student = studentDao.save(student);
		if (student != null) {
			String message = "Student updated successfully...";
			modelAndView.addObject("message", message);

		} else {
			String message = "Student not updated...";
			modelAndView.addObject("message", message);

		}
		modelAndView.setViewName("students");
		List<Student> studentList = studentDao.findAll();
		System.out.println("Students fetched from db : " + studentList.size());
		modelAndView.addObject("students", studentList);

		return modelAndView;
	}

	@GetMapping("/students/delete/{id}")
	public ModelAndView deleteStudent(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("students");

		studentDao.deleteById(id);
		System.out.println("Student deleted..");
		List<Student> studentList = studentDao.findAll();
		System.out.println("Students fetched from db : " + studentList.size());
		modelAndView.addObject("students", studentList);

		String message = "Student deleted successfully...";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
