/*
 * Class : StateLawAgency.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:42:05 PM
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

import drugsupplychain.neu.css.model.distributor.StateDistributorDirectory;
import drugsupplychain.neu.css.model.organization.pharmacompany.StatePharmaceauticalCompanyDirectory;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.role.lawagency.StateLawAgencyRole;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class StateLawAgency extends LawAgency{
    private final CityLawAgencyDirectory  cityLawAgencyDirectory;
    private final StatePharmaceauticalCompanyDirectory statePharmaceauticalCompanyDirectory;
    private final StateDistributorDirectory stateDistributorDirectory;

    public StateDistributorDirectory getStateDistributorDirectory() {
        return stateDistributorDirectory;
    }   

    public CityLawAgencyDirectory getCityLawAgencyDirectory() {
        return cityLawAgencyDirectory;
    }

    public StatePharmaceauticalCompanyDirectory getStatePharmaceauticalCompanyDirectory() {
        return statePharmaceauticalCompanyDirectory;
    }

    public StateLawAgency() {
        super(Type.STATE_FDI.getValue());
        this.cityLawAgencyDirectory = new CityLawAgencyDirectory();
        this.stateDistributorDirectory = new StateDistributorDirectory();
        this.statePharmaceauticalCompanyDirectory = new StatePharmaceauticalCompanyDirectory();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
       roles.add(new StateLawAgencyRole());
       return roles;
    }
    
}
