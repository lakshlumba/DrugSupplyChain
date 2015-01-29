/*
 * Class : NationalPharmaceauticalCompanyDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 11:11:51 PM
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

import drugsupplychain.neu.css.model.organization.Directory;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class NationalPharmaceauticalCompanyDirectory extends Directory{
    private final ArrayList<NationalPharmaceauticalCompany> nationalPharmaceauticalCompanyList;

    public ArrayList<NationalPharmaceauticalCompany> getNationalPharmaceauticalCompanyList() {
        return nationalPharmaceauticalCompanyList;
    }
    /**
     * constructor NationalPharmaceauticalCompanyDirectory
     */
    public NationalPharmaceauticalCompanyDirectory() {
        nationalPharmaceauticalCompanyList = new ArrayList<>();
    }
    
    /**
     * add the nationalPharmaceauticalCompany
     * @return 
     */
    public NationalPharmaceauticalCompany addNationalPharmaceauticalCompany(){
        NationalPharmaceauticalCompany nationalPharmaceauticalCompany =  new NationalPharmaceauticalCompany();
        nationalPharmaceauticalCompanyList.add(nationalPharmaceauticalCompany);
        return nationalPharmaceauticalCompany;
    }
    /**
     * remove the NationalPharmaceauticalCompany 
     * @param nationalPharmaceauticalCompany
     */
    public void removeNationalPharmaceauticalCompany(NationalPharmaceauticalCompany nationalPharmaceauticalCompany){
        nationalPharmaceauticalCompanyList.remove(nationalPharmaceauticalCompany);
    }
    
    /**
     * Search the Agency according to the name
     * @param name
     * @return 
     */
    public NationalPharmaceauticalCompany searchNationalPharmaceauticalCompany(String name){
        for(NationalPharmaceauticalCompany nationalPharmaceauticalCompany : nationalPharmaceauticalCompanyList){
            if(nationalPharmaceauticalCompany.getName().equalsIgnoreCase(name)){
                return nationalPharmaceauticalCompany;
            }
        }    
        return null;
    }
}
