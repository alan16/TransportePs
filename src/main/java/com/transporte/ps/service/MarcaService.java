package com.transporte.ps.service;

import java.util.List;

import com.transporte.ps.domain.Marca;

public interface MarcaService {

	public void saveMarca(Marca marca);
	
	public void updateMarca(Marca marca);

	public void deleteMarca(Marca marca);

	public Marca buscarMarca(Integer id);

	public List<Marca> getMarcas();

	public void close();

}
