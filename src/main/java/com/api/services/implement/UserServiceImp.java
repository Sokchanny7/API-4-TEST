package com.api.services.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entities.creates.CreateUser;
import com.api.entities.gets.GetUser;
import com.api.repositories.UserRepository;
import com.api.services.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public boolean createUser(CreateUser createUser) {		
		return userRepo.createUser(createUser);
	}

	@Override
	public boolean deteleUser(String id) {		
		return userRepo.deteleUser(id);
	}

	@Override
	public ArrayList<GetUser> getUsers() {		
		return this.userRepo.getUsers();
	}

}
