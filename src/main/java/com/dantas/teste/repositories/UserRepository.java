package com.dantas.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dantas.teste.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByCpf(Long cpf);
}
