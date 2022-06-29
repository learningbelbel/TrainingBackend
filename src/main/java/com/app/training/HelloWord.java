package com.app.training;

//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-word")
public class HelloWord {
	
	@GetMapping("/{nombre}")
	public String greeting(@PathVariable("nombre") String nombre) {
		
		if(nombre.length() > 10) {
			throw new RuntimeException("El nombre tiene mas de 10 caracteres");
		}
		return String.format("hello %s ", nombre);
		
	}
	
	@PostMapping
	public Usuario createUser(@RequestBody Usuario usuario) {
		usuario.setAutenticado(true);
		return usuario;
	}
}
