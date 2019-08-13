package com.collaboration.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.JobDAO;
import com.coll.model.Job;

public class JobDAOTest
{
	static JobDAO jobDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("CollProj.Backend");
		context.refresh();
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	@Test
	public void addJobTest()
	{
		Job job=new Job();
		job.setDesignation("Programmer");
		job.setDescription("Has to know Coding");
		job.setCompanyName("BlueSoft Inc");
		job.setCtc(500000);
		job.setLastDateforApply(new Date());
		job.setLocation("pune");
		job.setSkills("Spring Boot,Angular Js,Restful Services,Hibernate");
		
		assertTrue("Problem in Adding Job Details",jobDAO.addJob(job));
	}
	@Test
	public void displayJobsTest()
	{
		List<Job>jobList=jobDAO.displayJob();
		assertTrue("Problem in Retriving the Jobs:",jobList.size()>0);
		for(Job job:jobList)
		{
			System.out.print(job.getDesignation()+":::");
			System.out.print(job.getDescription()+":::");
			System.out.print(job.getCompanyName()+":::");
			System.out.print(job.getCtc()+":::");
			System.out.print(job.getLocation());
		}
	}
	@Test
	public void deleteJobTest()
	{
		Job job=jobDAO.getJobDetails(954);
		assertTrue("Problem in Deleting a Job",jobDAO.deleteJob(job));
	}

}
