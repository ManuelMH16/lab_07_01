/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sebas.lab07_refactoring;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacks
 */
public class Order {

    private String id;
    private Customer customer;
    private List<OrderItem> items;
    private double total;
    
    public Order() {
        this.items = new ArrayList<>();
    }
    
    public Order(String id, Customer customer, List<OrderItem> items) {
        this.id = id;
        this.customer = customer;
        this.items = items;
    }
    
    // Getters y Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public List<OrderItem> getItems() {
        return items;
    }
    
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
}
