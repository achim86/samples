package de.afinke.storagesystem.service.impl;

import de.afinke.storagesystem.dao.OrderDao;
import de.afinke.storagesystem.domain.Order;
import de.afinke.storagesystem.domain.Person;
import de.afinke.storagesystem.domain.Product;
import de.afinke.storagesystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void createOrder(Order order) {
        orderDao.create(order);
    }

    @Override
    public Order readOrder(Long id) {
        return orderDao.read(id);
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.update(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderDao.delete(order);
    }

    @Override
    public List<Order> listOrders() {
        return orderDao.list();
    }

    @Override
    public List<Order> listOrdersForPerson(Person person) {
        List<Order> orders = listOrders();
        List<Order> ordersForPerson = new ArrayList<Order>();
        for (Order order : orders) {
            if (person.equals(order.getCustomer())) {
                ordersForPerson.add(order);
            }
        }
        return ordersForPerson;
    }

    @Override
    public double calculateValueOfOrder(Order order) {
        double value = 0;
        for (Product product : order.getProducts()) {
            value += product.getPrice();
        }
        return value;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
