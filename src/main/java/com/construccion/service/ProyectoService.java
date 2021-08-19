package com.construccion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construccion.entity.Proyecto;
import com.construccion.repository.ProyectoRepository;

@Service
public class ProyectoService {
	
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	public List<Proyecto> getAll() {
        return proyectoRepository.getAll();
    }

}
