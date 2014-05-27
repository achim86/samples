package de.afinke.orderingsystem.service;

import de.afinke.orderingsystem.dao.order.OrderDao;
import de.afinke.orderingsystem.domain.Order;
import de.afinke.orderingsystem.domain.Person;
import de.afinke.orderingsystem.domain.Product;
import de.afinke.orderingsystem.service.orderservice.OrderServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests business logic of order service using mocked OrderDao.
 */
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
        /* Check http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html
        *  for more Mockito recipes and great explanation of the framework. */
        OrderDao orderDao = mock(OrderDao.class);
        when(orderDao.list()).thenReturn(createTestOrders());
        orderService.setOrderDao(orderDao);
        Person testPerson = new Person("TestPersonOne");
        List<Order> orders = orderService.listOrdersForPerson(testPerson);
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
