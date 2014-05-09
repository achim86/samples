package de.afinke.storagesystem.webapp.model;

import de.afinke.storagesystem.domain.Person;
import de.afinke.storagesystem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@Component
@ManagedBean
@SessionScoped
public class ManagerModel {

    @Autowired
    PersonService personService;

    private Person customer;

    public Person getCustomer() {
        customer = new Person();
        return customer;
    }

    public void saveCustomer() {
        personService.createPerson(customer);
    }

    public List<Person> getCustomers() {
        return personService.listPersons();
    }
}
