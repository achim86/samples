package de.afinke.orderingsystem.service;

import de.afinke.orderingsystem.domain.Order;
import de.afinke.orderingsystem.domain.Person;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface OrderService {

    void createOrder(Order order);

    Order readOrder(Long id);

    void updateOrder(Order order);

    void deleteOrder(Order order);

    List<Order> listOrders();

    List<Order> listOrdersForPerson(Person person);

    double calculateValueOfOrder(Order order);

}
