package com.transporte.ps.generic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.transporte.ps.hibernateUtil.HibernateUtil;

;

public class DaoGenericImpl<Entity, Key extends Serializable> implements
		DaoGeneric<Entity, Key> {

	private Session session;

	private SessionFactory sessionFactory;

	private Class<Entity> type;

	public DaoGenericImpl(Class<Entity> type) {

		this.type = type;
		sessionFactory = HibernateUtil.getSessionFactory();

	}

	private Session getHibernateTemplate() {

		return session;

	}

	@Override
	public void Guardar(Entity entity) {
		// TODO Auto-generated method stub

		try {
			session = sessionFactory.openSession();
			getHibernateTemplate().beginTransaction();
			getHibernateTemplate().save(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			this.close();
		}

	}

	@Override
	public void Actualizar(Entity entity) {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			getHibernateTemplate().beginTransaction();
			getHibernateTemplate().update(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			this.close();
		}
	}

	@Override
	public Entity Buscar(Key id) {
		// TODO Auto-generated method stub
		// System.out.println("La variable key es: " + id);
		Entity entity = null;
		try {
			session = sessionFactory.openSession();
			entity = (Entity) getHibernateTemplate().get(type, id);
			
		} catch (Exception e) {
			// TODO: handle exception			
		} finally {
			this.close();
		}
		return entity;
		
	}

	@Override
	public void Eliminar(Entity entity) {
		// TODO Auto-generated method stub

		try {
			session = sessionFactory.openSession();
			getHibernateTemplate().beginTransaction();
			getHibernateTemplate().delete(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			this.close();
		}

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
