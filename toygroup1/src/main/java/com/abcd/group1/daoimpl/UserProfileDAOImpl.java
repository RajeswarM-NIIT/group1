package com.abcd.group1.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abcd.group1.dao.UserProfileDAO;
import com.abcd.group1.model.UserProfile;

@Repository
public class UserProfileDAOImpl implements UserProfileDAO {
	@Autowired
	private SessionFactory sessionFactory;	
	
	public List<UserProfile> getProfiles() {
		
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("from UserProfile");
		List <UserProfile> data = qr.list();
		ses.close();
		return data;
		
	}
}
