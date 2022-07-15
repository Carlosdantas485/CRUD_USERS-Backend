package com.dantas.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.teste.entities.User;
import com.dantas.teste.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long cpf) {
		Optional<User> obj = repository.findById(cpf);
		return obj.get();
	}

//	public User findByCpf(String cpf) {
//		Optional<User> obj = repository.findByCpf(cpf);
//		return obj.get();
//	}
	
	
	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delet(Long cpf) {
		repository.deleteById(cpf);

	}

	public User update(Long cpf, User obj) {
		User entity = repository.getReferenceById(cpf);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
	}
	
}
