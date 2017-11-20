package com.handwriting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handwriting.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	
}
