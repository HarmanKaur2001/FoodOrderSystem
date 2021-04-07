package models;

import java.time.LocalDate;
import java.util.ArrayList;

/*Purpose: The customer uses the person class where the customer can order and they have their order id
*name: Harman Kaur
* date:2021-04-04
* time: 2:pm
*/
public class Customer extends Person{
    private int orderId;
    private ArrayList<String> orders;

    //the customer use most of variables from the person class but orderr id and orders are added
    public Customer(String firstName, String lastName, String address, String gender, LocalDate birthday, int orderId) {
        super(firstName, lastName, address, gender, birthday);
        setOrderId(orderId);
        setOrders(new ArrayList<>());
    }

    //orders need to be set
    public void setOrders(ArrayList<String> orders){
        this.orders = orders;
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
}
