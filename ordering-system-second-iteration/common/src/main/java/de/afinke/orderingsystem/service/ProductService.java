package de.afinke.orderingsystem.service;

import de.afinke.orderingsystem.domain.Product;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductService {

    void createProduct(Product product);

    Product readProduct(Long id);

    void updateProduct(Product product);

    void deleteProduct(Product product);

    List<Product> listProducts();

}
