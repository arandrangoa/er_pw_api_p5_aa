package com.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.uce.pw.api.repository.IMateriaRepository;
import com.uce.pw.api.repository.modelo.Materia;
import com.uce.pw.api.service.to.MateriaCompletaTO;
import com.uce.pw.api.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService{
	
	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	public void insertar(MateriaCompletaTO materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.insertar(this.convertirCompletoTOAMateria(materia));
		
	}

	@Override
	public List<MateriaTO> buscarTodos() {
		// TODO Auto-generated method stub
		List<Materia> lista=this.iMateriaRepository.buscarTodos();
		List<MateriaTO> listaTO=new ArrayList<>();
		for(Materia m:lista) {
			listaTO.add(this.convertirAMateriaTO(m));
		}
		return listaTO;
	}

	@Override
	public MateriaCompletaTO buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		Materia m=this.iMateriaRepository.buscarPorCodigo(codigo);
		return this.convertirAMateriaCompletaTO(m);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.eliminar(codigo);
	}

	@Override
	public void actualizar(MateriaCompletaTO materia) {
		// TODO Auto-generated method stub
		Materia m=this.iMateriaRepository.buscarPorCodigo(materia.getCodigo());
		this.iMateriaRepository.actualizar(this.convertirCompletoTOAMateria(materia));
	}
	
	
	private MateriaCompletaTO convertirAMateriaCompletaTO(Materia materia) {
		MateriaCompletaTO m=new MateriaCompletaTO();
		m.setId(materia.getId());
		m.setCodigo(materia.getCodigo());
		m.setDescripcion(materia.getDescripcion());
		m.setNombre(materia.getNombre());
		m.setNumeroCreditos(materia.getNumeroCreditos());
		return m;
	}
	
	private Materia convertirCompletoTOAMateria(MateriaCompletaTO materia) {
		Materia m=new Materia();
		m.setId(materia.getId());
		m.setCodigo(materia.getCodigo());
		m.setDescripcion(materia.getDescripcion());
		m.setNombre(materia.getNombre());
		m.setNumeroCreditos(materia.getNumeroCreditos());
		return m;
	}
	
	private MateriaTO convertirAMateriaTO(Materia materia) {
		MateriaTO m= new MateriaTO();
		m.setCodigo(materia.getCodigo());
		m.setNombre(materia.getNombre());
		return m;
	}
	

}
