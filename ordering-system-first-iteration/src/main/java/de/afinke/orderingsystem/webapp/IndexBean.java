package de.afinke.orderingsystem.webapp;

import de.afinke.orderingsystem.domain.Person;
import de.afinke.orderingsystem.domain.Product;
import de.afinke.orderingsystem.service.personservice.PersonService;
import de.afinke.orderingsystem.service.productservice.ProductService;
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
