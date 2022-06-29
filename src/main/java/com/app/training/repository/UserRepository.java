package com.app.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.training.model.User;

/*
 * This document, is the who make the connection to the BD with Spring, this is going to make all the process, as create, delete, etc.
 * */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	void deleteByFullname(String fullname);/*it's the same that: DELETE FROM USERS where full_name = ?*/
	
	@Modifying
	@Query("delete from User u where u.password= ?1")
	void deleteBypassword(String password);

}
