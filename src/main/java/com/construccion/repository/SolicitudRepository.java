package com.construccion.repository;

import java.util.List;

import com.construccion.entity.Solicitudes;

public interface SolicitudRepository {
	List<Solicitudes> save(List<Solicitudes> solicitudes);
	List<Solicitudes> listarSolicitud();
}
