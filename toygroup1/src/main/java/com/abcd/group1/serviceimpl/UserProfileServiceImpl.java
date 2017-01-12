package com.abcd.group1.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcd.group1.dao.UserProfileDAO;
import com.abcd.group1.model.UserProfile;
import com.abcd.group1.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileDAO userProfileDao;
	
	public List<UserProfile> getProfiles() {		
		return userProfileDao.getProfiles();
	}

}
