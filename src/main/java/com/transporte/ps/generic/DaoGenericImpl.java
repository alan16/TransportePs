package com.transporte.ps.generic;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import com.transporte.ps.hibernateUtil.HibernateUtil;

;

public class DaoGenericImpl<Entity, Key extends Serializable> implements
		DaoGeneric<Entity, Key> {

	private Session session;

	private Class<Entity> type;

	public DaoGenericImpl(Class<Entity> type) {

		this.type = type;

	}

	private Session getHibernateTemplate() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		return session;

	}

	@Override
	public void Guardar(Entity entity) {
		// TODO Auto-generated method stub

		getHibernateTemplate().save(entity);
		session.getTransaction().commit();

	}

	@Override
	public void Actualizar(Entity entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(entity.getClass().getName(), entity);
		session.getTransaction().commit();
	}

	@Override
	public Entity Buscar(Key id) {
		// TODO Auto-generated method stub
		// System.out.println("La variable key es: " + id);
		Entity entity = (Entity) getHibernateTemplate().get(type, id);
		return entity;
	}

	@Override
	public void Eliminar(Entity entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(entity);
		session.getTransaction().commit();

	}

	@Override
	public List<Entity> getAll() {
		// TODO Auto-generated method stub

		Criteria crit = getHibernateTemplate().createCriteria(type);
		return crit.list();

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		getHibernateTemplate().close();

	}

}
