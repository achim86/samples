package de.afinke.storagesystem.service.impl;

import de.afinke.storagesystem.domain.Person;
import de.afinke.storagesystem.service.PersonService;
import de.afinke.storagesystem.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("personService")
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
