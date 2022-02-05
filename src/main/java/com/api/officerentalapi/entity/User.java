package com.api.officerentalapi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
@Entity
@Getter
@Setter
@ToString
@Table(name = "user")


public class User {

	public User() {
		
	}
	
    public User(String name, String lastname) {
    	super();
        this.name = name;
        this.lastname = lastname;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", updatable = false)
     int userid;
    
    @Column(name="name", updatable=true)
     private String name;
    

	@Column(name="lastname", updatable=true)
     private String lastname;
	
    public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
