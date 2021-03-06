package de.afinke.orderingsystem.service;

import de.afinke.orderingsystem.domain.Person;
import de.afinke.orderingsystem.service.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public void createPerson(Person person) {
        personDao.create(person);
    }

    @Override
    public Person readPerson(Long id) {
        return personDao.read(id);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.update(person);
    }

    @Override
    public void deletePerson(Person person) {
        personDao.delete(person);
    }

    @Override
    public List<Person> listPersons() {
        return personDao.list();
    }
}
