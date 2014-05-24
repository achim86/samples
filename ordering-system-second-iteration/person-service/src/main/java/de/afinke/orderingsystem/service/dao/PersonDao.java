package de.afinke.orderingsystem.service.dao;

import de.afinke.orderingsystem.domain.Person;

import java.util.List;

public interface PersonDao {

    void create(Person entity);

    Person read(Long key);

    void update(Person entity);

    void delete(Person entity);

    List<Person> list();
}