package com.construccion.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.construccion.entity.Solicitudes;
import com.construccion.persistence.crud.SolicitudRepositoryCrud;
import com.construccion.repository.SolicitudRepository;

@Repository
public class SolicitudRepositoryImpl implements SolicitudRepository {
	
	@Autowired
	private SolicitudRepositoryCrud solicitudRepositoryCrud;

	@Override
	public List<Solicitudes> listarSolicitud() {
		return solicitudRepositoryCrud.listarSolicitud();
	}

	@Override
	public List<Solicitudes>  save(List<Solicitudes> solicitudes) {
		return (List<Solicitudes>) solicitudRepositoryCrud.saveAll(solicitudes);
	}

}
