package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
/*Purpose: The customer class tests the methods of customer class
 *name: Harman Kaur
 * date:2021-04-04
 * time: 2:pm
 */


class CustomerTest {

    Customer customer;

    @BeforeEach
    void setUp(){
        customer = new Customer("Harman","Kaur","39 SandWay drive",
                "Female", LocalDate.of(2001,12,14),12345);
    }

    @Test
    void getOrderId() {
        assertEquals(12345, customer.getOrderId());
    }

    @Test
    void setOrderId() {
        assertEquals(12345, customer.getOrderId());
    }

    @Test
    void addOrder() {
        customer.addOrders("cake" + "Milk");
        ArrayList<String> expResult =  new ArrayList<>();
        expResult.add("cake" + "Milk");
        assertEquals(expResult,customer.getOrders());
    }

    @Test
    void getOrders() {

    }

    @Test
    void addOrderInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                customer.addOrders("Deserts"));
    }

    @Test
    void addOrderInvalid2() {
        assertThrows(IllegalArgumentException.class, ()->
                customer.addOrders("Cold drinks"));
    }
}