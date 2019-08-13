package com.collaboration.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;

public class BlogDAOTest
{
	static BlogDAO blogDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("CollProj.Backend");
		context.refresh();
		blogDAO=(BlogDAO)context.getBean("blogDAO");
		
	}
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogName("Core Java");
		blog.setBlogContent("The Vanilla Java Content");
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(0);
		blog.setDislikes(0);
		blog.setStatus("P");
		blog.setUsername("Sam");
		assertTrue("Problem in Adding a Blog",blogDAO.addBlog(blog));
	}
	@Test
	public void updateBlogTest()
	{
		Blog blog=blogDAO.getBlog(952);
		blog.setBlogContent("This Blog Contains the Java Standard Edition Content.");
		assertTrue("Problem in Updating the Blog",blogDAO.updateBlog(blog));
	}
	@Test
	public void approveBlogTest()
	{
		Blog blog=blogDAO.getBlog(952);
		assertTrue("Problem in Approving the Blog",blogDAO.approveBlog(blog));
		
	}
@Test
public void rejectBlogTest()
{
	Blog blog=blogDAO.getBlog(952);
	assertTrue("Problem in Rejecting the Blog",blogDAO.rejectBlog(blog));
}
@Test
public void incrementLikesBlogTest()
{
	assertTrue("Problem in Approving the Blog",blogDAO.incrementLikes(952));
}
@Test
public void deleteBlogTest()
{
	Blog blog=blogDAO.getBlog(954);
	assertTrue("Problem in Deleting a Blog",blogDAO.deleteBlog(blog));
	
}
}
