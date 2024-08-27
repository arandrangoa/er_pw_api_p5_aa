package com.uce.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.pw.api.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public List<Materia> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Materia> query=this.entityManager.createQuery("select m from Materia m",Materia.class);
		return query.getResultList();
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> query=this.entityManager.createQuery("select m from Materia m where m.codigo= :datoCodigo",Materia.class);
		query.setParameter("datoCodigo", codigo);
		return query.getSingleResult();
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		Materia m=this.buscarPorCodigo(codigo);
		this.entityManager.remove(m);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		Materia m=this.buscarPorCodigo(materia.getCodigo());
		m.setNombre(materia.getNombre());
		m.setDescripcion(materia.getDescripcion());
		m.setNumeroCreditos(materia.getNumeroCreditos());
		this.entityManager.merge(m);
		
	}
}
