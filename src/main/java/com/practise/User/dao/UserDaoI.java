package com.practise.User.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practise.User.model.User;

public interface UserDaoI extends JpaRepository<User, Integer> {

}
