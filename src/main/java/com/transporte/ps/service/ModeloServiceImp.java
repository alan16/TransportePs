package com.transporte.ps.service;

import java.util.List;

import com.transporte.ps.domain.Modelo;
import com.transporte.ps.generic.DaoGeneric;
import com.transporte.ps.generic.DaoGenericImpl;

public class ModeloServiceImp implements ModelosService{

	private DaoGeneric<Modelo, Integer> dao = new DaoGenericImpl<Modelo, Integer>(Modelo.class);
	
	@Override
	public void saveModelo(Modelo modelo) {
		// TODO Auto-generated method stub
		dao.Guardar(modelo);
		
	}

	@Override
	public void deleteModelo(Modelo modelo) {
		// TODO Auto-generated method stub
		dao.Eliminar(modelo);
		
	}

	@Override
	public Modelo buscarModelo(Integer id) {
		// TODO Auto-generated method stub
		Modelo modelo = dao.Buscar(id);
		return modelo;
	}

	@Override
	public List<Modelo> getModelos() {
		// TODO Auto-generated method stub		
		return dao.getAll();
	}

	@Override
	public void updateModelo(Modelo modelo) {
		// TODO Auto-generated method stub
		dao.Actualizar(modelo);
	}

}
