package com.dantas.teste.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.teste.entities.User;
import com.dantas.teste.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public User insert(User obj) {
		return repository.save(obj);
	}

}
