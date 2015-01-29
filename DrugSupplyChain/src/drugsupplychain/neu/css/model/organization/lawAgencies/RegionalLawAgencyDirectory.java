/*
 * Class : RegionalLawAgencyDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 11:13:26 PM
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
public class RegionalLawAgencyDirectory {
   private final ArrayList<RegionalLawAgency> regionalLawAgencyList;

    public ArrayList<RegionalLawAgency> getRegionalLawAgencyList() {
        return regionalLawAgencyList;
    }

    public RegionalLawAgencyDirectory() {
        this.regionalLawAgencyList = new ArrayList<>();
    }
   
    public RegionalLawAgency addRegionalLawAgency(){
        RegionalLawAgency regionalLawAgency =  new RegionalLawAgency();
        regionalLawAgencyList.add(regionalLawAgency);
        return regionalLawAgency;
    }
    
    public void removeRegionalLawAgency(RegionalLawAgency regionalLawAgency){
        regionalLawAgencyList.remove(regionalLawAgency);
    }
    /**
     * Search the Agency according to the region
     * @param region
     * @return 
     */
    public RegionalLawAgency searchRegionalLawAgency(String region){
        for(RegionalLawAgency regionalLawAgency : regionalLawAgencyList){
            if(regionalLawAgency.getName().equalsIgnoreCase(region)){
                return regionalLawAgency;
            }
        }    
        return null;
    } 
    
}
