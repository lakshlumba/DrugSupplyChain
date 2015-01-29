/*
 * Class : NationalLawAgency.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:42:23 PM
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

import drugsupplychain.neu.css.model.distributor.NationalDistributorDirectory;
import drugsupplychain.neu.css.model.organization.pharmacompany.NationalPharmaceauticalCompanyDirectory;
import drugsupplychain.neu.css.model.role.Role;
import drugsupplychain.neu.css.model.role.lawagency.NationalLawAgencyRole;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class NationalLawAgency extends LawAgency{
    private final StateLawAgencyDirectory stateLawAgencyDirectory;
    private final NationalPharmaceauticalCompanyDirectory nationalPharmaceauticalCompanyDirectory;
    private final NationalDistributorDirectory nationalDistributorDirectory;
    
    public NationalLawAgency() {
        super(Type.NATIONAL_FDI.getValue());
        this.stateLawAgencyDirectory = new StateLawAgencyDirectory();
        this.nationalDistributorDirectory = new NationalDistributorDirectory();
        this.nationalPharmaceauticalCompanyDirectory = new NationalPharmaceauticalCompanyDirectory();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
       roles.add(new NationalLawAgencyRole());
       return roles;
    }

    public StateLawAgencyDirectory getStateLawAgencyDirectory() {
        return stateLawAgencyDirectory;
    }

    public NationalPharmaceauticalCompanyDirectory getNationalPharmaceauticalCompanyDirectory() {
        return nationalPharmaceauticalCompanyDirectory;
    }

    public NationalDistributorDirectory getNationalDistributorDirectory() {
        return nationalDistributorDirectory;
    }   
}
