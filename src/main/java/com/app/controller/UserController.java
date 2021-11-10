package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@RequestMapping("/hi")
	public String hello() {
		return "Welcome User";
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		System.out.println("success");
		return repo.save(user);
	}
	
	//@RequestMapping("/getAllUser")
	@GetMapping("/user")
	public List<User> getAllUser(){
		List<User> user = new ArrayList<>();
		//Collections.sort(user);
		repo.findAll().forEach(user1 -> user.add(user1));
		return user;
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@Valid @PathVariable int id) {
		return repo.findById(id).get();
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		System.out.println(id);
		repo.deleteById(id);
	}
	
	@PutMapping("/user/{id}")
	public User update(@PathVariable int id,@RequestBody User user1) {
		User user =null;
		Optional<User> u= repo.findById(id);
		if(u.isPresent()) {
			user = u.get();
			user.setUserName(user1.getUserName());
			user.setSurName(user1.getSurName());
			user.setDateOfBirth(user1.getDateOfBirth());
			user.setDateOfJoin(user1.getDateOfJoin());
			user.setAddress(user1.getAddress());
			user.setPincode(user1.getPincode());
		}
		
		return repo.save(user);
	}
	
	
	@GetMapping("/searchByName/{userName}")
	public List<User> getByName(@PathVariable String userName) { 
		return repo.findByName(userName);
	}
	
	

	
	
	
	

}
