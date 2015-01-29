/*
 * Class : HospitalOrganizationDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 19, 2014, 9:34:28 PM
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
package drugsupplychain.neu.css.model.organization.other;

import drugsupplychain.neu.css.model.organization.Directory;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class HospitalOrganizationDirectory extends Directory{
     private final ArrayList<HospitalOrganization> hospitalOrganizationList;
    public HospitalOrganizationDirectory(){
       hospitalOrganizationList = new ArrayList<>();
    }

    public ArrayList<HospitalOrganization> getHospitalOrganizationList() {
        return hospitalOrganizationList;
    }
    
    public HospitalOrganization addHospitalOrganization(){
        HospitalOrganization hospitalOrganization =  new HospitalOrganization();
        hospitalOrganizationList.add(hospitalOrganization);
        return hospitalOrganization;        
    }
    public void removeHospitalOrganization(HospitalOrganization hospitalOrganization){
        hospitalOrganizationList.remove(hospitalOrganization);
    }
    public void addHospitalOrganization(HospitalOrganization hospitalOrganization){
        hospitalOrganizationList.add(hospitalOrganization);
    }
    /**
     * search the 
     * @param lincenseNumber
     * @return 
     */
    public HospitalOrganization searchHospitalOrganization(String lincenseNumber) {
        for (HospitalOrganization hospitalOrganization : hospitalOrganizationList){
            if (hospitalOrganization.getLincense().getLicenseNumber().equals(lincenseNumber)){
                return hospitalOrganization;
            }
        }
        return null;
    }
}
