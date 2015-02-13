package com.transporte.ps.servicetest;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.transporte.ps.domain.Marca;
import com.transporte.ps.service.MarcaService;
import com.transporte.ps.service.MarcaServiceImp;

public class MarcaServiceTest {

	private MarcaService marcaService=new MarcaServiceImp();
	private Marca marca;
	
	@Before
	public void setUp() throws Exception {
		marca = new Marca("Otra");
	}

	@After
	public void tearDown() throws Exception {
	
		marcaService.close();
	}

	@Test
	public void test() {
		
		marcaService.saveMarca(marca);
		Marca marca2=marcaService.buscarMarca(3);
		Assert.assertEquals(marca.getNombre(), marca2.getNombre());		
		marcaService.deleteMarca(marca);
		
		
	}
	
	/*@Test 
	public void MarcaUpdateTest(){
		Marca marca= marcaService.buscarMarca(3);
		marca.setNombre("Fiat");
		marcaService.updateMarca(marca);		
		Assert.assertEquals("Fiat", marca.getNombre());
	}*/
	
	@Test
	public void MarcaDeleteTest(){
		
		Marca marca= marcaService.buscarMarca(3);
		assertEquals(marca.getNombre(), "Otra");
		marcaService.deleteMarca(marca);
	}

}
