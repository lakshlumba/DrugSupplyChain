/*
 * Class : FDISystem.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 8:00:13 PM
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
package drugsupplychain.neu.css.model.FDI;

import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgencyDirectory;
import drugsupplychain.neu.css.model.organization.pharmacompany.InterNationalPharmaceauticalCompanyDirectory;
import drugsupplychain.neu.css.model.role.FDISystemRole;
import drugsupplychain.neu.css.model.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class FDISystem extends Organization{
    private static FDISystem fDISystem;
    private final RegionalLawAgencyDirectory regionalLawAgencyDirectory;   
    private final InterNationalPharmaceauticalCompanyDirectory interNationalPharmaceauticalCompanyDirectory;
    /**
     * getInstance to initialize the System Object 
     * @return 
     */
    public static FDISystem getInstance(){
        if (fDISystem == null){
            return new FDISystem();
        }
        return fDISystem;
    }
    /**
     * constructor
     */
    private FDISystem(){
        super(null);
        regionalLawAgencyDirectory = new RegionalLawAgencyDirectory();
        interNationalPharmaceauticalCompanyDirectory = new InterNationalPharmaceauticalCompanyDirectory();
    }
    /**
     * get RegionalLawAgencyDirectory
     * @return 
     */
    public RegionalLawAgencyDirectory getRegionalLawAgencyDirectory() {
        return regionalLawAgencyDirectory;
    }
    /**
     * get the InterNationalPharmaceauticalCompanyDirectory
     * @return 
     */
    public InterNationalPharmaceauticalCompanyDirectory getInterNationalPharmaceauticalCompanyDirectory() {
        return interNationalPharmaceauticalCompanyDirectory;
    }    
    /**
     * support the role
     * @return 
     */
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new FDISystemRole());
        return roles;
    }
}
