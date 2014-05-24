package de.afinke.orderingsystem.service.dao;

import de.afinke.orderingsystem.domain.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("orderDao")
public class OrderDaoHibernateImpl implements OrderDao {

    private SessionFactory sessionFactory;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void create(Order entity) {
        currentSession().save(entity);
    }

    public Order read(Long key) {
        return (Order) currentSession().get(Order.class, key);
    }

    public void update(Order entity) {
        currentSession().saveOrUpdate(entity);
    }

    public void delete(Order entity) {
        currentSession().delete(entity);
    }

    public List<Order> list() {
        return currentSession().createCriteria(Order.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
