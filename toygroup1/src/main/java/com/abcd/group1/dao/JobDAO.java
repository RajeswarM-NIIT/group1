package com.abcd.group1.dao;

import java.util.List;

import com.abcd.group1.model.Job;

public interface JobDAO {

	public abstract void postJob(Job job);
	public abstract List<Job> getAllJobs();
}
