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

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;

@RestController

public class BlogRestController 

{

    @Autowired

  BlogDAO blogDAO;

	

    @GetMapping(value="/showAllBlogs")

    public ResponseEntity<List<Blog>> showAllBlogs()

    {

    	List<Blog> blogList=blogDAO.listBlogs();

    	

    	if(blogList.size()>0)

    	{

    		return new  ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);

    	}

    	else

    	{

    		return new  ResponseEntity<List<Blog>>(blogList,HttpStatus.NOT_FOUND);

    	}

    }

	

    @PostMapping(value="/addBlog")

    public ResponseEntity<String> addBlog(@RequestBody Blog blog)

    {

    	blog.setUsername("sam");

    	blog.setLikes(0);

    	blog.setDislikes(0);

    	blog.setCreateDate(new java.util.Date());

    	blog.setStatus("NA");

    	

    	if(blogDAO.addBlog(blog))

    	{

    		return new ResponseEntity<String>("Blog Added",HttpStatus.OK);

    	}

    	else

    	{

    		return new ResponseEntity<String>("Problem Occured",HttpStatus.NOT_FOUND);

    	}

    }

    @GetMapping(value="/deleteBlog/{blogId}")

    public ResponseEntity<String> deleteBlog(@PathVariable("blogId")int blogId)

    {

    	Blog blog=(Blog)blogDAO.getBlog(blogId);

    	

    	if(blogDAO.deleteBlog(blog))

    	{

    		return new  ResponseEntity<String>("Blog Deleted",HttpStatus.OK);

    	}

    	else

    	{

    		return new  ResponseEntity<String>("Problem Occured While Blog Adding",HttpStatus.NOT_FOUND);

    	}

    }

    @GetMapping(value="/incrementLikes/{blogId}")

    public ResponseEntity<String> incrementLikes(@PathVariable("blogId")int blogId)

    {

    	

    	if(blogDAO.incrementLikes(blogId))

    	{

    		return new  ResponseEntity<String>("Blog Likes Incremented",HttpStatus.OK);

    	}

    	else

    	{

    		return new  ResponseEntity<String>("Problem Occured While Blog Likes Incrementation",HttpStatus.NOT_FOUND);

    	}

    }

    @GetMapping(value="/incrementDisLikes/{blogId}")

    public ResponseEntity<String> incrementDisLikes(@PathVariable("blogId")int blogId)

    {

    	

    	if(blogDAO.incrementDisLikes(blogId))

    	{

    		return new  ResponseEntity<String>("Blog DisLikes Incremented",HttpStatus.OK);

    	}

    	else

    	{

    		return new  ResponseEntity<String>("Problem Occured While Blog DisLikes Incrementation",HttpStatus.NOT_FOUND);

    	}

    }

    @GetMapping(value="/approveBlog/{blogId}")

    public ResponseEntity<String> approveBlog(@PathVariable("blogId")int blogId)

    {

    	Blog blog=(Blog)blogDAO.getBlog(blogId);

    	

    	if(blogDAO.approveBlog(blog))

    	{

    		return new  ResponseEntity<String>("Blog Approved",HttpStatus.OK);

    	}

    	else

    	{

    		return new  ResponseEntity<String>("Problem Occured While Blog Approved",HttpStatus.NOT_FOUND);

    	}

    }

    @GetMapping(value="/rejectBlog/{blogId}")

    public ResponseEntity<String> rejectBlog(@PathVariable("blogId")int blogId)

    {

    	Blog blog=(Blog)blogDAO.getBlog(blogId);

    	

    	if(blogDAO.rejectBlog(blog))

    	{

    		return new  ResponseEntity<String>("Blog Rejected",HttpStatus.OK);

    	}

    	else

    	{

    		return new  ResponseEntity<String>("Problem Occured While Blog Rejection",HttpStatus.NOT_FOUND);

    	}

    }

    @PostMapping(value="/updateBlog")

    public ResponseEntity<String> updateBlog(@RequestBody Blog blog)

    {

    	Blog tempBlog=blogDAO.getBlog(blog.getBlogId());

    	tempBlog.setBlogName(blog.getBlogName());

    	tempBlog.setBlogContent(blog.getBlogContent());

    	if(blogDAO.updateBlog(tempBlog))

    	{

    		return new ResponseEntity<String>("Blog Updated",HttpStatus.OK);

    	}

    	else

    	{

    		return new ResponseEntity<String>("Problem Occured While Blog Updating",HttpStatus.NOT_FOUND);

    	}

    }

    @GetMapping(value="/getBlog/{blogId}")

    public ResponseEntity<Blog> getBlog(@PathVariable("blogId")int blogId)

    {

    	Blog blog=(Blog)blogDAO.getBlog(blogId);

    

    	return new ResponseEntity<Blog>(blog,HttpStatus.OK);

    	}

    }