/*
 * Class : RegionalLawAgencyRole.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 12:15:23 AM
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
package drugsupplychain.neu.css.model.role.lawagency;

import drugsupplychain.neu.css.gui.regional.lawagency.RegionalLawAgencyWorkAreaJPanel;
import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.FDI.FDISystem;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.user.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Laksh
 */
public class RegionalLawAgencyRole extends LawAgencyRole{
    /**
     * 
     * @param userProcessContainer
     * @param account
     * @param organization
     * @param higherOrganization
     * @param nextHigherOrganization
     * @param fDISystem
     * @return 
     */
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,Organization higherOrganization,Organization nextHigherOrganization,Organization highestOrganization,FDISystem fDISystem) {
        ImplLogger.enterMethod();
        ImplLogger.exitMethod();
        return new RegionalLawAgencyWorkAreaJPanel(userProcessContainer,account,organization,fDISystem);
    }
}
