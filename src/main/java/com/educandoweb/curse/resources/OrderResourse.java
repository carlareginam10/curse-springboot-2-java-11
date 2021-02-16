package com.educandoweb.curse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curse.entities.Order;
import com.educandoweb.curse.services.OrderService;

//Essa classe disponibiliza um recurso web correspondente a entidade Order

// para identificar que essa classe é um recurso web que é implementado por um controlador rest, precisa inserir a anotation
//em cima no nome da classe

@RestController
//value contem o caminho do recurso
@RequestMapping (value ="/orders")
public class OrderResourse {
	
	//injetando dependencia para o service por meio da anotation - OrderResourse depende do OrderService
	@Autowired
	private OrderService service;
	
	//método endpoint pra acessar os usuários
	//ResponseEntity tipo específico do spring pra retornar respostas de requisições web
	@GetMapping
	public ResponseEntity<List> findAll(){
		
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	//indica que vou passar um parametro na url
	@GetMapping(value = "/{id}")
	public ResponseEntity <Order> findById(@PathVariable Long id){
		Order obj = service.finBydId(id);
		return ResponseEntity.ok().body(obj);
	}

}
