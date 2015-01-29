/*
 * Class : Person.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 5:19:27 PM
 * ---------------------------------------------------------------------------
 * Change History
 * Develper :
 * Reviwer :
 * Changed ON :
 * ---------------------------------------------------------------------------
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugsupplychain.neu.css.model.person;

import drugsupplychain.neu.css.model.address.Address;

/**
 *
 * @author Laksh
 */
public class Person {
    private String name;
    private final int personId;
    private Address address;

   
    private String contactNumber;
    private String email;

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    private static int counter = 0;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Person.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public int getPersonId() {
        return personId;
    }   

    public Person() {
        this.personId = counter++;
        address = new Address();
    }
}
