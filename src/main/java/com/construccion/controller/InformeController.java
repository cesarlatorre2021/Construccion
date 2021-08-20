package com.construccion.controller;

import javax.persistence.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construccion.entity.Informe;

@RestController
@RequestMapping("/proyecto")
public class InformeController {
	
	@PersistenceContext
    private EntityManager entityManager;
		
    @GetMapping("/emp-dtls")
    public ResponseEntity<Informe> getEmp() {
    	
    	Informe informe = new Informe();
    	StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("ACONSTRUCCION.PR_GENERAR_INFORME");
    	
        storedProcedureQuery.registerStoredProcedureParameter("P_ESTADO", String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("P_MENSAJE", String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("P_RUTA", String.class, ParameterMode.OUT);
        storedProcedureQuery.execute();
 
        final String estado = (String) storedProcedureQuery.getOutputParameterValue("P_ESTADO");
        final String mensaje = (String) storedProcedureQuery.getOutputParameterValue("P_MENSAJE");
        final String ruta = (String) storedProcedureQuery.getOutputParameterValue("P_RUTA");
        
        informe.setEstado(estado);
        informe.setMensaje(mensaje);
        informe.setRuta(ruta);
        
        return new ResponseEntity<>(informe, HttpStatus.OK);
    }

}
