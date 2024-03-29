package com.construccion.persistence.crud;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.construccion.entity.Proyecto;

public interface ProyectoRepositoryCrud extends CrudRepository <Proyecto, Integer>{
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE PROYECTOS "
			+ "        SET FECHA_FIN_PROYECTO = :fechaFinProyecto "
			+ "      WHERE ID_PROYECTO = :idProyecto ", nativeQuery = true)
	void modificarFechaFinalProyecto(@Param("fechaFinProyecto") LocalDateTime fechaFinProyecto,
									 @Param("idProyecto") Integer idProyecto);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE PROYECTOS "
			+ "        SET FECHA_INICIO_PROYECTO = :fechaInicioProyecto "
			+ "      WHERE ID_PROYECTO = :idProyecto ", nativeQuery = true)
	void modificarFechaInicialProyecto(@Param("fechaInicioProyecto") LocalDateTime fechaInicioProyecto,
								       @Param("idProyecto") Integer idProyecto);

}
