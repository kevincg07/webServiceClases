package com.clases.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clases.service.ClasesService;
import com.persistence_escuela.entity.Clases;
import com.persistence_escuela.repository.ClasesRepository;
import com.persistence_escuela.request.ClasesRequest;

@Service
public class ClasesImplement implements ClasesService{

	@Autowired
	ClasesRepository repo;

	@Override
	public Clases guardar(ClasesRequest request) {
		Clases c = new Clases();
		c.setMateria(request.getMateria());
		c.setProfesor(request.getProfesor());
		repo.save(c);
		return c;
	}

	@Override
	public Clases actualizar(ClasesRequest request) {
		Clases c = repo.findById(request.getIdClase()).get();
		c.setMateria(request.getMateria());
		c.setProfesor(request.getProfesor());
		repo.save(c);
		return c;
	}

	@Override
	public Clases buscar(int id) {		
		return repo.findById(id).get();
	}

	@Override
	public List mostrar() {
		return repo.findAll();
	}

	@Override
	public String borrar(int id) {
		repo.deleteById(id);
		return "Borrado";
	}
}
