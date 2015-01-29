/*
 * Class : ClinicOrganization.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 1:21:22 AM
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

import drugsupplychain.neu.css.model.distributor.Distributor;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.role.other.ClinicRole;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class ClinicOrganization extends Distributor{
    private final PatientOrganizationDirectory patientOrganizationDirectory;
    public ClinicOrganization() {
        super(Type.CLINIC.getValue());
        patientOrganizationDirectory = new PatientOrganizationDirectory(); 
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ClinicRole());
        return roles;
    }

    public PatientOrganizationDirectory getPatientOrganizationDirectory() {
        return patientOrganizationDirectory;
    }
    
}
