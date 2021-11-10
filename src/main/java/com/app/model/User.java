package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "user_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE User SET deleted=true WHERE id=?")
//@Where(clause = "deleted = false")
public class User {

	private Boolean deleted = Boolean.FALSE;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Enter User First Name")
	private String userName;
	
	@NotNull(message = "Enter sur Name")
	private String surName;
	
	@NotNull(message = "Enter Date Of Birth Date")
	private String dateOfBirth;
	
	@NotNull(message = "Enter Join Date")
	private String dateOfJoin;
	
	@NotNull(message = "Enter Address")
	private  String address;
	
	@NotNull(message = "Enter Valid Pincode")
	private int pincode;
}
