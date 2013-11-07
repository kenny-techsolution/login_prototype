package com.dovesquare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dovesquare.domain.Account;
import com.dovesquare.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository repository;

	public Account findAccountByUserId(String userid) {
		return repository.findByuserid(userid);
	}

}