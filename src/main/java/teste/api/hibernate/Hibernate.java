package teste.api.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import teste.api.domain.Domain;

public abstract class Hibernate<E extends Serializable, ID extends Serializable> {

	private SessionFactory sessionFactory;
	
	private Class<E> persistentClass;

	public Hibernate(SessionFactory sessionFactory) {
		this.persistentClass = descobrirClassePersistente();
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	private Class<E> descobrirClassePersistente() {
      Type type = null;
      Class<?> clazz = getClass();

      while (clazz != null && !(type instanceof ParameterizedType)) {
    	  type = clazz != null ? clazz.getGenericSuperclass() : null;
    	  clazz = clazz.getSuperclass();
      }

      return (Class<E>) ((ParameterizedType)type).getActualTypeArguments()[0];
    }

	@SuppressWarnings("unchecked")
	@Transactional
	public E salvar(E entity) {
		Domain domain = (Domain) entity;
		domain = (Domain) getSession().merge(domain);
        return (E) domain;
    }

	@Transactional
    public void deletar(ID id) {
    	Domain domain = (Domain) buscarPorId(id);
    	getSession().delete(domain);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
	public E buscarPorId(ID id) {
        return (E) getSession().get(persistentClass, id);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<E> buscarTodos() {
        return getSession().createCriteria(persistentClass).addOrder(Order.desc("id")).list();
    }
    
    @Transactional(readOnly = true)
    public Criteria criarCriteria() {
    	return getSession().createCriteria(persistentClass);
    }
    
    @Transactional(readOnly = true)
    public Query criarQuery(String sql) {
    	return getSession().createQuery(sql);
    }
    
    @Transactional(readOnly = true)
    public Query criarSQLQuery(String sql) {
    	return getSession().createSQLQuery(sql).addEntity(persistentClass);
    }

    public void limparCacheAplicacao() {
    	sessionFactory.getCache().evictEntityRegions();
    	sessionFactory.getCache().evictCollectionRegions();
    	sessionFactory.getCache().evictDefaultQueryRegion();
    	sessionFactory.getCache().evictQueryRegions();
    }
    
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}