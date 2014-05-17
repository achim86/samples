package de.afinke.storagesystem.service.impl;

import de.afinke.storagesystem.dao.OrderDao;
import de.afinke.storagesystem.domain.Order;
import de.afinke.storagesystem.domain.Person;
import de.afinke.storagesystem.domain.Product;
import de.afinke.storagesystem.service.OrderService;
import de.afinke.storagesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductService productService;

    @Override
    public boolean createOrder(Order order) {
        for (Product product : order.getProducts()) {
            int quantity = product.getQuantity();
            if (0 >= quantity) {
                return false;
            } else {
                product.setQuantity(quantity - 1);
                productService.updateProduct(product);
                orderDao.create(order);
                return true;
            }
        }
        return false;
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
}
