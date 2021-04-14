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


    /*Purpose: The main class is created which contains the information about the person class in which all the methods are tested
     *name: Harman Kaur
     * date:2021-04-04
     * time: 2:pm
     */

        Customer customer;
        @BeforeEach
        void setUp(){
            customer = new Customer("Harman","Kaur","39 SandWay drive",
                    "Female", LocalDate.of(2001,12,14));
        }

        @Test
        void getAge() {
            assertEquals(19,customer.getAge());
        }

        @Test
        void setFirstName() {
            customer.setFirstName("Harman");
            assertEquals("Harman",customer.getFirstName());
        }

        @Test
        void setFirstNameInvalidEmpty() {
            assertThrows(IllegalArgumentException.class, ()->
                    customer.setFirstName(""));
        }

        @Test
        void setFirstNameInvalidNumbersEnd() {
            assertThrows(IllegalArgumentException.class, ()->
                    customer.setFirstName("Harman12345"));
        }

        @Test
        void setFirstNameInvalidNumbers() {
            assertThrows(IllegalArgumentException.class, ()->
                    customer.setFirstName("67HH77"));
        }

        @Test
        void setLastName() {
            customer.setLastName("Kaur");
            assertEquals("Kaur",customer.getLastName());
        }

        @Test
        void setlastNameInvalidEmpty() {
            assertThrows(IllegalArgumentException.class, ()->
                    customer.setFirstName(""));
        }

        @Test
        void setLastNameInvalidNumbersEnd() {
            assertThrows(IllegalArgumentException.class, ()->
                    customer.setFirstName("Harman123"));
        }

        @Test
        void setLastNameInvalidNumbers() {
            assertThrows(IllegalArgumentException.class, ()->
                    customer.setFirstName("22ff"));
        }

        @Test
        void setAddress() { customer.setAddress("39 Sandway Drive, Brampton, ON");
            assertEquals("39 Sandway Drive, Brampton, ON", customer.getAddress());
        }

        @Test
        void setInvalidAddressEmpty()
        {
            assertThrows(IllegalArgumentException.class, ()->
                    customer.setAddress("    "));
        }

        @Test
        void setBirthday()
        {
            customer.setBirthday(LocalDate.of(2001,12,14));
            assertEquals(LocalDate.of(2001,12,14),customer.getBirthday());
        }

        @Test
        void setInvalidBirthdayFuture()
        {
            assertThrows(IllegalArgumentException.class, ()->
                    customer.setBirthday(LocalDate.of(2030,01,01)));
        }

        @Test
        void getGender()
        {
            customer.setGender("Female");
            assertEquals("Female",customer.getGender());
        }//test for the gender

        @Test
        void getGenderInvalid()
        {
            customer.setGender("Male");
            assertEquals("Male",customer.getGender());
        }//test for the gender
}
