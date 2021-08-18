package com.construccion.repository.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.construccion.persistence.crud.ProyectoRepositoryCrud;
import com.construccion.repository.ProyectoRepository;

@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository {
	
	@Autowired
	ProyectoRepositoryCrud proyectoRepositoryCrud;

	@Override
	public void modificarFechaProyecto(Long idProyecto, LocalDateTime fechaProyecto) {
		proyectoRepositoryCrud.modificarMaterial(fechaProyecto, idProyecto);	
	}

}
