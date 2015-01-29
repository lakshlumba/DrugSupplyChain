/*
 * Class : NationalPharmaceauticalCompany.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:31:14 PM
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

import drugsupplychain.neu.css.model.distributor.StateDistributor;
import drugsupplychain.neu.css.model.distributor.StateDistributorDirectory;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.role.pharma.NationalPharmaceuticalCompanyRole;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Laksh
 */
public class NationalPharmaceauticalCompany extends PharmaceauticalCompany{
    private final StateDistributorDirectory stateDistributorDirectory;
    private final HashMap<String,StateDistributor> distributorList; 

    public StateDistributorDirectory getStateDistributorDirectory() {
        return stateDistributorDirectory;
    }

    public HashMap<String, StateDistributor> getDistributorList() {
        return distributorList;
    }


    public NationalPharmaceauticalCompany() {
        super(Type.NATIONAL_PHARMA_CO.getValue());
        this.stateDistributorDirectory = new StateDistributorDirectory();
        this.distributorList = new HashMap<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new NationalPharmaceuticalCompanyRole());
        return roles;
    }
    
}
