package de.afinke.storagesystem.webapp;

import de.afinke.storagesystem.domain.Person;
import de.afinke.storagesystem.domain.Product;
import de.afinke.storagesystem.service.PersonService;
import de.afinke.storagesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Component
@ManagedBean
@SessionScoped
public class IndexBean {

    @Autowired
    private PersonService personService;
    @Autowired
    private ProductService productService;

    public void createTestData() {
        personService.createPerson(new Person("Max Mustermann"));
        personService.createPerson(new Person("Erika Mustermann"));

        productService.createProduct(new Product("Gummy Bears", 2.50));
        productService.createProduct(new Product("Chocolate", 1.00));
    }
}
