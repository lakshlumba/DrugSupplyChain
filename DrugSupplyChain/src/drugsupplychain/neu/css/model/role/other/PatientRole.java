/*
 * Class : PatientRole.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 12:29:21 AM
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
package drugsupplychain.neu.css.model.role.other;

import drugsupplychain.neu.css.gui.city.lawagency.patients.PatientWorkAreaJPanel;
import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.FDI.FDISystem;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.StateLawAgency;
import drugsupplychain.neu.css.model.organization.other.PatientOrganization;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.user.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Laksh
 */
public class PatientRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization,Organization higherOrganization,Organization nextHigherOrganization,Organization highestOrganization,FDISystem fDISystem) {
        ImplLogger.enterMethod();
        ImplLogger.exitMethod();
        return new PatientWorkAreaJPanel(userProcessContainer,userAccount,(PatientOrganization)organization,(CityLawAgency)higherOrganization,(StateLawAgency)nextHigherOrganization);
    }
    
}
