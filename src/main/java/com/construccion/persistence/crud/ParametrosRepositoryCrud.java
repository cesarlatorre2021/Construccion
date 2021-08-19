package com.construccion.persistence.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.construccion.entity.ParametrosConstruccion;

public interface ParametrosRepositoryCrud  extends CrudRepository <ParametrosConstruccion, Integer> {
	
	@Query(value = "SELECT * "
			+ "       FROM PARAMETROS_CONSTRUCCION CO "
			+ "      WHERE CO.ID_CONSTRUCCION = :idConstruccion", nativeQuery = true)
	ParametrosConstruccion consultarParametrosPorConstruccion(@Param("idConstruccion") Integer idConstruccion);

}
