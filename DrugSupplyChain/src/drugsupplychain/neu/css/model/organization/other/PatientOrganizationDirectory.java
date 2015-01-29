/*
 * Class : PatientOrganizationDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 19, 2014, 9:34:45 PM
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
public class PatientOrganizationDirectory extends Directory{
    private final ArrayList<PatientOrganization> patientOrganizationList;
    public PatientOrganizationDirectory(){
       patientOrganizationList = new ArrayList<>();
    }

    public ArrayList<PatientOrganization> getPatientOrganizationList() {
        return patientOrganizationList;
    }

    public PatientOrganization addPatientOrganization(){
        PatientOrganization patientOrganization =  new PatientOrganization();
        patientOrganizationList.add(patientOrganization);
        return patientOrganization;        
    }
    public void removePatientOrganization(PatientOrganization patientOrganization){
        patientOrganizationList.remove(patientOrganization);
    } 
    public void addPatientOrganization(PatientOrganization patientOrganization){
        patientOrganizationList.add(patientOrganization);
    } 
    /**
     * search the 
     * @param lincenseNumber
     * @return 
     */
    public PatientOrganization searchPatientOrganization(String lincenseNumber) {
        for (PatientOrganization patientOrganization : patientOrganizationList){
            if (patientOrganization.getLincense().getLicenseNumber().equals(lincenseNumber)){
                return patientOrganization;
            }
        }
        return null;
    }
    public PatientOrganization searchPatientOrganization(int patientId) {
        for (PatientOrganization patientOrganization : patientOrganizationList){
            if (patientOrganization.getOrganizationID() == patientId){
                return patientOrganization;
            }
        }
        return null;
    }
}
