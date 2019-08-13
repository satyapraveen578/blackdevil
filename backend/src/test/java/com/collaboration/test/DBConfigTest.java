package com.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.config.DBConfig;

public class DBConfigTest {

	
		  public static void main(String arg[])
		  {
			  
			  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
			 context.scan("com.coll");
			  context.refresh();
			  System.out.println("Success");
		  }
			

		}

