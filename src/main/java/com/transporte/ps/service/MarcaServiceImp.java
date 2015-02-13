package com.transporte.ps.service;

import java.util.List;

import com.transporte.ps.domain.Marca;
import com.transporte.ps.generic.DaoGeneric;
import com.transporte.ps.generic.DaoGenericImpl;

public class MarcaServiceImp implements MarcaService{

	private DaoGeneric<Marca, Integer> dao = new DaoGenericImpl<Marca, Integer>(Marca.class);
	
	@Override
	public void saveMarca(Marca marca) {
		// TODO Auto-generated method stub
		dao.Guardar(marca);
		
	}

	@Override
	public void deleteMarca(Marca marca) {
		// TODO Auto-generated method stub
		dao.Eliminar(marca);
		
	}

	@Override
	public Marca buscarMarca(Integer id) {
		// TODO Auto-generated method stub
		Marca marca = dao.Buscar(id);
		return marca;
	}

	@Override
	public List<Marca> getMarcas() {
		// TODO Auto-generated method stub
		List<Marca> marcas = dao.getAll();
		return marcas;
	}

	@Override
	public void updateMarca(Marca marca) {
		// TODO Auto-generated method stub
		dao.Actualizar(marca);
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		dao.close();
	}

}
