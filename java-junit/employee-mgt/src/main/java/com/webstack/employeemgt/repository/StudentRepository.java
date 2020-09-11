package com.webstack.employeemgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webstack.employeemgt.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
