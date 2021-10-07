package com.practise.User.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.practise.User.dao.UserDao;
import com.practise.User.model.User;

@Service
public class UserService {

	private UserDao userDao;
	
	public UserService( @Qualifier("user") UserDao userDao ) {
		this.userDao = userDao;
	}
	
	public User addUser( User user ) {
		return userDao.addUser(user);
	}
	
	public List<User> getAllUser(){
		return userDao.getAllUsers();
	}
	
	public User getUserById( final Integer userId ) {
		return userDao.getUserById(userId);
	}
	
	public User updateUser( final User user, final Integer userId ) {
		return userDao.updateUser(user, userId);
	}
	
	public User forgotPassword( final User user, final Integer userId ) {
		return userDao.updatePassword(user, userId);
	}
	
	public User deleteUser( final Integer userId ) {
		return userDao.deleteUser(userId);
	}
}
