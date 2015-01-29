/*
 * Class : RegionalDistributorDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 11:15:11 PM
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
public class RegionalDistributorDirectory extends Directory{
    private final ArrayList<RegionalDistributor> regionalDistributorList;
    /**
     * 
     */
    public RegionalDistributorDirectory() {
        regionalDistributorList = new ArrayList<>();
    }
    /**
     * 
     * @return 
     */
    public ArrayList<RegionalDistributor> getRegionalDistributorList() {
        return regionalDistributorList;
    }
    /**
     * create new distributor
     * @return 
     */
    public RegionalDistributor addRegionalDistributor(){
        RegionalDistributor regionalDistributor =  new RegionalDistributor();
        regionalDistributorList.add(regionalDistributor);
        return regionalDistributor;
    }
    /*
    * add the distribuor 
    */
    public void addRegionalDistributor(RegionalDistributor regionalDistributor){
        regionalDistributorList.add(regionalDistributor);
    }
    /**
     * remove the distributor
     * @param regionalDistributor 
     */
    public void removeRegionalDistributor(RegionalDistributor regionalDistributor){
        regionalDistributorList.remove(regionalDistributor);
    }
    /**
     * search by name
     * @param name
     * @return 
     */
    public RegionalDistributor searchRegionalDistributor(String name){
        for (RegionalDistributor regionalDistributor : regionalDistributorList){
            if (regionalDistributor.getName().equals(name)){
                return regionalDistributor;
            }
        }
        return null;
    }
    /**
     * search by organization id
     * @param organizationID
     * @return 
     */
    public RegionalDistributor searchRegionalDistributor(int organizationID){
        for (RegionalDistributor regionalDistributor : regionalDistributorList){
            if (regionalDistributor.getOrganizationID() == organizationID){
                return regionalDistributor;
            }
        }
        return null;
    }
    /**
     * search the regionalDistributor by license number
     * @param licenseNumber
     * @return 
     */
    public RegionalDistributor searchRegionalDistributorByLincense(String licenseNumber){
        for (RegionalDistributor regionalDistributor : regionalDistributorList){
            if (regionalDistributor.getLincense().getLicenseNumber().equals(licenseNumber)){
                return regionalDistributor;
            }
        }
        return null;
    }
}
