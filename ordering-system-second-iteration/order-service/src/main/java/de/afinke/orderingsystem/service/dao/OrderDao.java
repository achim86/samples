package de.afinke.orderingsystem.service.dao;

import de.afinke.orderingsystem.domain.Order;

import java.util.List;

public interface OrderDao {

    void create(Order entity);

    Order read(Long key);

    void update(Order entity);

    void delete(Order entity);

    List<Order> list();
}
