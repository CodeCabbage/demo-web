package com.handwriting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handwriting.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	
}
