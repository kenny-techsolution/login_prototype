package com.dovesquare.domain;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;

  @Size(min=6, max=20,
          message="The password must be at least 6 characters long.")
  @Range(min = 1, max = 150)
  private String password;

  @Size(min=3, max=50, message=
      "Your full name must be between 3 and 50 characters long.")
  private String fullName;

  @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", 
          message="Invalid email address.")
  private String email;
  
  private String job;
  
  private boolean updateByEmail;
  
//  public User() {
//	  this.id = new Long(123);
//	  this.password = "test";
//	  this.fullName = "kenny chung";
//      this.job = "developer";
//	  this.email = "yoyocicada@gmail.com";
//  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getFullName() {
    return fullName;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getJob() {
    return job;
  }

  public void setEmail(String email) {
	    this.email = email;
	  }

	  public String getEmail() {
	    return email;
	  }
  
  public void setUpdateByEmail(boolean updateByEmail) {
    this.updateByEmail = updateByEmail;
  }
}
