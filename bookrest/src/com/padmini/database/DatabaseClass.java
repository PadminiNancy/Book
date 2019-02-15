package com.padmini.database;

import java.util.HashMap;
import java.util.Map;

import com.padmini.model.Message;
import com.padmini.model.Profile;

public class DatabaseClass {
	
	public static Map<Long, Message> message = new HashMap<>();
	public static Map<Long, Profile> profile = new HashMap<>();
	
	
	
	public static void setMessage(Map<Long, Message> message) {
		DatabaseClass.message = message;
	}
	public static Map<Long, Profile> getProfile() {
		return profile;
	}
	public static void setProfile(Map<Long, Profile> profile) {
		DatabaseClass.profile = profile;
	}
	public static Map<Long, Message> getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
   
	
}
