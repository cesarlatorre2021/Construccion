package com.construccion.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.construccion.entity.Construccion;
import com.construccion.persistence.crud.ConstruccionRepositoryCrud;
import com.construccion.repository.ConstruccionRepository;

@Repository
public class ConstruccionRepositoryImpl implements ConstruccionRepository {
	
	@Autowired
	ConstruccionRepositoryCrud construccionRepositoryCrud;

	@Override
	public Construccion listarConstruccionByID(Integer idConstruccion) {
		return construccionRepositoryCrud.listarConstruccionByID(idConstruccion);
	}

}
