package de.afinke.storagesystem.webapp;

import de.afinke.storagesystem.domain.Order;
import de.afinke.storagesystem.domain.Person;
import de.afinke.storagesystem.domain.Product;
import de.afinke.storagesystem.service.OrderService;
import de.afinke.storagesystem.service.PersonService;
import de.afinke.storagesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@SessionScoped
public class CustomerBean {

    @Autowired
    private PersonService personService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    private Person selectedCustomer;
    private String selectedCustomerId;
    private boolean isCustomerSelected;
    private List<Product> shoppingCart = new ArrayList<Product>();

    public String getSelectedCustomerId() {
        return selectedCustomerId;
    }

    public void setSelectedCustomerId(String selectedCustomerId) {
        System.out.println("Set customer id");
        this.selectedCustomerId = selectedCustomerId;
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public List<Person> getCustomers() {
        return personService.listPersons();
    }

    public boolean isCustomerSelected() {
        return isCustomerSelected;
    }

    public void setCustomerSelected(boolean isCustomerSelected) {
        this.isCustomerSelected = isCustomerSelected;
    }

    public Person getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Person selectedCustomer) {
        System.out.println("Set Customer");
        this.selectedCustomer = selectedCustomer;
    }

    public List<Product> getProducts() {
        return productService.listProducts();
    }

    public void lookupSelectedCustomer() {
        isCustomerSelected = true;
        selectedCustomer = personService.readPerson(Long.valueOf(selectedCustomerId));
    }

    public void addProduct(Product product) {
        shoppingCart.add(product);
    }

    public double calculatePrice() {
        double totalAmount = 0;
        for (Product product : shoppingCart) {
            totalAmount += product.getPrice();
        }
        return totalAmount;
    }

    public void placeOrder() {
        orderService.createOrder(new Order(shoppingCart, selectedCustomer));
        resetShoppingCart();
    }

    public double calculateValueForOrder(Order order) {
        return orderService.calculateValueOfOrder(order);
    }

    public List<Order> getOrdersForSelectedCustomer() {
        return orderService.listOrdersForPerson(selectedCustomer);
    }

    public void resetShoppingCart() {
        shoppingCart = new ArrayList<Product>();
    }
}
