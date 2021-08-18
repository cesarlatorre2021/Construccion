package com.construccion.repository;

import java.time.LocalDateTime;

public interface ProyectoRepository {
	void modificarFechaProyecto(Long idProyecto, LocalDateTime fechaProyecto);
}
