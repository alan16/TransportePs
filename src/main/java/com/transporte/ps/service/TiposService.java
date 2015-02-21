package com.transporte.ps.service;

import java.util.List;

import com.transporte.ps.domain.Tipo;

public interface TiposService {

	public void saveTipo(Tipo tipo);

	public void updateTipo(Tipo tipo);
	
	public void deleteTipo(Tipo tipo);

	public Tipo buscarTipo(Integer id);

	public List<Tipo> getTipos();
}
