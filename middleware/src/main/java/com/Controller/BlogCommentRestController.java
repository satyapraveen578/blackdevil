package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.BlogCommentDAO;
import com.coll.model.BlogComment;

@RestController
public class BlogCommentRestController 
{
 @Autowired
     BlogCommentDAO blogCommentDAO;

		
      @GetMapping(value="/getAllBlogComments/{blogId}")

	    public ResponseEntity<List<BlogComment>> getAllBlogComment(@PathVariable("blogId")int blogId)
         {
	    	List<BlogComment> listBlogComments=blogCommentDAO.listBlogComments(blogId);	    	
            if(listBlogComments.size()>0)
	    	{
	    		return new  ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new  ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.NOT_FOUND);
	    	}
	    }

	     	    @PostMapping(value="/addComment",produces=MediaType.TEXT_PLAIN_VALUE)
	    public ResponseEntity<String> addComment(@RequestBody BlogComment comment)
	    {
	    	if(blogCommentDAO.addComment(comment))
	    	{
	    		return new  ResponseEntity<String>("Blog Comment Added Successfully",HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new  ResponseEntity<String>("Problem Occured While Adding Comment",HttpStatus.NOT_FOUND);
	    	}
	    }

	     	    @GetMapping(value="/deleteComment/{commentId}",produces=MediaType.TEXT_PLAIN_VALUE)
	     	    public ResponseEntity<String>deleteComment(@PathVariable("commentId")int commentId)
	     	    {
	     	    	BlogComment comment=blogCommentDAO.getBlogComment(commentId);
	     	    	if(blogCommentDAO.deleteComment(comment))
	     	    	{
	     	    		return new ResponseEntity<String>("Blog Comment Deleted Successfully",HttpStatus.OK);
	     	    	}
	     	    	else
	     	    	{
	     	    		return new ResponseEntity<String>("Problem Occured While Deleting Blog Comment",HttpStatus.NOT_FOUND);
	     	    		
	     	    	}
	     	    }
}