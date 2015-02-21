package com.transporte.domaintest;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.transporte.ps.domain.Marca;
import com.transporte.ps.domain.Tipo;
import com.transporte.ps.generic.DaoGeneric;
import com.transporte.ps.generic.DaoGenericImpl;

public class TipoMovilTest {
	
	private DaoGeneric<Tipo, Integer> dao = new DaoGenericImpl<Tipo, Integer>(Tipo.class);
	private Tipo tipo=new Tipo();

	@Before
	public void setUp() throws Exception {
		tipo.setNombre("Moto");
	}

	@After
	public void tearDown() throws Exception {
		dao.close();
	}

	@Test
	public void test() {
		dao.Guardar(tipo);
		Tipo tipo2=dao.Buscar(1);
		Assert.assertEquals(tipo.getNombre(), tipo2.getNombre());
	}

}
