package com.transporte.ps.service;

import java.util.List;

import com.transporte.ps.domain.Movil;

public interface MovilService {

	
	public void saveMovil(Movil movil);

	public void updateMovil(Movil movil);
	
	public void deleteMovil(Movil movil);

	public Movil buscarMovil(Integer id);

	public List<Movil> getMovils();
}
