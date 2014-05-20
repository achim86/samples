package de.afinke.orderingsystem.service.dao.impl;

import de.afinke.orderingsystem.dao.HibernateDao;
import de.afinke.orderingsystem.domain.Order;
import de.afinke.orderingsystem.service.dao.OrderDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends HibernateDao<Order, Long> implements OrderDao {

    @Override
    public List<Order> list() {
        return currentSession().createCriteria(Order.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

}
