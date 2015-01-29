/*
 * Class : StateDistributorDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 11:15:23 PM
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
package drugsupplychain.neu.css.model.distributor;

import drugsupplychain.neu.css.model.organization.Directory;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class StateDistributorDirectory extends Directory{
    private final ArrayList<StateDistributor> stateDistributorList;
    /**
     * constructor
     */
    public StateDistributorDirectory() {
        stateDistributorList = new ArrayList<>();
    }
    /**
     * get the list
     * @return 
     */
    public ArrayList<StateDistributor> getStateDistributorList() {
        return stateDistributorList;
    }    
    /**
     * create the distributor
     * @return 
     */
    public StateDistributor addStateDistributor(){
        StateDistributor stateDistributor = new StateDistributor();
        stateDistributorList.add(stateDistributor);
        return stateDistributor;                
    }
    /**
     *  add the distributor
     * @param stateDistributor 
     */
    public void addStateDistributor(StateDistributor stateDistributor){
        stateDistributorList.add(stateDistributor);              
    }
    /**
     * remove state distributor 
     * @param stateDistributor 
     */
    public void removeStateDistributor(StateDistributor stateDistributor){
        stateDistributorList.remove(stateDistributor);              
    }
    /**
     * search by name
     * @param name
     * @return 
     */
    public StateDistributor searchStateDistributor(String name){
        for(StateDistributor stateDistributor : stateDistributorList){
            if (stateDistributor.getName().equals(name)){
                return stateDistributor;
            }
        }
        return null;
    }
    /**
     *  search by id
     * @param organizationID
     * @return 
     */
    public StateDistributor searchStateDistributor(int organizationID){
        for(StateDistributor stateDistributor : stateDistributorList){
            if (stateDistributor.getOrganizationID() == organizationID){
                return stateDistributor;
            }
        }
        return null;
    }
    /**
     * search by license number
     * @param licenseNumber
     * @return 
     */
    public StateDistributor searchStateDistributorByLicense(String licenseNumber){
        for(StateDistributor stateDistributor : stateDistributorList){
            if (stateDistributor.getLincense().getLicenseNumber().equalsIgnoreCase(licenseNumber)){
                return stateDistributor;
            }
        }
        return null;
    }
}
