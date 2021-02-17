package com.educandoweb.curse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curse.entities.User;
import com.educandoweb.curse.repositories.UserRepository;

// A classe tem que estar registrada como um componente do spring (através da anotation @Component, @Repository ou @Service)
//para que a injeção de dependencialá no UserResouces funcione - escolha a anotation de acordo com o tipo da sua classe
@Service
public class UserService {
	
	//injeção de dependência - UserService depende de UserRepository
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User finBydId(Long id){
		Optional <User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
}
