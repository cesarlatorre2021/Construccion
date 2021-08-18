package com.construccion.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.construccion.entity.Material;
import com.construccion.persistence.crud.MaterialRepositoryCrud;
import com.construccion.repository.MaterialRepository;

@Repository
public class MaterialRepositoryImpl implements MaterialRepository{
	
	@Autowired
	MaterialRepositoryCrud materialRepositoryCrud;

	@Override
	public List<Material> consultarMaterialDisponible() {
		return (List<Material>) materialRepositoryCrud.consultarMaterialDisponible();
	}

	@Override
	public void modificarMaterial(long idMaterial, int cantidadDisponble) {
		materialRepositoryCrud.modificarMaterial(idMaterial, cantidadDisponble);
	}

}
