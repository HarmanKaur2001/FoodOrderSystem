package utilities;

import models.Customer;
import models.Orders;

import java.util.ArrayList;

public class DButilities {
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    public static ArrayList<Customer> getAllCustomers(){
        return customers;
    }
    public static void addCustomer(Customer customer){
        customers.add(customer);
    }

    private static ArrayList<Orders> orders = new ArrayList<Orders>();
    public static ArrayList<Orders> getAllOrders(){
        return orders;
    }
    public static void addOrders(Orders order){
        orders.add(order);
    }
}
