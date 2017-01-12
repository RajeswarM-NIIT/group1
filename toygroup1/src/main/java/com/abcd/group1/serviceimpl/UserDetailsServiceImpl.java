package com.abcd.group1.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcd.group1.dao.UserDetailsDAO;
import com.abcd.group1.model.UserDetails;
import com.abcd.group1.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDAO userDetailsDao;
	
	public List<UserDetails> getUsers() {
		return userDetailsDao.getUsers();		 
	}
	public UserDetails getUserById(String uid){
		return userDetailsDao.getUserById(uid);
	}
	public void addUser(UserDetails ud){
		userDetailsDao.addUser(ud);
	}
	public UserDetails updateUser(String uid,UserDetails ud){
		return userDetailsDao.updateUser(uid,ud);
	}

	public void deleteUser(String uid){
		userDetailsDao.deleteUser(uid);
	}
	
	public UserDetails logincheck(UserDetails ud){
		return userDetailsDao.logincheck(ud);
	}
	public UserDetails registerUser(UserDetails ud){
		return userDetailsDao.registerUser(ud);
	}
	
	public void updateUser1(UserDetails ud){
		userDetailsDao.updateUser1(ud);
	}
}
