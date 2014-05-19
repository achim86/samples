package de.afinke.storagesystem.service.dao.impl;

import de.afinke.storagesystem.dao.HibernateDao;
import de.afinke.storagesystem.domain.Order;
import de.afinke.storagesystem.service.dao.OrderDao;
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
