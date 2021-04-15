package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Orders {
    private int orderId;
    private ArrayList<String> orders;
    private LocalDate orderDate;
    private double price;




    public Orders(int orderId,ArrayList<String> orders, LocalDate orderDate,double price);{
        setOrderId(orderId);
        setOrders(new ArrayList<>());
        setOrderDate(orderDate);
        setPrice(price);
    }
    public void setOrders(ArrayList<String> orders){
        this.orders = orders;
    }
    public void addOrder(Orders newOrder)
    {
        if (Orders.size()<40)
            Orders.add(newOrder);
        else
            throw new IllegalArgumentException("Orders is full");
    }

    //getter for the order id
    public int getOrderId() {
        return orderId;
    }

    //set order id which is greater than or equal or 5
    public void setOrderId(int orderId) {
        if(orderId >=5)
            this.orderId = orderId;
        else
            throw new IllegalArgumentException("order id must be greater or equals than 5");
    }

    public ArrayList<String> getOrders() {
        return orders;
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

