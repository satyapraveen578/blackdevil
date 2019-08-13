package com.collaboration.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.FriendDAO;

import com.coll.model.Friend;
import com.coll.model.UserDetail;

public class FriendDAOTest
{
static FriendDAO friendDAO;
@BeforeClass
public static void executeFirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("CollProj.Backend");
	context.refresh();
	friendDAO=(FriendDAO)context.getBean("friendDAO");
}
@Test
public void sendFriendRequestTest()
{
	Friend friend=new Friend();
	friend.setUsername("sam");
	friend.setFriendusername("john");
	friend.setStatus("P");
	assertTrue("Problem in Sending Friend Request",friendDAO.sendFriendRequest(friend));
	
}
@Test
public void acceptFriendRequest()
{
	assertTrue("Problem in Accepting FriendRequest",friendDAO.acceptFriendRequest(952));
}
@Test
public void deleteFriendRequest()
{
assertTrue("Problem in Deleting Friend Request",friendDAO.deleteFriendRequest(952));
}
@Test
public void showSuggestedFriendListtest()
{
	List<UserDetail>suggestedFriendList=friendDAO.showSuggestedFriends("john");
	assertTrue("Problem in Retriving the data",suggestedFriendList.size()>0);
	for(UserDetail user:suggestedFriendList)
	{
		System.out.print(user.getUsername()+":::");
		System.out.println(user.getName()+":::");
		
	}
}
@Test
public void showFriendListtest()
{
	List<Friend>friendList=friendDAO.showFriendList("john");
	assertTrue("Problem in Retriving the data",friendList.size()>0);
	for(Friend friend:friendList)
	{
		System.out.print(friend.getUsername());
		System.out.println(friend.getFriendusername());
	}
}
@Test
public void showPendingFriendListtest()
{
	List<Friend>pendingfriendList=friendDAO.showPendingFriendRequests("username");
	assertTrue("Problem in Retriving the data",pendingfriendList.size()>0);
	for(Friend friend:pendingfriendList)
	{
		System.out.print(friend.getUsername());
		System.out.println(friend.getFriendusername());
	}
}

}
