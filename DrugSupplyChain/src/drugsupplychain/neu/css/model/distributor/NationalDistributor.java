/*
 * Class : NationalDistributor.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:35:25 PM
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
import drugsupplychain.neu.css.model.role.distributor.NationalDistributorRole;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Laksh
 */
public class NationalDistributor extends Distributor{
    private final StateDistributorDirectory stateDistributorDirectory;
    private final HashMap<String,StateDistributor> distributorList; 

    public StateDistributorDirectory getStateDistributorDirectory() {
        return stateDistributorDirectory;
    }

    public HashMap<String, StateDistributor> getDistributorList() {
        return distributorList;
    }
    public NationalDistributor() {
        super(Type.NATIONAL_DISTRIBUTOR.getValue());
        this.stateDistributorDirectory = new StateDistributorDirectory();
        this.distributorList = new HashMap<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
       roles.add(new NationalDistributorRole());
       return roles;
    }
    
}
