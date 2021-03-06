package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="jobidseq",sequenceName="jobid_seq")
public class Job
{
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="jobidseq")
int jobId;
String designation;
String description;
String companyName;
String location;
int ctc;
Date lastDateforApply;
String skills;
public int getJobId() {
	return jobId;
}
public void setJobId(int jobId) {
	this.jobId = jobId;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public int getCtc() {
	return ctc;
}
public void setCtc(int ctc) {
	this.ctc = ctc;
}
public Date getLastDateforApply() {
	return lastDateforApply;
}
public void setLastDateforApply(Date lastDateforApply) {
	this.lastDateforApply = lastDateforApply;
}
public String getSkills() {
	return skills;
}
public void setSkills(String skills) {
	this.skills = skills;
}
}