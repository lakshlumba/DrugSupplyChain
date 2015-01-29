/*
 * Class : PersonDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 5:20:27 PM
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

import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class PersonDirectory {
     private final ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    
    public Person createPerson(String name){
        Person person = new Person();
        person.setName(name);
        personList.add(person);
        return person;
    }
    
}
