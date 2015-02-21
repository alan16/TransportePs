package com.transporte.domaintest;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.transporte.ps.domain.Marca;
import com.transporte.ps.domain.Modelo;
import com.transporte.ps.domain.Movil;
import com.transporte.ps.domain.Tipo;
import com.transporte.ps.generic.DaoGeneric;
import com.transporte.ps.generic.DaoGenericImpl;

public class MovilTest {

	private DaoGeneric<Movil, Integer>dao = new DaoGenericImpl<Movil, Integer>(Movil.class);
	private DaoGeneric<Tipo, Integer>dao2 = new DaoGenericImpl<Tipo, Integer>(Tipo.class);
	private DaoGeneric<Marca, Integer>dao3 = new DaoGenericImpl<Marca, Integer>(Marca.class);
	private DaoGeneric<Modelo, Integer>dao4 = new DaoGenericImpl<Modelo, Integer>(Modelo.class);
	
	private Movil movil;
	private Tipo tipo;
	private Modelo modelo;
	private Marca marca;
	
	@Before
	public void setUp() throws Exception {
		movil = new Movil(2, 1, 1, 1, "prueba", new Date());
		tipo = dao2.Buscar(1);
		marca = dao3.Buscar(1);
		modelo = dao4.Buscar(1);
		
	}

	@After
	public void tearDown() throws Exception {
	dao.close();
	dao2.close();
	dao3.close();
	dao4.close();
	}

	@Test
	public void test() {
		
		assertNotNull(tipo);
		assertNotNull(marca);
		assertNotNull(modelo);
		assertNotNull(movil);
		
		movil.setTipo(tipo);
		movil.setMarca(marca);
		movil.setModelo(modelo);
		dao.Guardar(movil);
		Movil movil2=dao.Buscar(1);
		assertEquals(movil.getObservacion(),movil2.getObservacion() );
		dao.Eliminar(movil);
		
	}
	
	@Test
	public void MovilListTest(){
		
		List<Movil> movil = dao.getAll();
		assertNotNull(movil);
		assertEquals(movil.size(),1);
		for (Movil movil2 : movil) {
			System.out.println("moviles "+movil2.getObservacion());
		}
		System.out.println("");
		
		
	}

}
