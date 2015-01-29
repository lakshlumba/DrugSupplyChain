/*
 * Class : CityDistributor.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:35:51 PM
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

import drugsupplychain.neu.css.model.organization.OrganizationDirectory;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.role.distributor.CityDistributorRole;
import java.util.ArrayList;


/**
 *
 * @author Laksh
 */
public class CityDistributor extends Distributor {
    private final OrganizationDirectory organizationDirectory;
    public CityDistributor() {
        super(Type.CITY_DISTRIBUTOR.getValue());
        this.organizationDirectory = new OrganizationDirectory();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
       roles.add(new CityDistributorRole());
       return roles;
    }
    
    
}
