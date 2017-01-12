package com.abcd.group1.dao;

import com.abcd.group1.model.UploadFile;

public interface FileDAO {

	public abstract void uploadFile(UploadFile file);
	
	public abstract UploadFile getFile(String username);
}
