package de.afinke.orderingsystem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public class HibernateDao<E, K extends Serializable> implements Dao<E, K> {

    protected Class<? extends E> daoType;
    private SessionFactory sessionFactory;

    public HibernateDao() {
        daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(Object entity) {
        currentSession().save(entity);
    }

    @Override
    public E read(K key) {
        return (E) currentSession().get(daoType, key);
    }

    @Override
    public void update(Object entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Object entity) {
        currentSession().delete(entity);
    }

    @Override
    public List list() {
        return currentSession().createCriteria(daoType).list();
    }
}
