package com.coll.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.UserDetail;

@Repository("UserDAO")

@Transactional

public class UserDAOImpl implements UserDAO

{

	@Autowired

	SessionFactory sessionFactory;

	



	public boolean registeruser(UserDetail user) 

	{

		try

		{

			sessionFactory.getCurrentSession().save(user);

			return true;

		}

		catch(Exception e)

		{

		return false;

	}

}



	public UserDetail getUserDetail(String username) 

	{

		Session session=sessionFactory.openSession();

		UserDetail user=(UserDetail) session.get(UserDetail.class, username);

		session.close();

		return user;

	}



	public UserDetail checkUserCredential(UserDetail user) 

	{

		Session session=sessionFactory.openSession();

		Query query=session.createQuery("from UserDetail where username=:uname and password=:passwd");

		query.setParameter("uname", user.getUsername());

		query.setParameter("passwd", user.getPassword());

		UserDetail tempUser=(UserDetail)query.list().get(0);

		

		if(tempUser!=null)

			return tempUser;

		else		

		return null;

	}



	public boolean updateUser(UserDetail user) 

	{



		try

		{

			sessionFactory.getCurrentSession().update(user);

			return true;

		}

		catch(Exception e)

		{

		return false;

	}



	}

}