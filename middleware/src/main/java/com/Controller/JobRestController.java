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

import com.coll.dao.JobDAO;
import com.coll.model.Job;

@RestController

public class JobRestController 

{

	 @Autowired

	  JobDAO jobDAO;

	 

	 @PostMapping(value="/addJob")

	    public ResponseEntity<String> addJob(@RequestBody Job job)

	    {

	    	if(jobDAO.addJob(job))

	    	{

	    		return new  ResponseEntity<String>("Job Added",HttpStatus.OK);

	    	}

	    	else

	    	{

	    		return new  ResponseEntity<String>("Problem Occured",HttpStatus.NOT_FOUND);

	    	}

	    }



	    @GetMapping(value="/showAllJobs")

	    public ResponseEntity<List<Job>> showAllJobs()

	    {

	    	List<Job> jobList=jobDAO.displayJob();  	

	    	if(jobList.size()>0)

	    	{

	    		return new  ResponseEntity<List<Job>>(jobList,HttpStatus.OK);

	    	}

	    	else

	    	{

	    		return new  ResponseEntity<List<Job>>(jobList,HttpStatus.NOT_FOUND);

	    	}

	    }

	    @GetMapping(value="/deleteJob/{jobId")

	    public ResponseEntity<String> deleteJob(@PathVariable("jobId")int jobId)

	    {

	      	Job job=jobDAO.getJobDetails(jobId);

	    	if(jobDAO.deleteJob(job))

	    	{

	    		return new  ResponseEntity<String>("Job Deleted",HttpStatus.OK);

	    	}

	    	else

	    	{

	    		return new  ResponseEntity<String>("Problem Occured",HttpStatus.NOT_FOUND);

	    	}

	    }

	    @GetMapping(value="/getJob/{jobId")

	    public ResponseEntity<Job> getJob(@PathVariable("jobId")int jobId)

	    {

	      	Job job=jobDAO.getJobDetails(jobId);

	    		return new  ResponseEntity<Job>(job,HttpStatus.OK);

	    	}

	    }