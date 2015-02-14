package com.transporte.ps.generic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.transporte.ps.hibernateUtil.HibernateUtil;
import com.transporte.ps.hibernateUtil.HibernateUtil2;

;

public class DaoGenericImpl<Entity, Key extends Serializable> implements
		DaoGeneric<Entity, Key> {

	private Class<Entity> type;

	private Session session;

	private SessionFactory sessionFactory;

	public DaoGenericImpl(Class<Entity> type) {
		sessionFactory = HibernateUtil.getSessionFactory();
		this.type = type;
		session = sessionFactory.openSession();
	}

	private Session getHibernateTemplate() {
		session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public void Guardar(Entity entity) {
		// TODO Auto-generated method stub

		try {
			getHibernateTemplate().beginTransaction();
			getHibernateTemplate().save(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		}

	}

	@Override
	public void Actualizar(Entity entity) {
		// TODO Auto-generated method stub
		try {

			getHibernateTemplate().beginTransaction();
			getHibernateTemplate().update(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			getHibernateTemplate().getTransaction().rollback();
		}
	}

	@Override
	public Entity Buscar(Key id) {
		// TODO Auto-generated method stub
		// System.out.println("La variable key es: " + id);
		Entity entity = null;
		try {
			getHibernateTemplate().beginTransaction();
			entity = (Entity) getHibernateTemplate().get(type, id);
			getHibernateTemplate().getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			getHibernateTemplate().getTransaction().rollback();
		}

		return entity;

	}

	@Override
	public void Eliminar(Entity entity) {
		// TODO Auto-generated method stub

		try {

			getHibernateTemplate().beginTransaction();
			getHibernateTemplate().delete(entity);
			getHibernateTemplate().getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			getHibernateTemplate().getTransaction().rollback();
		}

	}

	@Override
	public List<Entity> getAll() {
		// TODO Auto-generated method stub

		Criteria crit = null;
		try {
			getHibernateTemplate().beginTransaction();
			crit = getHibernateTemplate().createCriteria(type);
			getHibernateTemplate().getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			getHibernateTemplate().getTransaction().rollback();
		}

		return crit.list();

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		getHibernateTemplate().close();

	}

}
