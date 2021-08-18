package com.construccion.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.construccion.entity.Solicitudes;

public interface SolicitudRepositoryCrud extends CrudRepository <Solicitudes, Integer>{
	
	@Query(value = "SELECT * "
			+ "       FROM SOLICITUDES "
			+ "      ORDER BY FECHA_INICIO_CONSTRUCCION DESC", nativeQuery = true)
	List<Solicitudes> listarSolicitud();
	
}
