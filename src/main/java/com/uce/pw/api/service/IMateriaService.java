package com.uce.pw.api.service;

import java.util.List;
import com.uce.pw.api.service.to.MateriaCompletaTO;
import com.uce.pw.api.service.to.MateriaTO;

public interface IMateriaService {
	
public void insertar(MateriaCompletaTO materia);
	
	public List<MateriaTO> buscarTodos();
	
	public MateriaCompletaTO buscarPorCodigo(String codigo);
	
	public void eliminar(String codigo);
	
	public void actualizar(MateriaCompletaTO materia);

}
