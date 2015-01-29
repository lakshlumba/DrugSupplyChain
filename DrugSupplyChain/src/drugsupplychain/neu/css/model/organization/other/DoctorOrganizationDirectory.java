/*
 * Class : DoctorOrganizationDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 19, 2014, 9:34:14 PM
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
public class DoctorOrganizationDirectory extends Directory{
    private final ArrayList<DoctorOrganization> doctorOrganizationList;
    public DoctorOrganizationDirectory(){
       doctorOrganizationList = new ArrayList<>();
    }
    public ArrayList<DoctorOrganization> getDoctorOrganizationList() {
        return doctorOrganizationList;
    }
    
    public DoctorOrganization addDoctorOrganization(){
        DoctorOrganization doctorOrganization =  new DoctorOrganization();
        doctorOrganizationList.add(doctorOrganization);
        return doctorOrganization;        
    }
    public void removeDoctorOrganization(DoctorOrganization clinicOrganization){
        doctorOrganizationList.remove(clinicOrganization);
    } 
    public void addDoctorOrganization(DoctorOrganization clinicOrganization){
        doctorOrganizationList.add(clinicOrganization);
    }
    /**
     * search the 
     * @param lincenseNumber
     * @return 
     */
    public DoctorOrganization searchDoctorOrganization(String lincenseNumber) {
        for (DoctorOrganization doctorOrganization : doctorOrganizationList){
            if (doctorOrganization.getLincense().getLicenseNumber().equals(lincenseNumber)){
                return doctorOrganization;
            }
        }
        return null;
    }
}
