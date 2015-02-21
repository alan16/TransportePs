package com.transporte.ps.service;

import java.util.List;

import com.transporte.ps.domain.Tipo;
import com.transporte.ps.generic.DaoGeneric;
import com.transporte.ps.generic.DaoGenericImpl;

public class TiposServiceImp implements TiposService{

	private DaoGeneric<Tipo, Integer> dao = new DaoGenericImpl<Tipo, Integer>(Tipo.class);
	
	@Override
	public void saveTipo(Tipo tipo) {
		// TODO Auto-generated method stub
		dao.Guardar(tipo);
		
	}

	@Override
	public void deleteTipo(Tipo tipo) {
		// TODO Auto-generated method stub
		dao.Eliminar(tipo);
		
	}

	@Override
	public Tipo buscarTipo(Integer id) {
		// TODO Auto-generated method stub
		Tipo tipo = dao.Buscar(id);
		return tipo;
	}

	@Override
	public List<Tipo> getTipos() {
		// TODO Auto-generated method stub
		List<Tipo> tipos = dao.getAll();
		return tipos;
	}

	@Override
	public void updateTipo(Tipo tipo) {
		// TODO Auto-generated method stub
		dao.Actualizar(tipo);
	}

}
