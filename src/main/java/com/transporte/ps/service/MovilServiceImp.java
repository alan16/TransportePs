package com.transporte.ps.service;

import java.util.List;

import com.transporte.ps.domain.Movil;
import com.transporte.ps.generic.DaoGeneric;
import com.transporte.ps.generic.DaoGenericImpl;

public class MovilServiceImp implements MovilService{

	DaoGeneric<Movil, Integer>dao = new DaoGenericImpl<Movil, Integer>(Movil.class);
	
	@Override
	public void saveMovil(Movil movil) {
		// TODO Auto-generated method stub
		dao.Guardar(movil);
		
	}

	@Override
	public void deleteMovil(Movil movil) {
		// TODO Auto-generated method stub
		dao.Eliminar(movil);
	}

	@Override
	public Movil buscarMovil(Integer id) {
		// TODO Auto-generated method stub
		Movil movil= dao.Buscar(id);
		return movil;
	}

	@Override
	public List<Movil> getMovils() {
		// TODO Auto-generated method stub
		List<Movil>movils=dao.getAll();
		return movils;
	}

	@Override
	public void updateMovil(Movil movil) {
		// TODO Auto-generated method stub
		dao.Actualizar(movil);
		
	}

}
