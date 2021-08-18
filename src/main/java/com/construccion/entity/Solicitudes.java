package com.construccion.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SOLICITUDES")
public class Solicitudes {

	@Id
	@Column(name = "ID_SOLICITUD")
	private Long idSolicitud;
	
	private String estado;
	
	@Column(name = "COORDENADAS_CONSTRUCCION")
	private String coordenadasConstruccion;
	
	@Column(name = "FECHA_INICIO_CONSTRUCCION")
	private LocalDateTime fechaInicioConstruccion;
	
	@Column(name = "FECHA_FIN_CONSTRUCCION")
	private LocalDateTime fechaFinConstruccion;
	
	@Column(name = "FECHA_CREACION_REG")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION_REG")
	private LocalDateTime fechaModificacion;
	
	@ManyToOne
    @JoinColumn(name = "ID_CONSTRUCCION", insertable = true, updatable = false)
    private Construccion construccion;
	
	@ManyToMany(mappedBy = "solicitud")
    private List<Material> materiales;
	
	public Long getIdSolicitud() {
		return idSolicitud;
	}
	
	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCoordenadasConstruccion() {
		return coordenadasConstruccion;
	}
	
	public void setCoordenadasConstruccion(String coordenadasConstruccion) {
		this.coordenadasConstruccion = coordenadasConstruccion;
	}
	
	public LocalDateTime getFechaInicioConstruccion() {
		return fechaInicioConstruccion;
	}
	
	public void setFechaInicioConstruccion(LocalDateTime fechaInicioConstruccion) {
		this.fechaInicioConstruccion = fechaInicioConstruccion;
	}
	
	public LocalDateTime getFechaFinConstruccion() {
		return fechaFinConstruccion;
	}
	
	public void setFechaFinConstruccion(LocalDateTime fechaFinConstruccion) {
		this.fechaFinConstruccion = fechaFinConstruccion;
	}
	
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}
	
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Construccion getConstruccion() {
		return construccion;
	}

	public void setConstruccion(Construccion construccion) {
		this.construccion = construccion;
	}
	
}
