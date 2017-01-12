package com.abcd.group1.dao;

import java.util.List;

import com.abcd.group1.model.Blog;


public interface BlogDAO {
	public void createBlog(Blog b);
	public List<Blog> getBlogList();
	public void deleteBlog(Blog b);	
	public Blog getCompleteBlog(String bid);
}
