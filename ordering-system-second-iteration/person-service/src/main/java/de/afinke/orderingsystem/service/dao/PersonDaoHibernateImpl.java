package de.afinke.orderingsystem.service.dao;

import de.afinke.orderingsystem.domain.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("personDao")
public class PersonDaoHibernateImpl implements PersonDao {

    private SessionFactory sessionFactory;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void create(Person entity) {
        currentSession().save(entity);
    }

    public Person read(Long key) {
        return (Person) currentSession().get(Person.class, key);
    }

    public void update(Person entity) {
        currentSession().saveOrUpdate(entity);
    }

    public void delete(Person entity) {
        currentSession().delete(entity);
    }

    public List<Person> list() {
        return currentSession().createCriteria(Person.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
