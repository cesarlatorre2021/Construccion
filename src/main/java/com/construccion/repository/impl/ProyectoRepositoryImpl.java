package com.construccion.repository.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.construccion.entity.Proyecto;
import com.construccion.persistence.crud.ProyectoRepositoryCrud;
import com.construccion.repository.ProyectoRepository;

@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository {
	
	@Autowired
	ProyectoRepositoryCrud proyectoRepositoryCrud;

	@Override
	public void modificarFechaFinalProyecto(Integer idProyecto, LocalDateTime fechaProyecto) {
		proyectoRepositoryCrud.modificarFechaFinalProyecto(fechaProyecto, idProyecto);	
	}

	@Override
	public void modificarFechaInicialProyecto(Integer idProyecto, LocalDateTime fechaInicioProyecto) {
		proyectoRepositoryCrud.modificarFechaInicialProyecto(fechaInicioProyecto, idProyecto);	
	}

	@Override
	public List<Proyecto> getAll() {
		return (List<Proyecto>) proyectoRepositoryCrud.findAll();
	}

}
