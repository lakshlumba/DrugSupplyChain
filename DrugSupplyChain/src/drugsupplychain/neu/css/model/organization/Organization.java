/*
 * Class : Organization.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 1:14:43 AM
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
package drugsupplychain.neu.css.model.organization;

import drugsupplychain.neu.css.model.address.Address;
import drugsupplychain.neu.css.model.address.License;
import drugsupplychain.neu.css.model.person.PersonDirectory;
import drugsupplychain.neu.css.model.request.WorkQueue;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.user.UserAccountDirectory;
import drugsupplychain.neu.css.util.ImplConst;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public abstract class Organization {    
    private String name;
    private String location;
    private WorkQueue workQueue;
    private final PersonDirectory personDirectory;
    private final UserAccountDirectory userAccountDirectory;
    private final int organizationID;
    private static int counter;
    private Address address;
    private License lincense;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public License getLincense() {
        return lincense;
    }

    public void setLincense(License lincense) {
        this.lincense = lincense;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    
    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }  
    
    public enum Type{
        REGIONAL_FDI(ImplConst.REGIONAL_FDI),
        NATIONAL_FDI(ImplConst.NATIONAL_FDI),
        STATE_FDI(ImplConst.STATE_FDI),
        CITY_FDI(ImplConst.CITY_FDI),
        
        REGIONAL_DISTRIBUTOR(ImplConst.REGIONAL_DISTRIBUTOR),
        NATIONAL_DISTRIBUTOR(ImplConst.NATIONAL_DISTRIBUTOR),
        STATE_DISTRIBUTOR(ImplConst.STATE_DISTRIBUTOR),
        CITY_DISTRIBUTOR(ImplConst.CITY_DISTRIBUTOR),
        
        INTER_PHARMA_CO(ImplConst.INTER_PHARMA_CO),
        REGIONAL_PHARMA_CO(ImplConst.REGIONAL_PHARMA_CO),
        NATIONAL_PHARMA_CO(ImplConst.NATIONAL_PHARMA_CO),
        STATE_PHARMA_CO(ImplConst.STATE_PHARMA_CO),
        CITY_PHARMA_CO(ImplConst.CITY_PHARMA_CO),
        
        DOCTOR(ImplConst.DOCTOR), 
        CLINIC(ImplConst.CLINIC),
        DISPENCERY(ImplConst.DISPENCERY), 
        HOSPITAL(ImplConst.HOSPITAL), 
        PATIENT(ImplConst.PATIENT),
        PHARMACY(ImplConst.PHARMACY);
        
        private final String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        lincense = new License(name);        
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        address = new Address();
        organizationID = counter;
        ++counter;
    }
    public abstract ArrayList<Role> getSupportedRole();
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
