package models;

import controllers.CustomerViewController;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Orders extends Customer {
    private String orderId;
    private ArrayList<String> orders;
    private LocalDate orderDate;
    private double price;



    public Orders(String firstName, String lastName, String address, String gender, LocalDate birthDay, String orderId, ArrayList<String> orders,
                  LocalDate orderDate, double price){
        super(firstName, lastName,address,gender,birthDay);
        setOrderId(orderId);
        setOrderDate(orderDate);
        setOrders(orders);
        setPrice(price);
    }

    public void setOrders(ArrayList<String> orders) {
        ArrayList<String> orderSet = new ArrayList<String>();
        orderSet.addAll(Arrays.asList("Drinks", "Snacks", "Deserts", "Maincourse"));
        if (orders != null) {
            this.orders = orders;
        }
        else{
            throw new IllegalArgumentException("enter any order");
        }
    }

    public ArrayList<String> getOrders() {
        return orders;
    }

    //getter for the order id
    public String getOrderId() {
        return orderId;
    }

    //set order id which is greater than or equal or 5
    public void setOrderId(String orderId) {
        if(orderId != null)
            this.orderId = orderId;
        else
            throw new IllegalArgumentException("order id must be greater or equals than 5");
    }

    //order will be added as arraylist
    public void addOrders(String items) {
        if (items.matches("cake" + "Milk"))
            orders.add(items);
        else
            throw new IllegalArgumentException("Not contains the items");
    }
    public void setOrderDate(LocalDate orderDate) {
        if (orderDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException(" order date cannot be in past, put the present date for order");
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price != 0)
        {
            this.price = price;
        }
        else
        {
            throw new IllegalArgumentException("Amount Cannot be zero, select any item from the list");
        }
    }
}

