package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/*Purpose: The customer uses the person class where the customer can order and they have their order id
*name: Harman Kaur
* date:2021-04-04
* time: 2:pm
*/
public class Customer{
    private String firstName, lastName, address, gender;
    private LocalDate birthday;

    public Customer(String firstName, String lastName, String address, String gender, LocalDate birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setGender(gender);
        setBirthday(birthday);
    }

    /**
     * This returns the Person's age in years based on their birthday and the current date
     * @return
     */
    public int getAge()
    {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    /**
     * firstName needs to be comprised of alphabetic characters, starting with an upper case letter
     * @param firstName
     */
    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        if (firstName.length()>=2){
            firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
            if (firstName.matches("[A-Z][a-z]*"))
                this.firstName = firstName;
            else
                throw new IllegalArgumentException("Names must start with an upper case letter and only contain alphabetic characters");
        }
        else
            throw new IllegalArgumentException("First name must have at least 2 characters");

    }

    //the last name is validated by putting some validation here
    public void setLastName(String lastName) {
        lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
        if (lastName.matches("[A-Z][a-z]*"))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("must be alphabetic & not contain spaces or -");
    }

    //address is validated here
    public void setAddress(String address) {
        address = address.trim();
        if (address.length()>=5 && address.length()<=100)
            this.address = address;
        else
            throw new IllegalArgumentException("Address must be 5 to 100 characters");
    }

    //the birthday is ensure that is in past not the date is written in future
    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("birthday cannot be in the future");
        this.birthday = birthday;
    }


    //the gender of the person is placed here
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        if( gender == "f"||gender =="F"||gender =="female"||gender
                =="Female"||gender =="FEMALE")
        {
            System.out.println("A female" );
        }
        if( gender == "m"||gender =="M"||gender =="male"||gender
                =="Male"||gender =="MALE")
        {
            System.out.println("A male.");
        }
        return gender;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String toString()
    {
        return String.format("%s %s age: %d years", firstName, lastName, getAge());
    }
}
