package com.api.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.api.entities.creates.CreateUser;
import com.api.entities.gets.GetUser;

/***
 * 
 * @author sokchanny
 *
 */

@Repository
public interface UserRepository {
	
	public ArrayList<GetUser> getUsers();
	public boolean createUser(CreateUser createUser);
	public boolean deteleUser(String id);
	
}
