package com.transporte.ps.generic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.transporte.ps.hibernateUtil.HibernateUtil;
import com.transporte.ps.hibernateUtil.HibernateUtil2;

;

public class DaoGenericImpl<Entity, Key extends Serializable> implements
		DaoGeneric<Entity, Key> {

	private final static Logger LOGGER = Logger.getLogger(DaoGenericImpl.class
			.getName());

	private Class<Entity> type;

	private List<Entity> entidades;

	private Session session;

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public DaoGenericImpl(Class<Entity> type) {
		this.type = type;
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
			if (!getHibernateTemplate().getTransaction().wasCommitted()) {
				getHibernateTemplate().getTransaction().commit();
			}

		} catch (Exception e) {
			// TODO: handle exception
			try {
				if (getHibernateTemplate().getTransaction().isActive()) {
					getHibernateTemplate().getTransaction().rollback();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
			}

		} finally {
			try {
				if (getHibernateTemplate().isOpen()) {
					close();
				}

			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Error closing session", e);
			}
		}

	}

	@Override
	public void Actualizar(Entity entity) {
		// TODO Auto-generated method stub
		try {

			session = sessionFactory.openSession();
			getHibernateTemplate().beginTransaction();
			getHibernateTemplate().update(entity);
			if (!getHibernateTemplate().getTransaction().wasCommitted()) {
				getHibernateTemplate().getTransaction().commit();
			}

		} catch (Exception e) {
			// TODO: handle exception
			try {
				if (getHibernateTemplate().getTransaction().isActive()) {
					getHibernateTemplate().getTransaction().rollback();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
			}

		} finally {
			try {
				if (getHibernateTemplate().isOpen()) {
					close();
				}

			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Error closing session", e);
			}
		}
	}

	@Override
	public Entity Buscar(Key id) {
		// TODO Auto-generated method stub
		// System.out.println("La variable key es: " + id);
		Entity entity = null;
		try {
			session = sessionFactory.openSession();
			getHibernateTemplate().beginTransaction();
			entity = (Entity) getHibernateTemplate().get(type, id);
			if (!getHibernateTemplate().getTransaction().wasCommitted()) {
				getHibernateTemplate().getTransaction().commit();
			}

		} catch (Exception e) {
			// TODO: handle exception
			try {
				if (getHibernateTemplate().getTransaction().isActive()) {
					getHibernateTemplate().getTransaction().rollback();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
			}

		} finally {
			try {
				if (getHibernateTemplate().isOpen()) {
					close();
				}

			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Error closing session", e);
			}
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
			if (!getHibernateTemplate().getTransaction().wasCommitted()) {
				getHibernateTemplate().getTransaction().commit();
			}

		} catch (Exception e) {
			// TODO: handle exception
			try {
				if (getHibernateTemplate().getTransaction().isActive()) {
					getHibernateTemplate().getTransaction().rollback();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
			}

		} finally {
			try {
				if (getHibernateTemplate().isOpen()) {
					close();
				}

			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Error closing session", e);
			}
		}

	}

	@Override
	public List<Entity> getAll() {
		// TODO Auto-generated method stub

		Criteria crit = null;
		try {
			session = sessionFactory.openSession();
			getHibernateTemplate().beginTransaction();
			crit = getHibernateTemplate().createCriteria(type);
			if (!getHibernateTemplate().getTransaction().wasCommitted()) {
				getHibernateTemplate().getTransaction().commit();
			}

			entidades = crit.list();

		} catch (Exception e) {
			// TODO: handle exception
			try {
				if (getHibernateTemplate().getTransaction().isActive()) {
					getHibernateTemplate().getTransaction().rollback();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
			}

		} finally {
			try {
				if (getHibernateTemplate().isOpen()) {
					close();
				}

			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Error closing session", e);
			}
		}

		return entidades;

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		getHibernateTemplate().close();

	}

}
