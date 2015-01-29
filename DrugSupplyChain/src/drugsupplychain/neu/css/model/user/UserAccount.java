/*
 * Class : UserAccount.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 1:30:25 AM
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
package drugsupplychain.neu.css.model.user;

import drugsupplychain.neu.css.model.person.Person;
import drugsupplychain.neu.css.model.request.WorkQueue;
import drugsupplychain.neu.css.model.role.Role;

/**
 *
 * @author Laksh
 */
public class UserAccount {
    private String username;
    private String password;
    private Person person;    
    private Role role;
    private final WorkQueue workQueue;

    public UserAccount() {
        workQueue = new WorkQueue();
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    
    public WorkQueue getWorkQueue() {
        return workQueue;
    }   
    
    @Override
    public String toString() {
        return username;
    }
    
}
