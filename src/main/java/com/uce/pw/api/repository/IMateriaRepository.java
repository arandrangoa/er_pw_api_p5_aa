package com.uce.pw.api.repository;

import java.util.List;

import com.uce.pw.api.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public void insertar(Materia materia);
	
	public List<Materia> buscarTodos();
	
	public Materia buscarPorCodigo(String codigo);
	
	public void eliminar(String codigo);
	
	public void actualizar(Materia materia);

}
