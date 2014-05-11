package de.afinke.storagesystem.service.impl;

import de.afinke.storagesystem.dao.ProductDao;
import de.afinke.storagesystem.domain.Product;
import de.afinke.storagesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("productService")
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