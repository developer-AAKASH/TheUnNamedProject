package com.practise.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.User.model.User;
import com.practise.User.services.UserService;

@RequestMapping("api/user")
@RestController
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController( UserService userService ) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity addUser( @RequestBody User user ) {
		System.out.println("---------From User-Controller----Add-User------");
		
		var returnedUser = userService.addUser(user);
		
		if( returnedUser instanceof User ) {
			return ResponseEntity.status(200).body(returnedUser);
		} else {
			return ResponseEntity.status(400).body(returnedUser);
		}
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		System.out.println("---------From User-Controller----Get-All-User------");
		return userService.getAllUser();
	}
	
	@GetMapping(path="{id}")
	public User getUserById( @PathVariable("id") Integer userId ) {
		System.out.println("---------From User-get-By-ID---------");
		return userService.getUserById(userId);
	}
	
	@PutMapping(path="{id}")
	public User update( @RequestBody User user, @PathVariable("id") Integer userId ) {
		System.out.println("------Controller-Update----");
		
		
		return userService.updateUser(user, userId);
	}
	
	@DeleteMapping(path="{id}")
	public User delete( @PathVariable("id") Integer userId ) {
		System.out.println("--------Controller-Delete--------");
		return userService.deleteUser(userId);
	}
	
}
