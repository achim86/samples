package de.afinke.storagesystem.dao;

import de.afinke.storagesystem.IntegrationTest;
import de.afinke.storagesystem.domain.Order;
import de.afinke.storagesystem.domain.Person;
import de.afinke.storagesystem.domain.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderDaoIntegrationTest extends IntegrationTest {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private PersonDao personDao;

    @Test
    public void testCreate() {
        Order order = createTestOrder();

        assertEquals(order, orderDao.list().get(0));
    }

    @Test
    public void testRead() {
        Order order = createTestOrder();

        Order expected = orderDao.read(order.getId());
        assertEquals(expected, order);
    }

    @Test
    public void testUpdate() {
        Order order = createTestOrder();

        Person customer = order.getCustomer();
        customer.setName("test-update");
        personDao.update(customer);

        Order expected = orderDao.read(order.getId());
        assertEquals("test-update", expected.getCustomer().getName());
    }

    @Test
    public void testDelete() {
        Order order = createTestOrder();

        orderDao.delete(order);
        assertTrue(0 == orderDao.list().size());
    }

    private Order createTestOrder() {
        Product product = new Product("test", 10.0);
        productDao.create(product);
        assertTrue("Creation of test product failed", 1 == productDao.list().size());
        List<Product> products = new ArrayList<Product>();
        products.add(product);

        Person person = new Person("test");
        personDao.create(person);
        assertTrue("Creation of test person failed", 1 == personDao.list().size());

        Order order = new Order(products, person);
        orderDao.create(order);
        assertTrue("Creation of test order failed", 1 == orderDao.list().size());

        return order;
    }

}
