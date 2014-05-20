package de.afinke.orderingsystem.dao.impl;

import de.afinke.orderingsystem.dao.ProductDao;
import de.afinke.orderingsystem.domain.Product;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends HibernateDao<Product, Long> implements ProductDao {

    @Override
    public List<Product> list() {
        return currentSession().createCriteria(Product.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

}
