package de.afinke.orderingsystem.dao.impl;

import de.afinke.orderingsystem.dao.OrderDao;
import de.afinke.orderingsystem.domain.Order;
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
