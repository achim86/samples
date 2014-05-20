package de.afinke.orderingsystem.dao.impl;

import de.afinke.orderingsystem.dao.PersonDao;
import de.afinke.orderingsystem.domain.Person;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personDao")
public class PersonDaoImpl extends HibernateDao<Person, Long> implements PersonDao {

    @Override
    public List<Person> list() {
        return currentSession().createCriteria(Person.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

}