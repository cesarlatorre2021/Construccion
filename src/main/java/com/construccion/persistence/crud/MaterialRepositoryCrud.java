package com.construccion.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.construccion.entity.Material;

public interface MaterialRepositoryCrud extends CrudRepository <Material, Integer> {
	
	@Query(value = "SELECT * "
			+ "       FROM MATERIALES " , nativeQuery = true)
	List<Material> consultarMaterialDisponible();
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE MATERIALES "
			+ "        SET CANT_DISPONIBLE = :cantidadDisponible "
			+ "           ,FECHA_MODIFICACION_REG = SYSTIMESTAMP"
			+ "      WHERE ID_MATERIAL = :idMaterial ", nativeQuery = true)
	void modificarMaterial(@Param("idMaterial") long idMaterial,
			               @Param("cantidadDisponible") int cantidadDisponible);

}
