package com.construccion.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "PROYECTOS")
public class Proyecto {
	
	@Id
	@Column(name = "ID_PROYECTO")
	private Integer idProyecto;
	
	private String nombre;
	
	@Column(name = "FECHA_INICIO_PROYECTO")
	private LocalDateTime fechaInicioProyecto;
	
	@Column(name = "FECHA_FIN_PROYECTO")
	private LocalDateTime fechaFinProyecto;
	
	@Column(name = "FECHA_CREACION_REG")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION_REG")
	private LocalDateTime fechaModificacion;
	
	@OneToMany(mappedBy = "proyecto")
    private List<Construccion> construccion;
	
	public Integer getIdProyecto() {
		return idProyecto;
	}
	
	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LocalDateTime getFechaInicioProyecto() {
		return fechaInicioProyecto;
	}
	
	public void setFechaInicioProyecto(LocalDateTime fechaInicioProyecto) {
		this.fechaInicioProyecto = fechaInicioProyecto;
	}
	
	public LocalDateTime getFechaFinProyecto() {
		return fechaFinProyecto;
	}
	
	public void setFechaFinProyecto(LocalDateTime fechaFinProyecto) {
		this.fechaFinProyecto = fechaFinProyecto;
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
	
}
