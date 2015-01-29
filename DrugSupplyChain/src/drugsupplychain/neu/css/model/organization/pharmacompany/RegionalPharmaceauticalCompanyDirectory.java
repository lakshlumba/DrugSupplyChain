/*
 * Class : RegionalPharmaceauticalCompanyDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 11:12:24 PM
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
package drugsupplychain.neu.css.model.organization.pharmacompany;

import drugsupplychain.neu.css.model.distributor.NationalDistributor;
import drugsupplychain.neu.css.model.organization.Directory;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class RegionalPharmaceauticalCompanyDirectory extends Directory{
    private final ArrayList<RegionalPharmaceauticalCompany> regionalPharmaceauticalCompanyList;

    public ArrayList<RegionalPharmaceauticalCompany> getRegionalPharmaceauticalCompanyList() {
        return regionalPharmaceauticalCompanyList;
    }
    /**
     * constructor RegionalPharmaceauticalCompany
     */
    public RegionalPharmaceauticalCompanyDirectory() {
        regionalPharmaceauticalCompanyList = new ArrayList<>();
    }
    
    /**
     * add the RegionalPharmaceauticalCompany
     * @return 
     */
    public RegionalPharmaceauticalCompany addRegionalPharmaceauticalCompany(){
        RegionalPharmaceauticalCompany regionalPharmaceauticalCompany =  new RegionalPharmaceauticalCompany();
        regionalPharmaceauticalCompanyList.add(regionalPharmaceauticalCompany);
        return regionalPharmaceauticalCompany;
    }
    /**
     * remove the RegionalPharmaceauticalCompany 
     * @param regionalPharmaceauticalCompany
     */
    public void removeRegionalPharmaceauticalCompany(RegionalPharmaceauticalCompany regionalPharmaceauticalCompany){
        regionalPharmaceauticalCompanyList.remove(regionalPharmaceauticalCompany);
    }
    
    /**
     * Search the Agency according to the region
     * @param name
     * @return 
     */
    public RegionalPharmaceauticalCompany searchRegionalPharmaceauticalCompany(String name){
        for(RegionalPharmaceauticalCompany regionalPharmaceauticalCompany : regionalPharmaceauticalCompanyList){
            if(regionalPharmaceauticalCompany.getName().equalsIgnoreCase(name)){
                return regionalPharmaceauticalCompany;
            }
        }    
        return null;
    }
    /**
     * search the company using the distributors ID
     * @param distribuorId
     * @return 
     */
    public RegionalPharmaceauticalCompany searchInterNationalPharmaceauticalCompanyById(int distribuorId) {
        for (RegionalPharmaceauticalCompany regionalPharmaceauticalCompany : regionalPharmaceauticalCompanyList) {
            for (NationalDistributor nationalDistributor : regionalPharmaceauticalCompany.getNationalDistributorDirectory().getNationalDistributorList()){
                if (nationalDistributor.getOrganizationID() == distribuorId) {
                    return regionalPharmaceauticalCompany;
                }
            }            
        }
        return null;
    }
    
}
