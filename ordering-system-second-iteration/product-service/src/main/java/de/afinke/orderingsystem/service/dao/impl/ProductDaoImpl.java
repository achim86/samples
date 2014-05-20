package de.afinke.orderingsystem.service.dao.impl;

import de.afinke.orderingsystem.dao.HibernateDao;
import de.afinke.orderingsystem.domain.Product;
import de.afinke.orderingsystem.service.dao.ProductDao;
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
