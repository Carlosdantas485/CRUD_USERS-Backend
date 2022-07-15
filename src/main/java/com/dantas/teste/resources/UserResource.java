package com.dantas.teste.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dantas.teste.entities.User;
import com.dantas.teste.repositories.UserRepository;
import com.dantas.teste.services.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@Autowired
	UserRepository userRepository;

	@GetMapping
	public ResponseEntity<List> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{cpf}")
	public ResponseEntity<User> findById(@PathVariable Long cpf) {
		User obj = service.findById(cpf);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/cpf/{cpf}", method=RequestMethod.GET)
	public @ResponseBody User filter(@PathVariable Long cpf) {
		return userRepository.findByCpf(cpf);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}").buildAndExpand(obj.getCpf()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{cpf}")
	public ResponseEntity<Void> delete(@PathVariable Long cpf) {
		service.delet(cpf);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{cpf}")
	public ResponseEntity<User> update(@PathVariable Long cpf, @RequestBody User obj) {
		obj = service.update(cpf, obj);
		return ResponseEntity.ok().body(obj);
	}
}
