package de.afinke.orderingsystem.dao.product;

import de.afinke.orderingsystem.domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("productDao")
public class ProductDaoHibernateImpl implements ProductDao {

    private SessionFactory sessionFactory;

    public ProductDaoHibernateImpl() {
    }

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void create(Product entity) {
        currentSession().save(entity);
    }

    public Product read(Long key) {
        return (Product) currentSession().get(Product.class, key);
    }

    public void update(Product entity) {
        currentSession().saveOrUpdate(entity);
    }

    public void delete(Product entity) {
        currentSession().delete(entity);
    }

    public List<Product> list() {
        return currentSession().createCriteria(Product.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
