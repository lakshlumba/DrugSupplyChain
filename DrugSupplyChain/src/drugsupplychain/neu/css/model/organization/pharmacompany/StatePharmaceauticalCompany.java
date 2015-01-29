/*
 * Class : StatePharmaceauticalCompany.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:31:24 PM
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

import drugsupplychain.neu.css.model.distributor.CityDistributor;
import drugsupplychain.neu.css.model.distributor.CityDistributorDirectory;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.role.pharma.StatePharmaceuticalCompanyRole;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Laksh
 */
public class StatePharmaceauticalCompany extends PharmaceauticalCompany{
    private final CityDistributorDirectory cityDistributorDirectory;
    private final HashMap<String,CityDistributor> distributorList; 

    public CityDistributorDirectory getCityDistributorDirectory() {
        return cityDistributorDirectory;
    }

    public HashMap<String, CityDistributor> getDistributorList() {
        return distributorList;
    }
    
    
    public StatePharmaceauticalCompany() {
        super(Type.STATE_PHARMA_CO.getValue());
        cityDistributorDirectory = new CityDistributorDirectory();
        distributorList =  new HashMap<>();                
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new StatePharmaceuticalCompanyRole());
        return roles;
    }
    
}
