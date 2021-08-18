package com.construccion.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CONSTRUCCIONES")
public class Construccion {
	
	@Id
	@Column(name = "ID_CONSTRUCCION")
	private long idConstruccion;
	
	private String nombre;
	
	private String estado;
	
	@Column(name = "FECHA_CREACION_REG")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION_REG")
	private LocalDateTime fechaModificacion;
	
	@ManyToOne
    @JoinColumn(name = "ID_PROYECTO", insertable = true, updatable = false)
    private Proyecto proyecto;
	
	@OneToMany(mappedBy = "construccion")
    private List<ParametrosConstruccion> parametrosConstruccion;
	
	@OneToMany(mappedBy = "construccion")
    private List<Solicitudes> solicitud;
	
	public long getIdConstruccion() {
		return idConstruccion;
	}
	
	public void setIdConstruccion(long idConstruccion) {
		this.idConstruccion = idConstruccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
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

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
}
