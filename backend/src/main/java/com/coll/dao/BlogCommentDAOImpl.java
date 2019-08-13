package com.coll.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.BlogComment;

@Repository("BlogCommentDAO")

@Transactional

public class BlogCommentDAOImpl implements BlogCommentDAO

{

	@Autowired

	SessionFactory sessionFactory;

	



	public boolean addComment(BlogComment blogComment) 

	{

		try

		{

			sessionFactory.getCurrentSession().save(blogComment);

			return true;

		}

		catch(Exception e)

		{	

		return false;

	}

}



	public boolean deleteComment(BlogComment blogComment) 

	{

		try

		{

			sessionFactory.getCurrentSession().delete(blogComment);

			return true;

		}

		catch(Exception e)

		{	

		return false;

	}

}



	public BlogComment getBlogComment(int blogCommentId) 

	{

		Session session=sessionFactory.openSession();

		BlogComment blogComment=(BlogComment) session.get(BlogComment.class, blogCommentId);

		session.close();

		return blogComment;

	}



	public List<BlogComment> listBlogComments(int blogId) 

	{

		Session session=sessionFactory.openSession();

		Query query=session.createQuery("from BlogComment");

		query.setParameter("blogid", blogId);

		List<BlogComment> commentList=query.list();

		return commentList;

	}



}