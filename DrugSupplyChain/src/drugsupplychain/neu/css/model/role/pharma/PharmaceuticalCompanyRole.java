/*
 * Class : PharmaceuticalCompanyRole.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 12:18:49 AM
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

import drugsupplychain.neu.css.model.FDI.FDISystem;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.user.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Laksh
 */
public class PharmaceuticalCompanyRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Organization higherOrganization, Organization nextHigherOrganization, Organization highestOrganization, FDISystem fDISystem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
