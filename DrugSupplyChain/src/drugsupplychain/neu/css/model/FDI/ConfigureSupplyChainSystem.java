/*
 * Class : ConfigureSupplyChainSystem.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 7:59:26 PM
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
package drugsupplychain.neu.css.model.FDI;

import drugsupplychain.neu.css.model.address.Address;
import drugsupplychain.neu.css.model.person.Person;
import drugsupplychain.neu.css.model.role.FDISystemRole;


/**
 *
 * @author Laksh
 */
public class ConfigureSupplyChainSystem {
    /**
     * configure the system
     * @return 
     */
    public static FDISystem configure(){
        FDISystem fDISystem = FDISystem.getInstance();
        Person person = fDISystem.getPersonDirectory().createPerson("laksh");
        Address address = new Address();
        address.setAddressLine1("37 Iroquious Street");
        address.setAddressLine2("");
        address.setCity("Boston");
        address.setState("MA");
        address.setCountry("USA");
        address.setZipcode("02120");
        person.setAddress(address);
        person.setEmail("lumba.l@husky.neu.edu");
        fDISystem.getUserAccountDirectory().createUserAccount("admin", "admin", person, new FDISystemRole());
        return fDISystem;
    }
 }
