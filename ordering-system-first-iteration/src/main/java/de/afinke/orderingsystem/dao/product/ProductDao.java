package de.afinke.orderingsystem.dao.product;

import de.afinke.orderingsystem.domain.Product;

import java.util.List;

public interface ProductDao {

    void create(Product entity);

    Product read(Long key);

    void update(Product entity);

    void delete(Product entity);

    List<Product> list();
}
