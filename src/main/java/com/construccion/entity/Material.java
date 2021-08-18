package com.construccion.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIALES")
public class Material {
	
	@Id
	@Column(name = "ID_MATERIAL")
	private Long idMaterial;
		
	private String nombre;
	
	@Column(name = "CANT_DISPONIBLE")
	private int cantidadDisponible;
	
	@Column(name = "FECHA_CREACION_REG")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION_REG")
	private LocalDateTime fechaModificacion;
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
	})
	@JoinTable(
	        name = "materiales_solicitudes",
	        joinColumns = {@JoinColumn(name = "id_material")},
	        inverseJoinColumns = {@JoinColumn(name = "id_solicitud")}
	)
	private List<Solicitudes> solicitud;
	
	public Long getIdMaterial() {
		return idMaterial;
	}
	
	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidadDisponible() {
		return cantidadDisponible;
	}
	
	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
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

	public List<Solicitudes> getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(List<Solicitudes> solicitud) {
		this.solicitud = solicitud;
	}
	
}
