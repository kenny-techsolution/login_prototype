package com.dovesquare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dovesquare.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
}
