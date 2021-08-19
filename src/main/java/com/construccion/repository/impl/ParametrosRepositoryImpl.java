package com.construccion.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.construccion.entity.ParametrosConstruccion;
import com.construccion.persistence.crud.ParametrosRepositoryCrud;
import com.construccion.repository.ParametrosRepository;

@Repository
public class ParametrosRepositoryImpl implements ParametrosRepository {
	
	@Autowired
	ParametrosRepositoryCrud parametrosRepositoryCrud;

	@Override
	public ParametrosConstruccion consultarParametrosPorConstruccion(Integer idConstruccion) {
		return parametrosRepositoryCrud.consultarParametrosPorConstruccion(idConstruccion);
	}

}
