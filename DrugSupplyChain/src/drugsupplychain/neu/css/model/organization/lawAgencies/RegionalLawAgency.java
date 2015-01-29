/*
 * Class : RegionalLawAgency.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:43:57 PM
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
package drugsupplychain.neu.css.model.organization.lawAgencies;

import drugsupplychain.neu.css.model.distributor.RegionalDistributorDirectory;
import drugsupplychain.neu.css.model.organization.pharmacompany.RegionalPharmaceauticalCompanyDirectory;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.role.lawagency.RegionalLawAgencyRole;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class RegionalLawAgency extends LawAgency {
    private final RegionalPharmaceauticalCompanyDirectory regionalPharmaceauticalCompanyDirectory;
    private final RegionalDistributorDirectory regionalDistributorDirectory;
    private final NationalLawAgencyDirectory nationalLawAgencyDirectory;

    public RegionalDistributorDirectory getRegionalDistributorDirectory() {
        return regionalDistributorDirectory;
    }
    
  
    /**
     * constructor
     */
    public RegionalLawAgency() {
        super(Type.REGIONAL_FDI.getValue());
        nationalLawAgencyDirectory = new NationalLawAgencyDirectory();
        regionalPharmaceauticalCompanyDirectory = new RegionalPharmaceauticalCompanyDirectory();
        regionalDistributorDirectory = new RegionalDistributorDirectory();     
    }
    /**
     * supported role
     * @return 
     */
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
       roles.add(new RegionalLawAgencyRole());
       return roles;
    }
    /**
     * get the Regional company
     * @return 
     */
    public RegionalPharmaceauticalCompanyDirectory getRegionalPharmaceauticalCompanyDirectory() {
        return regionalPharmaceauticalCompanyDirectory;
    }
    
    /**
     * get the national law agency directory
     * @return 
     */
    public NationalLawAgencyDirectory getNationalLawAgencyDirectory() {
        return nationalLawAgencyDirectory;
    }
    
}
