package de.afinke.orderingsystem.service;

import de.afinke.orderingsystem.domain.Person;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface PersonService {

    void createPerson(Person person);

    Person readPerson(Long id);

    void updatePerson(Person person);

    void deletePerson(Person person);

    List<Person> listPersons();

}
