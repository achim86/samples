package de.afinke.storagesystem.service;

import de.afinke.storagesystem.IntegrationTest;
import de.afinke.storagesystem.domain.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonServiceIntegrationTest extends IntegrationTest {
    @Autowired
    private PersonService personService;

    @Test
    public void testCreate() {
        Person person = createTestPerson();

        assertEquals(person, personService.list().get(0));
    }

    @Test
    public void testRead() {
        Person person = createTestPerson();

        Person expected = personService.readPerson(person.getId());
        assertEquals(expected, person);
    }

    @Test
    public void testUpdate() {
        Person person = createTestPerson();

        person.setName("test-update");
        personService.updatePerson(person);

        Person expected = personService.readPerson(person.getId());
        assertEquals("test-update", expected.getName());
    }

    @Test
    public void testDelete() {
        Person person = createTestPerson();

        personService.deletePerson(person);
        assertTrue(0 == personService.list().size());
    }

    private Person createTestPerson() {
        Person person = new Person("test");
        personService.createPerson(person);
        assertTrue("Creation of test person failed", 1 == personService.list().size());
        return person;
    }
}
