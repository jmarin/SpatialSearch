package org.geo.spatialsearch.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

/**
 * 
 * @author Juan Marin
 * 
 * @param <T>
 * @param <S>
 */
public interface HibernateDAO<T extends Serializable, S extends Serializable> {

    public T findById(final S id);

    public void save(final T object);

    public void update(final T object);

    public void saveOrUpdate(final T object);

    public void delete(final T object);

    public <R> R findByCriteria(final Criteria criteria);

    public <R> List<R> findAllByCriteria(final Criteria criteria);

    public List<T> findAll();

    public <R> R findByHqlQuery(final String query);

    public <R> List<R> findListByHqlQuery(final String query);

    public Criteria createCriteria();

}
