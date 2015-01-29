/*
 * Class : InterNationalPharmaceauticalCompany.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:30:41 PM
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
package drugsupplychain.neu.css.model.organization.pharmacompany;

import drugsupplychain.neu.css.model.distributor.RegionalDistributor;
import drugsupplychain.neu.css.model.distributor.RegionalDistributorDirectory;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.role.pharma.InterPharmaceuticalCompanyRole;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Laksh
 */
public class InterNationalPharmaceauticalCompany extends PharmaceauticalCompany{
    private final RegionalDistributorDirectory regionalDistributorDirectory;
    private final HashMap<String,RegionalDistributor> distributorList; 

    public HashMap<String, RegionalDistributor> getDistributorList() {
        return distributorList;
    }
    
    
    public InterNationalPharmaceauticalCompany() {
        super(Type.INTER_PHARMA_CO.getValue());
        regionalDistributorDirectory = new RegionalDistributorDirectory();
        distributorList = new HashMap<>();
    }

    public RegionalDistributorDirectory getRegionalDistributorDirectory() {
        return regionalDistributorDirectory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InterPharmaceuticalCompanyRole());
        return roles;
    }    
}
