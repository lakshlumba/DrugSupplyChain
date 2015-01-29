/*
 * Class : PatientOrganization.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 1:20:13 AM
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
import drugsupplychain.neu.css.model.role.other.PatientRole;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class PatientOrganization extends Distributor{

    public PatientOrganization() {
        super(Type.PATIENT.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
       roles.add(new PatientRole());
       return roles;
    }
    
}
