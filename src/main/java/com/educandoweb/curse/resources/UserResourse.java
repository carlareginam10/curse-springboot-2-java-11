package com.educandoweb.curse.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.curse.entities.User;
import com.educandoweb.curse.services.UserService;

//Essa classe disponibiliza um recurso web correspondente a entidade User

// para identificar que essa classe é um recurso web que é implementado por um controlador rest, precisa inserir a anotation
//em cima no nome da classe

@RestController
//value contem o caminho do recurso
@RequestMapping (value ="/users")
public class UserResourse {
	
	//injetando dependencia para o service por meio da anotation - UserResourse depende do UserService
	@Autowired
	private UserService service;
	
	//método endpoint pra acessar os usuários
	//ResponseEntity tipo específico do spring pra retornar respostas de requisições web
	@GetMapping
	public ResponseEntity<List> findAll(){
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	//indica que vou passar um parametro na url
	@GetMapping(value = "/{id}")
	public ResponseEntity <User> findById(@PathVariable Long id){
		User obj = service.finBydId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
