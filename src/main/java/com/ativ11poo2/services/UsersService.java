package com.ativ11poo2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ativ11poo2.domain.Users;
import com.ativ11poo2.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repo;
	
	
	public Users createUser(Users user){
		user.setId(null);
		
		return repo.save(user);
	}
	
	public void removeUser(Integer id) {
		 repo.deleteById(id);
	}
}
