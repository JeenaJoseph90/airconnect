package com.airconnect.user.dao;

import java.util.List;

import com.airconnect.user.model.UserProfile;

public interface UserProfileDao {
	 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}	
