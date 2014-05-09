package de.afinke.storagesystem.dao.impl;

import de.afinke.storagesystem.dao.HibernateDao;
import de.afinke.storagesystem.dao.PersonDao;
import de.afinke.storagesystem.domain.Person;
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
