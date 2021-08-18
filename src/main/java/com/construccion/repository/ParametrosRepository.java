package com.construccion.repository;

import com.construccion.entity.ParametrosConstruccion;

public interface ParametrosRepository {
	ParametrosConstruccion consultarParametrosPorConstruccion(Long idConstruccion);
}
