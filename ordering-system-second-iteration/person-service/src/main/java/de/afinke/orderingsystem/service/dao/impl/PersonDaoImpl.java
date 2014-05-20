package de.afinke.orderingsystem.service.dao.impl;

import de.afinke.orderingsystem.dao.HibernateDao;
import de.afinke.orderingsystem.domain.Person;
import de.afinke.orderingsystem.service.dao.PersonDao;
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
