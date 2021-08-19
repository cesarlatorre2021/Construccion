package com.construccion.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construccion.entity.NotificacionSolicitud;
import com.construccion.entity.Solicitudes;
import com.construccion.repository.ConstruccionRepository;
import com.construccion.repository.MaterialRepository;
import com.construccion.repository.ParametrosRepository;
import com.construccion.repository.ProyectoRepository;
import com.construccion.repository.SolicitudRepository;


@Service
public class SolicitudService {
	
	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@Autowired
	private ParametrosRepository parametrosRepository;
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Autowired
	private ConstruccionRepository construccionRepository;
	
	private final static Logger LOGGER = Logger.getLogger("com.construccion.service.SolicitudService");
	

	public List<Solicitudes> getAll() {
        return solicitudRepository.listarSolicitud();
    }
		
	@Transactional(rollbackOn = Exception.class)
	public boolean save(List<Solicitudes> solicitudes) {
		
		LocalDateTime fechaActual = LocalDateTime.now();
		LocalDateTime fecha = LocalDateTime.now();
		LocalDateTime nuevaFecha = fecha.plusDays(1);
		LocalDateTime fechaFinal = LocalDateTime.now();
		LocalDateTime nuevaFechaFinal = null;
		Solicitudes solicitud;
		boolean snSolicitud = true;
		
		
		//SE OBTIENE EL ID DEL PROYECTO
		try {
			Integer idProyecto = construccionRepository.listarConstruccionByID(
					solicitudes.get(0).getConstruccion().getIdConstruccion()).getProyecto().getIdProyecto();
	
			//SE OBTIENE LOS VALORES PREESTABLECIDOS DE C/U DE LOS MATERIALES, SEGUN LA CONSTRUCCIÓN A REALIZAR
			int cantidadAdobeParametro   = parametrosRepository.consultarParametrosPorConstruccion(
					solicitudes.get(0).getConstruccion().getIdConstruccion()).getCantAdobe();
			int cantidadArenaParametro   = parametrosRepository.consultarParametrosPorConstruccion(
					solicitudes.get(0).getConstruccion().getIdConstruccion()).getCantArena();
			int cantidadCementoParametro = parametrosRepository.consultarParametrosPorConstruccion(
					solicitudes.get(0).getConstruccion().getIdConstruccion()).getCantCemento();
			int cantidadGravaParametro   = parametrosRepository.consultarParametrosPorConstruccion(
					solicitudes.get(0).getConstruccion().getIdConstruccion()).getCantGrava();
			int cantidadMaderaParametro  = parametrosRepository.consultarParametrosPorConstruccion(
					solicitudes.get(0).getConstruccion().getIdConstruccion()).getCantMadera();
			
			//SE OBTIENE LA CANTIDADES DISPONIBLES DE CADA MATERIAL, PARAMETRIZADOS EN LA TABLA MATERIALES
		    int CantidadCementoDisponible = materialRepository.consultarMaterialDisponible().get(0).getCantidadDisponible();
		    int CantidadGravaDiponible    = materialRepository.consultarMaterialDisponible().get(1).getCantidadDisponible();
		    int CantidadArenaDisponible   = materialRepository.consultarMaterialDisponible().get(2).getCantidadDisponible();
		    int CantidadMaderaDisponible  = materialRepository.consultarMaterialDisponible().get(3).getCantidadDisponible();
			int CantidadAdobeDisponible   = materialRepository.consultarMaterialDisponible().get(4).getCantidadDisponible();
		    
			//SI LA CANTIDAD DISPONIBLE DE CADA MATERIAL ES MAYOR A LA REQUERIDA POR LA CONSTRUCCIÓN, SE PROCEDE A CREAR LA SOLICITUD
		    if(cantidadAdobeParametro <= CantidadAdobeDisponible &&
		       cantidadArenaParametro <= CantidadArenaDisponible && 
		       cantidadCementoParametro <= CantidadCementoDisponible &&
		       cantidadGravaParametro <= CantidadGravaDiponible &&
		       cantidadMaderaParametro <= CantidadMaderaDisponible ) 
		    {
	
		    	//EN LA TABLA PARAMETRICA DE LOS MATERIALES, SE ACTUALIZAN LAS UNIDADES DISPONIBLES
		    	for (int i = 0; i<= materialRepository.consultarMaterialDisponible().size(); i++) {
		    		if (i == 0) {
		    			materialRepository.modificarMaterial(materialRepository.consultarMaterialDisponible().get(i).
		    					getIdMaterial(),(CantidadCementoDisponible-cantidadCementoParametro));
		    		}else if (i == 1){
		    			materialRepository.modificarMaterial(materialRepository.consultarMaterialDisponible().get(i)
		    					.getIdMaterial(),(CantidadGravaDiponible-cantidadGravaParametro));
		    		}else if (i == 2){
		    			materialRepository.modificarMaterial(materialRepository.consultarMaterialDisponible().get(i).
		    					getIdMaterial(),(CantidadArenaDisponible-cantidadArenaParametro));
		    		}else if (i == 3){
		    			materialRepository.modificarMaterial(materialRepository.consultarMaterialDisponible().get(i).
		    					getIdMaterial(),(CantidadMaderaDisponible-cantidadMaderaParametro));
		    		}else if (i == 4){
		    			materialRepository.modificarMaterial(materialRepository.consultarMaterialDisponible().get(i).
		    					getIdMaterial(),(CantidadAdobeDisponible-cantidadAdobeParametro));
		    		}
		    	}
	
		    	//SE ESTABLECE LAS FECHAS INICIAL Y FINAL DE CADA CONSTRUCCION
		    	nuevaFechaFinal = fechaFinal.plusDays(parametrosRepository.consultarParametrosPorConstruccion(
		    			solicitudes.get(0).getConstruccion().getIdConstruccion()).getDuracionConstruccion() + 2);
		    	
		    	//SI ES LA PRIMERA SOLICITUD SE DEFINEN LAS FECHAS CON RESPECTO A LA FECHA ACTUAL DEL SISTEMA
		    	if (getAll().isEmpty()) {
			    	solicitud = solicitudes.get(0);
			    	solicitud.setFechaInicioConstruccion(nuevaFecha);
			    	solicitud.setFechaFinConstruccion(nuevaFechaFinal);
			    	solicitud.setFechaCreacion(fechaActual);
		    		solicitudes.set(0, solicitud);
		    		proyectoRepository.modificarFechaInicialProyecto(idProyecto, nuevaFecha);
		    	//SI NO ES LA PRIMERA SOLICITUD, ENTONCES SE DEBE TOMAR EN CUENTA LAS FECHAS INICIAL Y FINAL DE LA ULTIMA CONSTRUCCION SOLICITADA
		    	} else {
		    		System.out.println("Entra por aca");
		    	    fechaFinal = getAll().get(0).getFechaFinConstruccion();
			    	nuevaFechaFinal = fechaFinal.plusDays(parametrosRepository.consultarParametrosPorConstruccion(
			    								 solicitudes.get(0).getConstruccion().getIdConstruccion()).getDuracionConstruccion() + 2);
			    	fecha = getAll().get(0).getFechaFinConstruccion();
			    	nuevaFecha = fecha.plusDays(1);
			    	solicitud = solicitudes.get(0);
			    	solicitud.setFechaInicioConstruccion(nuevaFecha);
			    	solicitud.setFechaCreacion(fechaActual);
			    	solicitud.setFechaFinConstruccion(nuevaFechaFinal);
			    	System.out.println(nuevaFechaFinal);
			    	solicitudes.set(0, solicitud);
		    	}
		    	
		    	//SE ACTUALIZA LA FECHA FIN DEL PROYECTO
		    	proyectoRepository.modificarFechaFinalProyecto(idProyecto, nuevaFechaFinal);
		   
		    }else{
		    	snSolicitud = false;
		    }
		}catch (Exception e) {
			LOGGER.log(Level.WARNING, "Proceso Fallido");
			snSolicitud = false;
		}
	    
	    return snSolicitud;
    }
	
	public NotificacionSolicitud notificar(List<Solicitudes> solicitudes) {
		
	    NotificacionSolicitud notificarSolicitud = new NotificacionSolicitud();
		
		if(save(solicitudes)) {
			notificarSolicitud.setEstadoNotificacion("OK");
			notificarSolicitud.setMensajeNotificacion("Se ha realizado la solicitud exitosamente");
			solicitudRepository.save(solicitudes);
		}else {
			notificarSolicitud.setEstadoNotificacion("ER");
			notificarSolicitud.setMensajeNotificacion("No se ha logrado realizar la solicitud");
		}
		
		return notificarSolicitud;	
	}
	
}
