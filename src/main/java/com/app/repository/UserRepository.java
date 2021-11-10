package com.app.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="from User where userName=:userName")
	public List<User>findByName(String userName);
	
	@Query(value="from User where surName=:surName")
	public List<User>findBySurName(String surName);
	
	@Query(value="from User where pincode=:pincode")
	public List<User>findByPincode(int pincode);
	
	@Query(value="from User where dob=:dob")
	public List<User>findByDob(String dob);
	
	@Query(value="from User where joinDate=:joinDate")
	public List<User>findByJoinDate(String joinDate);
	
	@Query(value = "from User where userName= :userName or surName=:surName")
	public List<User>findByNameOrSurName(String userName, String surName);

}
