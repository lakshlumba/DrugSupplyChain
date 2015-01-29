/*
 * Class : OrganizationDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 1:23:23 AM
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
package drugsupplychain.neu.css.model.organization;

import drugsupplychain.neu.css.model.organization.Organization.Type;
import drugsupplychain.neu.css.model.organization.other.ClinicOrganization;
import drugsupplychain.neu.css.model.organization.other.DispenceryOrganization;
import drugsupplychain.neu.css.model.organization.other.DoctorOrganization;
import drugsupplychain.neu.css.model.organization.other.HospitalOrganization;
import drugsupplychain.neu.css.model.organization.other.PatientOrganization;
import drugsupplychain.neu.css.model.organization.other.PharmacyOrganization;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class OrganizationDirectory extends Directory{
    private final ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    /**
     * 
     * @param type
     * @return 
     */
    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.CLINIC.getValue())){
                organization =  new ClinicOrganization();
        } else if (type.getValue().equals(Type.DISPENCERY.getValue())){
            organization = new DispenceryOrganization();
        } else if (type.getValue().equals(Type.DOCTOR.getValue())){
            organization = new DoctorOrganization();
        } else if (type.getValue().equals(Type.HOSPITAL.getValue())){
            organization = new HospitalOrganization();
        } else if (type.getValue().equals(Type.PATIENT.getValue())){
            organization = new PatientOrganization();
        } else if (type.getValue().equals(Type.PHARMACY.getValue())){
            organization = new PharmacyOrganization();
        }
        organizationList.add(organization);
        return organization;    
    }
     /**
     * 
     * @param organization
     */
    public void addOrganization(Organization organization) {
        organizationList.add(organization);
    }
    /**
     * 
     * @param organization
     */
    public void removeOrganization(Organization organization) {
        organizationList.remove(organization);
    }
     /**
     * 
     * @param organizationId
     * @return 
     */
    public Organization searchOrganization(int organizationId) {
        for(Organization organization :organizationList){
            if (organization.getOrganizationID() == organizationId){
                return organization;
            }
        }
        return null;
    }
}