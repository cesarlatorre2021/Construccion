package com.construccion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construccion.entity.Solicitudes;
import com.construccion.service.SolicitudService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {
	
	@Autowired
    private SolicitudService solicitudServicio;
	
    @GetMapping("/all")
    @ApiOperation("Enlista todas las solicitudes que tiene la construcción")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Solicitudes>> getAll(){	
    	if(solicitudServicio.getAll().isEmpty() == false) {
    		return new ResponseEntity<> (solicitudServicio.getAll(), HttpStatus.OK);
    	}else {
    		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
    	}
    }
    
    @PostMapping("/save")
    @ApiOperation("Permite crear en la BD una nueva solicitud")
    @ApiResponse(code = 200, message = "OK")
   	public ResponseEntity<List<Solicitudes>> save(@RequestBody List<Solicitudes> solicitudes) {
   		return new ResponseEntity<> (solicitudServicio.save(solicitudes), HttpStatus.CREATED);
   	}
    

}
