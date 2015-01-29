/*
 * Class : ClinicOrganizationDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 19, 2014, 9:33:36 PM
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
public class ClinicOrganizationDirectory extends Directory{
    private final ArrayList<ClinicOrganization> clinicOrganizationList;
    public ClinicOrganizationDirectory(){
       clinicOrganizationList = new ArrayList<>();
    }

    public ArrayList<ClinicOrganization> getClinicOrganizationList() {
        return clinicOrganizationList;
    }

    
    public ClinicOrganization addClinicOrganization(){
        ClinicOrganization clinicOrganization =  new ClinicOrganization();
        clinicOrganizationList.add(clinicOrganization);
        return clinicOrganization;        
    }
    public void removeClinicOrganization(ClinicOrganization clinicOrganization){
        clinicOrganizationList.remove(clinicOrganization);
    }
    public void addClinicOrganization(ClinicOrganization clinicOrganization){
        clinicOrganizationList.add(clinicOrganization);
    }
    /**
     * search the 
     * @param lincenseNumber
     * @return 
     */
    public ClinicOrganization searchClinicOrganization(String lincenseNumber) {
        for (ClinicOrganization clinicOrganization : clinicOrganizationList){
            if (clinicOrganization.getLincense().getLicenseNumber().equals(lincenseNumber)){
                return clinicOrganization;
            }
        }
        return null;
    }
    
}
