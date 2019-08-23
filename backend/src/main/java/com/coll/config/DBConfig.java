package com.coll.config;

import java.util.Properties;

import javax.management.Notification;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.model.Blog;
import com.coll.model.BlogComment;
import com.coll.model.Friend;
import com.coll.model.Job;
import com.coll.model.Message;
import com.coll.model.OutputMessage;
import com.coll.model.ProfilePicture;
import com.coll.model.UserDetail;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	
	public DBConfig(){
		System.out.println("-----DBCOnfiguration class instantiated----------");
	}
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		System.out.println("----Session Factory Object created-----");
		//Class classes[]=new Class[]{UserDetail.class,Job.class,Blog.class,Message.class,Notification.class,BlogComment.class,ProfilePicture.class,Friend.class};//
		lsf.addAnnotatedClass(Blog.class);
		lsf.addAnnotatedClass(BlogComment.class);
		lsf.addAnnotatedClass(Friend.class);
		lsf.addAnnotatedClass(Job.class);
		lsf.addAnnotatedClass(Message.class);
		lsf.addAnnotatedClass(OutputMessage.class);
		lsf.addAnnotatedClass(ProfilePicture.class);
		lsf.addAnnotatedClass(UserDetail.class);
		return lsf.buildSessionFactory();
		
		
		
	}
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	    dataSource.setUsername("SYSTEM");
	    dataSource.setPassword("#Praveen123");
	    System.out.println("--Data source created-----");
	    return dataSource;
	    
	}
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		System.out.println("---Transaction Management created-------");
		return new HibernateTransactionManager(sessionFactory());
	}

}