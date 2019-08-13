package com.collaboration.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.UserDAO;

import com.coll.model.UserDetail;

public class UserDAOTest
{
static UserDAO userDAO;
@BeforeClass
public static void executeFirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("collProj.Backend");
	context.refresh();
	userDAO=(UserDAO)context.getBean("userDAO");
}
@Test
public void registeruserTest()
{
	UserDetail user=new UserDetail();
	user.setUsername("sam");
	user.setPassword("sam123");
	user.setName("sam Joseph");
	user.setEmailId("sam123@gmail.com");
	user.setAddress("Chennai");
	user.setMobileNo("9876543210");
	user.setRole("ROLE_USER");
	assertTrue("Problem in Adding the User",userDAO.registeruser(user));
}
@Test
public void updateUsertest()
{
	UserDetail user=userDAO.getUserDetail("sam");
	user.setAddress("Chennai");
	assertTrue("Problem in Updating the user info",userDAO.updateUser(user));
}
@Test
public void checkUserCredentialTest()
{
	UserDetail user=new UserDetail();
	user.setUsername("sam");
	user.setPassword("sam123");
	assertNotNull("UserName and Password is not Matching",userDAO.checkUserCredential(user));
}
}
