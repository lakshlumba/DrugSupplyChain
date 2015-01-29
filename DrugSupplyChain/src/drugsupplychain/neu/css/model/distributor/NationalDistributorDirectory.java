/*
 * Class : NationalDistributorDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 11:15:00 PM
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
public class NationalDistributorDirectory extends Directory{
    private final ArrayList<NationalDistributor> nationalDistributorList;
    /**
     * constructor
     */
    public NationalDistributorDirectory(){
       nationalDistributorList = new ArrayList<>();
    }
    /**
     * get the national distributor 
     * @return 
     */
    public ArrayList<NationalDistributor> getNationalDistributorList() {
        return nationalDistributorList;
    }
    /**
     * new distributor
     * @return 
     */
    public NationalDistributor addNationalDistributor(){
        NationalDistributor nationalDistributor =  new NationalDistributor();
        nationalDistributorList.add(nationalDistributor);
        return nationalDistributor;
    }
    /**
     * add the national distributor
     * @param nationalDistributor 
     */
    public void addNationalDistributor(NationalDistributor nationalDistributor){
        nationalDistributorList.add(nationalDistributor);
    }
    /**
     * remove the national distributor
     * @param nationalDistributor 
     */
    public void removeNationalDistributor(NationalDistributor nationalDistributor){
        nationalDistributorList.remove(nationalDistributor);
    }
    /**
     * search by national distributor
     * @param name
     * @return 
     */
    public NationalDistributor searchNationalDistributor(String name){
        for(NationalDistributor nationalDistributor : nationalDistributorList){
            if (nationalDistributor.getName().equalsIgnoreCase(name)){
                return nationalDistributor;
            }
        } 
        return null;
    }
    /**
     * search by organization ID
     * @param organizationId
     * @return 
     */
    public NationalDistributor searchNationalDistributor(int organizationId){
        for(NationalDistributor nationalDistributor : nationalDistributorList){
            if (nationalDistributor.getOrganizationID() == organizationId){
                return nationalDistributor;
            }
        } 
        return null;
    }
    /**
     * search by license number
     * @param licenseNumber
     * @return 
     */
    public NationalDistributor searchNationalDistributorByLincense(String licenseNumber){
        for(NationalDistributor nationalDistributor : nationalDistributorList){
            if (nationalDistributor.getLincense().getLicenseNumber().equalsIgnoreCase(licenseNumber)){
                return nationalDistributor;
            }
        } 
        return null;
    }
}
