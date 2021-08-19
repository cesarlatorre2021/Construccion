package com.construccion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construccion.entity.Proyecto;
import com.construccion.service.ProyectoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {
	
	@Autowired
    private ProyectoService proyectoService;
	
    @GetMapping("/all")
    @ApiOperation("Enlista todas los datos generales de los proyectos")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Proyecto>> getAll(){	
    	if(proyectoService.getAll().isEmpty() == false) {
    		return new ResponseEntity<> (proyectoService.getAll(), HttpStatus.OK);
    	}else {
    		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    	}
    }

}
