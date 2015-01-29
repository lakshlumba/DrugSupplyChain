/*
 * Class : StateDistributor.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:35:37 PM
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
package drugsupplychain.neu.css.model.distributor;

import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.role.distributor.StateDistributorRole;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Laksh
 */
public class StateDistributor extends Distributor{
    private final CityDistributorDirectory cityDistributorDirectory;
    private final HashMap<String,CityDistributor> distributorList; 

    public CityDistributorDirectory getCityDistributorDirectory() {
        return cityDistributorDirectory;
    }

    public HashMap<String, CityDistributor> getDistributorList() {
        return distributorList;
    }
    public StateDistributor() {
        super(Type.STATE_DISTRIBUTOR.getValue());
        cityDistributorDirectory = new CityDistributorDirectory();
        distributorList =  new HashMap<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
       roles.add(new StateDistributorRole());
       return roles;
    }
    
}
