package com.api.services;


import java.util.ArrayList;

import com.api.entities.creates.CreateUser;
import com.api.entities.gets.GetUser;

public interface UserService {
	public ArrayList<GetUser> getUsers();
	public boolean createUser(CreateUser createUser);
	public boolean deteleUser(String id);
}
