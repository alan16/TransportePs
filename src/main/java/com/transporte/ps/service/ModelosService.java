package com.transporte.ps.service;

import java.util.List;

import com.transporte.ps.domain.Modelo;

public interface ModelosService {

	public void saveModelo(Modelo modelo);

	public void updateModelo(Modelo modelo);
	
	public void deleteModelo(Modelo modelo);

	public Modelo buscarModelo(Integer id);

	public List<Modelo> getModelos();
}
