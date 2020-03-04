package com.airconnect.user.service;

import java.util.List;

import com.airconnect.user.model.UserProfile;

public interface UserProfileService {
	 
    UserProfile findById(int id);
 
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
     
}
