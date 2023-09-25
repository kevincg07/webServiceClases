package com.clases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clases.impl.ClasesImplement;
import com.persistence_escuela.entity.Clases;
import com.persistence_escuela.request.ClasesRequest;

@RestController
@RequestMapping("clases/")
public class ClasesController {

	@Autowired
	ClasesImplement logic;
	
	@PostMapping
	ResponseEntity<Clases> guardar(@RequestBody ClasesRequest request){
		Clases c = logic.guardar(request);
		return new ResponseEntity<Clases>(c, HttpStatus.OK);
	}
	
	@PutMapping
	ResponseEntity<Clases> actualizar(@RequestBody ClasesRequest request){
		Clases c = logic.actualizar(request);
		return new ResponseEntity<Clases>(c, HttpStatus.OK);
	}
	
	@GetMapping("buscar-por-id/{id}")
	ResponseEntity<Clases> buscar(@PathVariable("id") int id){
		Clases c = logic.buscar(id);
		return new ResponseEntity<Clases>(c, HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity<List<Clases>> mostrar(){
		List<Clases> clases = logic.mostrar();
		return new ResponseEntity<List<Clases>>(clases, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar-por-id/{id}")
	ResponseEntity<String> borrar(@PathVariable("id") int id){
		String m = logic.borrar(id);
		return new ResponseEntity<String>(m, HttpStatus.OK);
	}
	
}
