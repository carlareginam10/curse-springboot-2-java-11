package com.educandoweb.curse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curse.entities.Product;
import com.educandoweb.curse.repositories.ProductRepository;

// A classe tem que estar registrada como um componente do spring (através da anotation @Component, @Repository ou @Service)
//para que a injeção de dependencialá no ProductResouces funcione - escolha a anotation de acordo com o tipo da sua classe
@Service
public class ProductService {
	
	//injeção de dependência - ProductService depende de ProductRepository
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product finBydId(Long id){
		Optional <Product> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
