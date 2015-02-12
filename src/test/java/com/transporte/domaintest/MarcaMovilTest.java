package com.transporte.domaintest;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.transporte.ps.domain.Marca;
import com.transporte.ps.generic.DaoGeneric;
import com.transporte.ps.generic.DaoGenericImpl;
import com.transporte.ps.hibernateUtil.HibernateUtil;

public class MarcaMovilTest {

	private DaoGeneric<Marca, Integer> dao = new DaoGenericImpl<Marca, Integer>(
			Marca.class);
	private Marca marca;

	@Before
	public void setUp() throws Exception {

		marca = new Marca();
		marca.setNombre("Toyota");

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		try {

			Assert.assertEquals("Toyota", marca.getNombre());
			dao.Guardar(marca);
			Marca marca2 = dao.Buscar(1);
			Assert.assertEquals(marca2.getNombre(), marca.getNombre());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("El error es: " + e);
		}

	}

}
