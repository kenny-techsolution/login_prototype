//TODO: change this to UserRepository?
package com.dovesquare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dovesquare.login_prototype.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

}
