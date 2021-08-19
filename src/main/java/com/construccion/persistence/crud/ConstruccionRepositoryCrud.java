package com.construccion.persistence.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.construccion.entity.Construccion;

public interface ConstruccionRepositoryCrud extends CrudRepository <Construccion, Integer> {
	
	@Query(value = "SELECT * "
			+ "       FROM CONSTRUCCIONES "
			+ "      WHERE ID_CONSTRUCCION = :idConstruccion "
			+ "        AND ROWNUM = 1", nativeQuery = true)
	Construccion listarConstruccionByID(@Param("idConstruccion") Integer idConstruccion);

}
