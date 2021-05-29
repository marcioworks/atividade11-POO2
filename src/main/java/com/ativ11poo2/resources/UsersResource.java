package com.ativ11poo2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ativ11poo2.domain.Users;
import com.ativ11poo2.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersResource {

	@Autowired
	private UsersService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Users user){
		user = service.createUser(user);
		
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable Integer id){
		 service.removeUser(id);
		 
		 return ResponseEntity.ok().body("user with id: " + id + " removed!");
	}
}
