package com.dovesquare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dovesquare.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByuserid(String userid);
}
