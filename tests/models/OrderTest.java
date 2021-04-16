package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {

    Orders order;

    @BeforeEach
    void setUp(){
        ArrayList<String> orderSet = new ArrayList<>();
        order =  new Orders("Harman","Kaur","39 SandWay drive",
                "Female",LocalDate.of(2001,12,14),"32eF",orderSet,LocalDate.of(2021,04,16),22.44);
    }


    @Test
    void addOrder() {
        order.addOrders("cake" + "Milk");
        ArrayList<String> expResult =  new ArrayList<>();
        expResult.add("cake" + "Milk");
        Assertions.assertEquals(expResult,order.getOrders());
    }



    @Test
    void addOrderInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                order.addOrders("Deserts"));
    }

    @Test
    void addOrderInvalid2() {
        assertThrows(IllegalArgumentException.class, ()->
                order.addOrders("Cold drinks"));
    }
    @Test
    void setOrderDate()
    {
        order.setOrderDate(LocalDate.of(2021,04,15));
        assertEquals(LocalDate.of(2021,04,15),order.getOrderDate());
    }

    @Test
    void setPrice(){
        order.setPrice(22.44);
        assertEquals(22.44,order.getPrice());
    }

}
