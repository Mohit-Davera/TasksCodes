package com.example.demo.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Student;

import java.awt.print.Pageable;
import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	List<Student> findByTech(String tech);
	List<Student> findByIdGreaterThan(int id);
}
