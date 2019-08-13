package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.FriendDAO;
import com.coll.model.Friend;
import com.coll.model.UserDetail;

@RestController

public class FriendRestController 

{

	 @Autowired

	  FriendDAO friendDAO;

	

	 @GetMapping(value="/showPendingFriendRequest/{username}")

	    public ResponseEntity<List<Friend>> showPendingFriendRequest(@PathVariable("username")String username)

	    {

	    	List<Friend> friendList=friendDAO.showPendingFriendRequests(username);	    	

	    	if(friendList.size()>0)

	    	{

	    		return new  ResponseEntity<List<Friend>>(friendList,HttpStatus.OK);

	    	}

	    	else

	    	{

	    		return new  ResponseEntity<List<Friend>>(friendList,HttpStatus.NOT_FOUND);

	    	}

	    }

	 @GetMapping(value="/showFriendList/{username}")

	    public ResponseEntity<List<Friend>> showFriendList(@PathVariable("username")String username)

	    {

	    	List<Friend> friendList=friendDAO.showFriendList(username);	    	

	    	if(friendList.size()>0)

	    	{

	    		return new  ResponseEntity<List<Friend>>(friendList,HttpStatus.OK);

	    	}

	    	else

	    	{

	    		return new  ResponseEntity<List<Friend>>(friendList,HttpStatus.NOT_FOUND);

	    	}

	    }

	 @PostMapping(value="/sendFriendRequest")

	    public ResponseEntity<String> sendFriendRequest(@RequestBody Friend friend)

	    {

	    	if(friendDAO.sendFriendRequest(friend))

	    	{

	    		return new  ResponseEntity<String>("New Friend Added",HttpStatus.OK);

	    	}

	    	else

	    	{

	    		return new  ResponseEntity<String>("Problem Occured While Adding Friend Request",HttpStatus.NOT_FOUND);

	    	}

	    }

	 @GetMapping(value="/deleteFriendRequest/{friendId}")

	    public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendId")int friendId)

	    {    	

	    	if(friendDAO.deleteFriendRequest(friendId))

	    	{

	    		return new  ResponseEntity<String>("Deleted Friend Request",HttpStatus.OK);

	    	}

	    	else

	    	{

	    		return new  ResponseEntity<String>("Problem Occured",HttpStatus.NOT_FOUND);

	    	}

	    }

	 @GetMapping(value="/showSuggestedFriendList/{username}")

	    public ResponseEntity<List<UserDetail>> showSuggestedFriendList(@PathVariable("username")String username)

	    {

	    	List<UserDetail> suggestedFriendList=friendDAO.showSuggestedFriends(username);	    	

	    	if(suggestedFriendList.size()>0)

	    	{

	    		return new  ResponseEntity<List<UserDetail>>(suggestedFriendList,HttpStatus.OK);

	    	}

	    	else

	    	{

	    		return new  ResponseEntity<List<UserDetail>>(suggestedFriendList,HttpStatus.NOT_FOUND);

	    	}

	    }

}
