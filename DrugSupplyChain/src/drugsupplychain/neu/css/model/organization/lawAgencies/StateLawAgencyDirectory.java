/*
 * Class : StateLawAgencyDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 11:13:10 PM
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
public class StateLawAgencyDirectory {
     private final ArrayList<StateLawAgency> stateLawAgencyList;

    public ArrayList<StateLawAgency> getStateLawAgencyList() {
        return stateLawAgencyList;
    }
    /**
     * constructor State Law Agency directory
     */
    public StateLawAgencyDirectory() {
        stateLawAgencyList = new ArrayList<>();
    }
    
    /**
     * add the StateLawAgency
     * @return 
     */
    public StateLawAgency addStateLawAgency(){
        StateLawAgency stateLawAgency =  new StateLawAgency();
        stateLawAgencyList.add(stateLawAgency);
        return stateLawAgency;
    }
    /**
     * remove the stateLawAgency
     * @param stateLawAgency 
     */
    public void removeStateLawAgency(StateLawAgency stateLawAgency){
        stateLawAgencyList.remove(stateLawAgency);
    }
    
    /**
     * Search the Agency according to the region
     * @param region
     * @return 
     */
    public StateLawAgency searchStateLawAgency(String region){
        for(StateLawAgency stateLawAgency : stateLawAgencyList){
            if(stateLawAgency.getName().equalsIgnoreCase(region)){
                return stateLawAgency;
            }
        }    
        return null;
    }
}
