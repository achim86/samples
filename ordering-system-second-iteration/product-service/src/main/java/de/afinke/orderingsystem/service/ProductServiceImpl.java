package de.afinke.orderingsystem.service;

import de.afinke.orderingsystem.domain.Product;
import de.afinke.orderingsystem.service.ProductService;
import de.afinke.orderingsystem.service.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void createProduct(Product product) {
        productDao.create(product);
    }

    @Override
    public Product readProduct(Long id) {
        return productDao.read(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.update(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productDao.delete(product);
    }

    @Override
    public List<Product> listProducts() {
        return productDao.list();
    }
}
