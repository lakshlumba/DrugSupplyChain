/*
 * Class : StatePharmaceuticalCompanyRole.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 12:21:18 AM
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
package drugsupplychain.neu.css.model.role.pharma;

import drugsupplychain.neu.css.gui.state.pharmaco.StatePharmaCompanyWorkAreaJPanel;
import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.FDI.FDISystem;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.lawAgencies.LawAgency;
import drugsupplychain.neu.css.model.user.UserAccount;
import javax.swing.JPanel;
/**
 *
 * @author Laksh
 */
public class StatePharmaceuticalCompanyRole extends PharmaceuticalCompanyRole{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Organization higherOrganization, Organization nextHigherOrganization,Organization highestOrganization,FDISystem fDISystem) {
        ImplLogger.enterMethod();
        ImplLogger.exitMethod();
        return new StatePharmaCompanyWorkAreaJPanel(userProcessContainer,account,organization,(LawAgency)higherOrganization,fDISystem);    
    }
    
}
