/*
 * Class : UserAccountDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 1:30:38 AM
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
import drugsupplychain.neu.css.model.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class UserAccountDirectory {
    private final ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount userAccount : userAccountList)
            if (userAccount.getUsername().equals(username) && userAccount.getPassword().equals(password)){
                return userAccount;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Person person, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
}
