                                                 /*
 * Class : InterNationalPharmaceauticalCompanyDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 11, 2014, 2:46:51 AM
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

import drugsupplychain.neu.css.model.distributor.RegionalDistributor;
import drugsupplychain.neu.css.model.organization.Directory;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class InterNationalPharmaceauticalCompanyDirectory extends Directory{
    private final ArrayList<InterNationalPharmaceauticalCompany> interNationalPharmaceauticalCompanyList;
    
    /**
     * constructor
     */
    public InterNationalPharmaceauticalCompanyDirectory() {
        this.interNationalPharmaceauticalCompanyList = new ArrayList<>();
    }
    /**
     * getInterNationalPharmaceauticalCompanyList
     * @return 
     */
    public ArrayList<InterNationalPharmaceauticalCompany> getInterNationalPharmaceauticalCompanyList() {
        return interNationalPharmaceauticalCompanyList;
    }
    /**
     * create the new InterNationalPharmaceauticalCompany 
     * @return 
     */
    public InterNationalPharmaceauticalCompany addInterNationalPharmaceauticalCompany(){
        InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany = new InterNationalPharmaceauticalCompany();
        interNationalPharmaceauticalCompanyList.add(interNationalPharmaceauticalCompany);
        return interNationalPharmaceauticalCompany;
    }
    /**
     * remove the pharmaCompany
     * @param interNationalPharmaceauticalCompany
     */
    public void removeInterNationalPharmaceauticalCompany(InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany){
        interNationalPharmaceauticalCompanyList.remove(interNationalPharmaceauticalCompany);
    }
    /**
     *  search the company using the license number
     * @param linsenceNumber 
     * @return  
     */
    public InterNationalPharmaceauticalCompany searchInterNationalPharmaceauticalCompany(String linsenceNumber) {
        for (InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany : interNationalPharmaceauticalCompanyList) {
            if (interNationalPharmaceauticalCompany.getLincense().getLicenseNumber().equalsIgnoreCase(linsenceNumber)) {
                return interNationalPharmaceauticalCompany;
            }
        }
        return null;
    }
    /**
     * search the company using the name
     * @param name
     * @return 
     */
    public InterNationalPharmaceauticalCompany searchInterNationalPharmaceauticalCompanyByName(String name) {
        for (InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany : interNationalPharmaceauticalCompanyList) {
            if (interNationalPharmaceauticalCompany.getName().equalsIgnoreCase(name)) {
                return interNationalPharmaceauticalCompany;
            }
        }
        return null;
    }
    /**
     * search the company using the distributors ID
     * @param distribuorId
     * @return 
     */
    public InterNationalPharmaceauticalCompany searchInterNationalPharmaceauticalCompanyById(int distribuorId) {
        for (InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany : interNationalPharmaceauticalCompanyList) {
            for (RegionalDistributor regionalDistributor : interNationalPharmaceauticalCompany.getRegionalDistributorDirectory().getRegionalDistributorList()){
                if (regionalDistributor.getOrganizationID() == distribuorId) {
                    return interNationalPharmaceauticalCompany;
                }
            }            
        }
        return null;
    }
    
}
