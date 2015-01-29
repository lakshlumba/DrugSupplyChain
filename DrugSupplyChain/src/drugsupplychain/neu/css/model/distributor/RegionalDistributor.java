/*
 * Class : RegionalDistributor.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:34:47 PM
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
import drugsupplychain.neu.css.model.role.distributor.RegionalDistributorRole;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Laksh
 */
public class RegionalDistributor extends Distributor{
    private final NationalDistributorDirectory nationalDistributorDirectory;
    private final HashMap<String,NationalDistributor> distributorList; 

    public NationalDistributorDirectory getNationalDistributorDirectory() {
        return nationalDistributorDirectory;
    }

    public HashMap<String, NationalDistributor> getDistributorList() {
        return distributorList;
    }
    public RegionalDistributor() {
        super(Type.REGIONAL_DISTRIBUTOR.getValue());
        this.nationalDistributorDirectory = new NationalDistributorDirectory();
        this.distributorList = new HashMap<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
       roles.add(new RegionalDistributorRole());
       return roles;
    }
    
}
