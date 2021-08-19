package com.construccion.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.construccion.entity.Proyecto;

public interface ProyectoRepository {
	void modificarFechaFinalProyecto(Integer idProyecto, LocalDateTime fechaProyecto);
	void modificarFechaInicialProyecto(Integer idProyecto, LocalDateTime fechaProyecto);
	List<Proyecto> getAll();
	
}
