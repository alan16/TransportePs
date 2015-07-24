package com.transporte.domaintest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.transporte.ps.domain.Movil;
import com.transporte.ps.generic.DaoGeneric;
import com.transporte.ps.generic.DaoGenericImpl;

public class TestQueryStandar {
	
	List<Object[]> listObjets = new ArrayList<Object[]>();
	private static final String sql = "SELECT m.tuc FROM movil m, marca ma, tipo t, modelo mo WHERE m.tuc=1 and ma.idMarca=1 and t.idTipo=1 and mo.idModelo=1";
	DaoGeneric<Movil, Integer> dao = new DaoGenericImpl<Movil, Integer>(
			Movil.class);

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		listObjets = dao.getAllObjets(sql);
		assertNotNull(listObjets);
		if (listObjets.size() > 0) {
			System.out.println("no esta vacia la lista");
		} else {
			System.out.println("Esta vacia la lista");
		}
		for (Object[] objects : listObjets) {
			System.out.println("Los objetos son: " + objects[0] + "--"
					+ objects[1]);

		}
	}
}
