package org.geo.spatialsearch.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Juan Marin
 * 
 * @param <T>
 *            Entity type
 * @param <S>
 *            Id type
 */
public class HibernateDAOImpl<T extends Serializable, S extends Serializable>
        implements HibernateDAO<T, S> {

    private SessionFactory sessionFactory;

    private final Class<T> clazz;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HibernateDAOImpl() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public HibernateDAOImpl(Class c) {
        this.clazz = c;
    }

    @Override
    public T findById(S id) {
        return (T) sessionFactory.getCurrentSession().load(clazz, id);
    }

    @Override
    public void save(T object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void update(T object) {
        sessionFactory.getCurrentSession().update(object);
    }

    public void saveOrUpdate(final T object) {
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }

    @Override
    public void delete(T object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public <R> R findByCriteria(Criteria criteria) {
        return (R) criteria.uniqueResult();
    }

    @Override
    public <R> List<R> findAllByCriteria(Criteria criteria) {
        return criteria.list();
    }

    @Override
    public List<T> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(clazz).list();
    }

    @Override
    public <R> R findByHqlQuery(String query) {
        return (R) sessionFactory.getCurrentSession().createQuery(query)
                .uniqueResult();
    }

    @Override
    public <R> List<R> findListByHqlQuery(String query) {
        return sessionFactory.getCurrentSession().createQuery(query).list();
    }

    @Override
    public Criteria createCriteria() {
        return sessionFactory.getCurrentSession().createCriteria(clazz);
    }
}
