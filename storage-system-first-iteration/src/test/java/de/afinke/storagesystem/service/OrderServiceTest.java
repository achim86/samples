package de.afinke.storagesystem.service;

import de.afinke.storagesystem.dao.OrderDao;
import de.afinke.storagesystem.domain.Order;
import de.afinke.storagesystem.domain.Person;
import de.afinke.storagesystem.domain.Product;
import de.afinke.storagesystem.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    private OrderServiceImpl orderService = new OrderServiceImpl();

    @Test
    public void testCalculateValueOfOrder() {
        Order order = createTestOrder();
        double result = orderService.calculateValueOfOrder(order);
        assertEquals(25.0, result, 0);
    }

    @Test
    public void testListOrdersForPerson() {
        OrderDao orderDao = mock(OrderDao.class);
        when(orderDao.list()).thenReturn(createTestOrders());
        orderService.setOrderDao(orderDao);
        List<Order> orders = orderService.listOrdersForPerson(new Person("TestPersonOne"));
        assertEquals(1, orders.size());
    }

    private Order createTestOrder() {
        Order order = createTestOrder("TestPersonOne");
        return order;
    }

    private Order createTestOrder(String personName) {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("TestProduct10", 10.0));
        products.add(new Product("TestProduct15", 15.0));
        Person person = new Person(personName);
        Order order = new Order(products, person);
        return order;
    }

    private List<Order> createTestOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(createTestOrder("TestPersonOne"));
        orders.add(createTestOrder("TestPersonTwo"));
        return orders;
    }
}
