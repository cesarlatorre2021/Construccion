package com.construccion.repository;

import com.construccion.entity.Construccion;

public interface ConstruccionRepository {
	Construccion listarConstruccionByID(Integer idConstruccion);
}
