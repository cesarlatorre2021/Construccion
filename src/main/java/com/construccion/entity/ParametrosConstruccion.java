package com.construccion.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMETROS_CONSTRUCCION")
public class ParametrosConstruccion {

	@Id
	@Column(name = "ID_PARAMETRO")
	private long idParametro;
	
	@Column(name = "CANT_CEMENTO")
	private int cantCemento;
	
	@Column(name = "CANT_GRAVA")
	private int cantGrava;
	
	@Column(name = "CANT_ARENA")
	private int cantArena;
	
	@Column(name = "CANT_MADERA")
	private int cantMadera;

	@Column(name = "CANT_ADOBE")
	private int cantAdobe;

	@Column(name = "FECHA_CREACION_REG")
	private LocalDateTime fechaCreacion;
	
	@Column(name = "FECHA_MODIFICACION_REG")
	private LocalDateTime fechaModificacion;
		
	@Column(name = "DURACION_CONSTRUCCION")
	private int duracionConstruccion;
		
	@ManyToOne
    @JoinColumn(name = "ID_CONSTRUCCION", insertable = true, updatable = false)
    private Construccion construccion;
	
	public long getIdParametro() {
		return idParametro;
	}
	
	public void setIdParametro(long idParametro) {
		this.idParametro = idParametro;
	}

	public int getCantCemento() {
		return cantCemento;
	}
	
	public void setCantCemento(int cantCemento) {
		this.cantCemento = cantCemento;
	}
	
	public int getCantGrava() {
		return cantGrava;
	}
	
	public void setCantGrava(int cantGrava) {
		this.cantGrava = cantGrava;
	}
	
	public int getCantArena() {
		return cantArena;
	}
	
	public void setCantArena(int cantArena) {
		this.cantArena = cantArena;
	}
	
	public int getCantMadera() {
		return cantMadera;
	}
	
	public void setCantMadera(int cantMadera) {
		this.cantMadera = cantMadera;
	}
	
	public int getCantAdobe() {
		return cantAdobe;
	}
	
	public void setCantAdobe(int cantAdobe) {
		this.cantAdobe = cantAdobe;
	}
	
	public int getDuracionConstruccion() {
		return duracionConstruccion;
	}
	
	public void setDuracionConstruccion(int duracionConstruccion) {
		this.duracionConstruccion = duracionConstruccion;
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
