/*
 * Class : NationalDistributorRole.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 12:10:44 AM
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
package drugsupplychain.neu.css.model.role.distributor;

import drugsupplychain.neu.css.gui.national.distributor.NationalDistributorWorkAreaJPanel;
import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.FDI.FDISystem;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.lawAgencies.NationalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgency;
import drugsupplychain.neu.css.model.user.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Laksh
 */
public class NationalDistributorRole extends DistributorRole{
    /**
     * 
     * @param userProcessContainer
     * @param userAccount
     * @param organization
     * @param higherOrganization
     * @param nextHigherOrganization
     * @param highestOrganization
     * @param fDISystem
     * @return 
     */
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,UserAccount userAccount,Organization organization,Organization higherOrganization,Organization nextHigherOrganization,Organization highestOrganization,FDISystem fDISystem) {
        ImplLogger.enterMethod();
        ImplLogger.exitMethod();
        NationalLawAgency nationalLawAgency = (NationalLawAgency)higherOrganization;
        RegionalLawAgency regionalLawAgency = (RegionalLawAgency)nextHigherOrganization;
        return new NationalDistributorWorkAreaJPanel(userProcessContainer,userAccount,organization,nationalLawAgency,regionalLawAgency,fDISystem);
    
    }
}
