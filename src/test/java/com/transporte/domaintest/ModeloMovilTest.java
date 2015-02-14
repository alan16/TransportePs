package com.transporte.domaintest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.transporte.ps.domain.Modelo;
import com.transporte.ps.domain.Tipo;
import com.transporte.ps.generic.DaoGeneric;
import com.transporte.ps.generic.DaoGenericImpl;

public class ModeloMovilTest {

	private DaoGeneric<Modelo, Integer> dao = new DaoGenericImpl<Modelo, Integer>(
			Modelo.class);
	private Modelo modelo = new Modelo();

	@Before
	public void setUp() throws Exception {
		modelo.setNombre("bmw");
	}

	@After
	public void tearDown() throws Exception {

		dao.close();
	}

	@Test
	public void test() {
		dao.Guardar(modelo);
		Assert.assertNotNull(modelo);
		Modelo modelo2 = dao.Buscar(1);
		// Assert.assertEquals(modelo.getNombre(), modelo2.getNombre());
		dao.Eliminar(modelo);
	}

	@Test
	public void listarTets() {
		List<Modelo> modelos = dao.getAll();
		Assert.assertNotNull(modelos);
		Assert.assertEquals(2, modelos.size());
		for (Modelo modelo : modelos) {
			System.out
					.println("el nombre de los modelos " + modelo.getNombre());
		}

	}

	@Test
	public void UpdateTest() {

		Modelo modelo2 = dao.Buscar(1);
		modelo2.setNombre("Cambio");
		dao.Actualizar(modelo2);

	}

}
