package com.educandoweb.curse.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curse.entities.User;

//Essa classe disponibiliza um recurso web correspondente a entidade User

// para identificar que essa classe é um recurso web que é implementado por um controlador rest, precisa inserir a anotation
//em cima no nome da classe

@RestController
@RequestMapping (value ="/users") //value contem o caminho do recurso
public class UserResourse {
	
	//método endpoint pra acessar os usuários
	//ResponseEntity tipo específico do spring pra retornar respostas de requisições web
	@GetMapping
	public ResponseEntity<User> findAll(){
		// o L na frente do 1 quer dizer que é um long
		User u = new User(1L, "Maria","maria@gmail", "99999", "12345");
		return ResponseEntity.ok().body(u);
	}
	

}
