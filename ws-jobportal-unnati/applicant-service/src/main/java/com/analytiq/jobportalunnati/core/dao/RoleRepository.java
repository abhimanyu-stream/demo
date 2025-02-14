package com.analytiq.jobportalunnati.core.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.analytiq.jobportalunnati.core.model.Role;
import com.analytiq.jobportalunnati.core.model.RoleEnum;



public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Optional<Role> findByName(RoleEnum name);

}
