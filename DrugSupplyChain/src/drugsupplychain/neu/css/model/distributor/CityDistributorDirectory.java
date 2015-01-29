/*
 * Class : CityDistributorDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 11:14:47 PM
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
public class CityDistributorDirectory extends Directory{
    private final ArrayList<CityDistributor> cityDistributorList;
    /**
     * constructor
     */
    public CityDistributorDirectory(){
       cityDistributorList = new ArrayList<>();
    }
    /**
     * get the city distributor
     * @return 
     */
    public ArrayList<CityDistributor> getCityDistributorList() {
        return cityDistributorList;
    }
    /**
     * add the city distributor
     * @return 
     */
    public CityDistributor addCityDistributor(){
        CityDistributor cityDistributor =  new CityDistributor();
        cityDistributorList.add(cityDistributor);
        return cityDistributor;        
    }
    /**
     * remove the distributor
     * @param cityDistributor 
     */
    public void removeCityDistributor(CityDistributor cityDistributor){
        cityDistributorList.remove(cityDistributor);
    } 
    /**
     * add the distributor
     * @param cityDistributor 
     */
    public void addCityDistributor(CityDistributor cityDistributor){
        cityDistributorList.add(cityDistributor);
    }
    /**
     * search the 
     * @param lincenseNumber
     * @return 
     */
    public CityDistributor searchCityDistributorByLicense(String lincenseNumber) {
        for (CityDistributor cityDistributor : cityDistributorList){
            if (cityDistributor.getLincense().getLicenseNumber().equals(lincenseNumber)){
                return cityDistributor;
            }
        }
        return null;
    }
    /**
     * search the 
     * @param name
     * @return 
     */
    public CityDistributor searchCityDistributor(String name) {
        for (CityDistributor cityDistributor : cityDistributorList){
            if (cityDistributor.getName().equals(name)){
                return cityDistributor;
            }
        }
        return null;
    }
    /**
     * search the 
     * @param organizationId
     * @return 
     */
    public CityDistributor searchCityDistributor(int organizationId) {
        for (CityDistributor cityDistributor : cityDistributorList){
            if (cityDistributor.getOrganizationID() == organizationId){
                return cityDistributor;
            }
        }
        return null;
    }
}
