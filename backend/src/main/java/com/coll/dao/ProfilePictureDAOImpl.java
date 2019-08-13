package com.coll.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.ProfilePicture;

@Repository("ProfilePictureDAO")

@Transactional

public class ProfilePictureDAOImpl implements ProfilePictureDAO

{ 

	@Autowired

	SessionFactory sessionFactory;

	



	public boolean addProfilePicture(ProfilePicture profilePicture) 

	{

		Session session=sessionFactory.openSession();

		session.saveOrUpdate(profilePicture);

		session.flush();

		return true;

	}



	public ProfilePicture getProfilePicture(String username) 

	{

		Session session=sessionFactory.openSession();

		ProfilePicture profilePic = (ProfilePicture)session.get(ProfilePicture.class, username);

		session.close();

		return profilePic;

	}

    

}