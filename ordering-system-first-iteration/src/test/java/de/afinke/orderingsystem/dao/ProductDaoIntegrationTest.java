package de.afinke.orderingsystem.dao;

import de.afinke.orderingsystem.IntegrationTest;
import de.afinke.orderingsystem.dao.product.ProductDao;
import de.afinke.orderingsystem.domain.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductDaoIntegrationTest extends IntegrationTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testCreate() {
        Product product = createTestProduct();

        assertEquals(product, productDao.list().get(0));
    }

    @Test
    public void testRead() {
        Product product = createTestProduct();

        Product expected = productDao.read(product.getId());
        assertEquals(expected, product);
    }

    @Test
    public void testUpdate() {
        Product product = createTestProduct();

        product.setName("test-update");
        productDao.update(product);

        Product expected = productDao.read(product.getId());
        assertEquals("test-update", expected.getName());
    }

    @Test
    public void testDelete() {
        Product product = createTestProduct();

        productDao.delete(product);
        assertTrue(0 == productDao.list().size());
    }

    private Product createTestProduct() {
        Product product = new Product("test", 10.0);
        productDao.create(product);
        assertTrue("Creation of test product failed", 1 == productDao.list().size());
        return product;
    }

}
