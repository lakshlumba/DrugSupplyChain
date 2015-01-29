/*
 * Class : PharmacyOrganizationDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 19, 2014, 9:35:00 PM
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
public class PharmacyOrganizationDirectory extends Directory{
    private final ArrayList<PharmacyOrganization> pharmacyOrganizationList;
    public PharmacyOrganizationDirectory(){
       pharmacyOrganizationList = new ArrayList<>();
    }

    public ArrayList<PharmacyOrganization> getPharmacyOrganizationList() {
        return pharmacyOrganizationList;
    }

    public PharmacyOrganization addPharmacyOrganization(){
        PharmacyOrganization pharmacyOrganization =  new PharmacyOrganization();
        pharmacyOrganizationList.add(pharmacyOrganization);
        return pharmacyOrganization;        
    }
    public void removePharmacyOrganization(PharmacyOrganization pharmacyOrganization){
        pharmacyOrganizationList.remove(pharmacyOrganization);
    } 
    public void addPharmacyOrganization(PharmacyOrganization pharmacyOrganization){
        pharmacyOrganizationList.add(pharmacyOrganization);
    }
    /**
     * search the 
     * @param lincenseNumber
     * @return 
     */
    public PharmacyOrganization searchPharmacyOrganization(String lincenseNumber) {
        for (PharmacyOrganization pharmacyOrganization : pharmacyOrganizationList){
            if (pharmacyOrganization.getLincense().getLicenseNumber().equals(lincenseNumber)){
                return pharmacyOrganization;
            }
        }
        return null;
    }
}
