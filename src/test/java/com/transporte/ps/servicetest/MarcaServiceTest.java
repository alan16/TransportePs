package com.transporte.ps.servicetest;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.transporte.ps.domain.Marca;
import com.transporte.ps.hibernateUtil.HibernateUtil2;
import com.transporte.ps.service.MarcaService;
import com.transporte.ps.service.MarcaServiceImp;

public class MarcaServiceTest {

	private MarcaService marcaService = new MarcaServiceImp();
	private Marca marca;

	@Before
	public void setUp() throws Exception {
		marca = new Marca("Otra");
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void test() {

		marcaService.saveMarca(marca);			
		marcaService.deleteMarca(marca);

	}

	@Test
	public void MarcaUpdateTest() {
		Marca marca2 = marcaService.buscarMarca(100);
		marca2.setNombre("Fiat");
		marcaService.updateMarca(marca2);
		Assert.assertEquals("Fiat", marca2.getNombre());
	}

	@Test
	public void MarcaDeleteTest() {

		Marca marca3 = marcaService.buscarMarca(5);
		assertEquals(marca.getNombre(), "Otra");
		marcaService.deleteMarca(marca3);
	}
	
	@Test
	public void Marcas(){
		List<Marca> marcas = marcaService.getMarcas();
		assertNotNull(marcas);
		System.out.println("numero de nodos "+marcas.size() );
	}

}
