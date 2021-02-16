package com.educandoweb.curse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curse.entities.Order;
import com.educandoweb.curse.repositories.OrderRepository;

// A classe tem que estar registrada como um componente do spring (através da anotation @Component, @Repository ou @Service)
//para que a injeção de dependencialá no OrderResouces funcione - escolha a anotation de acordo com o tipo da sua classe
@Service
public class OrderService {
	
	//injeção de dependência - OrderService depende de OrderRepository
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order finBydId(Long id){
		Optional <Order> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
