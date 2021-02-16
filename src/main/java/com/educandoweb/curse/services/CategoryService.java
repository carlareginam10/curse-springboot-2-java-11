package com.educandoweb.curse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curse.entities.Category;
import com.educandoweb.curse.repositories.CategoryRepository;

// A classe tem que estar registrada como um componente do spring (através da anotation @Component, @Repository ou @Service)
//para que a injeção de dependencialá no CategoryResouces funcione - escolha a anotation de acordo com o tipo da sua classe
@Service
public class CategoryService {
	
	//injeção de dependência - CategoryService depende de CategoryRepository
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category finBydId(Long id){
		Optional <Category> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
