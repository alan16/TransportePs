package com.transporte.ps.servicetest;

import static org.junit.Assert.*;
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
		Marca marca2 = marcaService.buscarMarca(7);
		marca2.setNombre("Fiat");
		marcaService.updateMarca(marca2);
		Assert.assertEquals("Fiat", marca2.getNombre());
	}

	@Test
	public void MarcaDeleteTest() {

		Marca marca3 = marcaService.buscarMarca(6);
		assertEquals(marca.getNombre(), "Otra");
		marcaService.deleteMarca(marca3);
	}

}
