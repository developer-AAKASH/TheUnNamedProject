package com.practise.User.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practise.User.model.User;

@Repository("user")
public class UserDao {

	@Autowired
	UserDaoI userDao;
	
	public User addUser( final User user ) {
		userDao.save( user );
		return user;
	}
	
	public List< User > getAllUsers(){
		return userDao.findAll();
	}
	
	public User getUserById( final Integer userId ) {
		return userDao.findById(userId).orElse(null);
	}
	
	public User updateUser( final User user, final Integer userId ) {
		User oldUser = getUserById(userId);
		
		oldUser.setFirstName( user.getFirstName() );
		oldUser.setLastName( user.getLastName() );
		
		
		return userDao.save(oldUser);
	}
	
	public User updatePassword( final User user, final Integer userId ) {
		User oldUser = getUserById(userId);
		
		oldUser.setPassword( user.getPassword() );
		
		return userDao.save(oldUser);
	}
	
	public User deleteUser( final Integer userId ) {
		User oldUser = getUserById(userId);
		
		oldUser.setIsActive(0);
		
		return userDao.save(oldUser);
	}
}
