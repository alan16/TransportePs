package com.transporte.ps.generic;

import java.util.List;

public interface DaoGeneric<Entity, Key> {

	void Guardar(Entity entity);

	void Actualizar(Entity entity);

	Entity Buscar(Key id);

	void Eliminar(Entity entity);
	
	List<Entity> getAll();
	
	List<Object[]>getAllObjets(String sql);

	void close();
}
