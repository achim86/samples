package de.afinke.storagesystem.service;

import de.afinke.storagesystem.domain.Product;

import java.util.List;

public interface ProductService {

    void createProduct(Product product);

    Product readProduct(Long id);

    void updateProduct(Product product);

    void deleteProduct(Product product);

    List<Product> listProducts();

}
