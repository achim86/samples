package de.afinke.orderingsystem.service.orderservice;

import de.afinke.orderingsystem.domain.Order;
import de.afinke.orderingsystem.domain.Person;

import java.util.List;

public interface OrderService {

    void createOrder(Order order);

    Order readOrder(Long id);

    void updateOrder(Order order);

    void deleteOrder(Order order);

    List<Order> listOrders();

    List<Order> listOrdersForPerson(Person person);

    double calculateValueOfOrder(Order order);

}
