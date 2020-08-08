package com.assimilate.springboot.javafeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assimilate.springboot.javafeb.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByMobile(String mobile);

	List<Student> findByRollNoLessThan(Integer rollNo);

//	@Query("select * from student s join user u on s.user_id and u.user_id where s.mobile=:mobile")
//	List<Student> findByMultiple(String mobile);

}
