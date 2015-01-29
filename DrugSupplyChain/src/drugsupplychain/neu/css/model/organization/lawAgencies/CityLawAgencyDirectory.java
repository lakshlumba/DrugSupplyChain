/*
 * Class : CityLawAgencyDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 11:13:57 PM
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
package drugsupplychain.neu.css.model.organization.lawAgencies;

import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class CityLawAgencyDirectory {
     private final ArrayList<CityLawAgency> cityLawAgencyList;
    /**
     * constructor city Law Agency directory
     */
    public CityLawAgencyDirectory() {
        cityLawAgencyList = new ArrayList<>();
    }

    public ArrayList<CityLawAgency> getCityLawAgencyList() {
        return cityLawAgencyList;
    }
    
    /**
     * add the CityLawAgency
     * @return 
     */
    public CityLawAgency addCityLawAgency(){
        CityLawAgency cityLawAgency =  new CityLawAgency();
        cityLawAgencyList.add(cityLawAgency);
        return cityLawAgency;
    }
    /**
     * remove the CityLawAgency
     * @param cityLawAgency 
     */
    public void removeCityLawAgency(CityLawAgency cityLawAgency){
        cityLawAgencyList.remove(cityLawAgency);
    }
    
    /**
     * Search the Agency according to the city
     * @param city
     * @return 
     */
    public CityLawAgency searchCityLawAgency(String city){
        for(CityLawAgency cityLawAgency : cityLawAgencyList){
            if(cityLawAgency.getName().equalsIgnoreCase(city)){
                return cityLawAgency;
            }
        }    
        return null;
    }
}
