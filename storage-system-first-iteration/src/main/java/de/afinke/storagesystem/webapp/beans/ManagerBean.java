package de.afinke.storagesystem.webapp.beans;

import de.afinke.storagesystem.domain.Person;
import de.afinke.storagesystem.domain.Product;
import de.afinke.storagesystem.service.PersonService;
import de.afinke.storagesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@Component
@ManagedBean
@SessionScoped
public class ManagerBean {

    @Autowired
    private PersonService personService;
    @Autowired
    private ProductService productService;
    private Person customer = new Person();
    private Person selectedCustomer;
    private Product product = new Product();
    private Product selectedProduct;

    public Person getCustomer() {
        return customer;
    }

    public void createCustomer() {
        personService.createPerson(customer);
        customer = new Person();
    }

    public void updateCustomer() {
        personService.updatePerson(selectedCustomer);
    }

    public void deleteCustomer(Person customer) {
        personService.deletePerson(customer);
    }

    public List<Person> getCustomers() {
        return personService.listPersons();
    }

    public Product getProduct() {
        return product;
    }

    public void createProduct() {
        productService.createProduct(product);
        product = new Product();
    }

    public void deleteProduct(Product product) {
        productService.deleteProduct(product);
    }

    public void updateProduct() {
        productService.updateProduct(selectedProduct);
    }

    public List<Product> getProducts() {
        return productService.listProducts();
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Person getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Person selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }
}
