/*
 * Class : NationalLawAgencyDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 11:13:41 PM
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
public class NationalLawAgencyDirectory {
    private final ArrayList<NationalLawAgency> nationalLawAgencyList;
    /**
     * constructor National Law Agency directory
     */
    public NationalLawAgencyDirectory() {
        nationalLawAgencyList = new ArrayList<>();
    }
    /**
     * get the National Law Agency
     * @return 
     */
    public ArrayList<NationalLawAgency> getNationalLawAgencyList() {
        return nationalLawAgencyList;
    }
    /**
     * add the national law agency
     * @return 
     */
    public NationalLawAgency addNationalLawAgency(){
        NationalLawAgency nationalLawAgency =  new NationalLawAgency();
        nationalLawAgencyList.add(nationalLawAgency);
        return nationalLawAgency;
    }
    /**
     * remove the national law agency
     * @param nationalLawAgency 
     */
    public void removeNationalLawAgency(NationalLawAgency nationalLawAgency){
        nationalLawAgencyList.remove(nationalLawAgency);
    }
    
    /**
     * Search the Agency according to the nation
     * @param nation
     * @return 
     */
    public NationalLawAgency searchNationalLawAgency(String nation){
        for(NationalLawAgency nationalLawAgency : nationalLawAgencyList){
            if(nationalLawAgency.getName().equalsIgnoreCase(nation)){
                return nationalLawAgency;
            }
        }    
        return null;
    } 
    
}
