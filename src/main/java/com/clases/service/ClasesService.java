package com.clases.service;

import java.util.List;

import com.persistence_escuela.entity.Clases;
import com.persistence_escuela.request.ClasesRequest;

public interface ClasesService {

	Clases guardar(ClasesRequest request);
	Clases actualizar(ClasesRequest request);
	Clases buscar(int id);
	List mostrar();
	String borrar(int id);
}
