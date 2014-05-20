package de.afinke.orderingsystem.service;

import de.afinke.orderingsystem.domain.Person;

import java.util.List;

public interface PersonService {

    void createPerson(Person person);

    Person readPerson(Long id);

    void updatePerson(Person person);

    void deletePerson(Person person);

    List<Person> listPersons();

}
