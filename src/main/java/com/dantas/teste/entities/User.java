package com.dantas.teste.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long cpf;
	
	private String name;
	private String email;
	
	
	public User() {
		
	}

	public User(Long cpf, String name, String email) {
		super();
		this.name = name;
		this.email = email;
		setCpf(cpf);
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {	
		this.cpf = cpf;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cpf, other.cpf);
	}	

}
