package com.uce.pw.api.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class MateriaCompletaTO extends RepresentationModel<MateriaCompletaTO> implements Serializable{

	private static final long serialVersionUID = 3437443415378478767L;
	
	private Integer id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Integer numeroCreditos;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getNumeroCreditos() {
		return numeroCreditos;
	}
	public void setNumeroCreditos(Integer numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

}
