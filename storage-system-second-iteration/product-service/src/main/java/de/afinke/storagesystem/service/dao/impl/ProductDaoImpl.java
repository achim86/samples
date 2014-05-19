package de.afinke.storagesystem.service.dao.impl;

import de.afinke.storagesystem.dao.HibernateDao;
import de.afinke.storagesystem.domain.Product;
import de.afinke.storagesystem.service.dao.ProductDao;
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
