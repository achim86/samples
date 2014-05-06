package de.afinke.storagesystem.service.dao;

import de.afinke.storagesystem.domain.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonDaoTest extends DaoTest {

    @Autowired
    private PersonDao personDao;

    @Test
    public void testCreate() {
        Person person = createTestPerson();

        assertEquals(person, personDao.list().get(0));
    }

    @Test
    public void testRead() {
        Person person = createTestPerson();

        Person expected = personDao.read(person.getId());
        assertEquals(expected, person);
    }

    @Test
    public void testUpdate() {
        Person person = createTestPerson();

        person.setName("test-update");
        personDao.update(person);

        Person expected = personDao.read(person.getId());
        assertEquals("test-update", expected.getName());
    }

    @Test
    public void testDelete() {
        Person person = createTestPerson();

        personDao.delete(person);
        assertTrue(0 == personDao.list().size());
    }

    private Person createTestPerson() {
        Person person = new Person("test");
        personDao.create(person);
        assertTrue("Creation of test person failed", 1 == personDao.list().size());
        return person;
    }

}