package com.construccion.repository;

import java.util.List;

import com.construccion.entity.Material;

public interface MaterialRepository {	
	List<Material> consultarMaterialDisponible();
	void modificarMaterial(long idMaterial, int cantidadDisponble);
}
