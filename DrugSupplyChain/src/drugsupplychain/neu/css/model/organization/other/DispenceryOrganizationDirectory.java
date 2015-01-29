/*
 * Class : DispenceryOrganizationDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 19, 2014, 9:33:56 PM
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
package drugsupplychain.neu.css.model.organization.other;

import drugsupplychain.neu.css.model.organization.Directory;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class DispenceryOrganizationDirectory extends Directory{
    private final ArrayList<DispenceryOrganization> dispenceryOrganizationList;
    public DispenceryOrganizationDirectory(){
       dispenceryOrganizationList = new ArrayList<>();
    }

    public ArrayList<DispenceryOrganization> getDispenceryOrganizationList() {
        return dispenceryOrganizationList;
    }

    
    public DispenceryOrganization addDispenceryOrganization(){
        DispenceryOrganization dispenceryOrganization =  new DispenceryOrganization();
        dispenceryOrganizationList.add(dispenceryOrganization);
        return dispenceryOrganization;        
    }
    public void removeDispenceryOrganization(DispenceryOrganization clinicOrganization){
        dispenceryOrganizationList.remove(clinicOrganization);
    } 
    public void addDispenceryOrganization(DispenceryOrganization clinicOrganization){
        dispenceryOrganizationList.add(clinicOrganization);
    } 
    /**
     * search the 
     * @param lincenseNumber
     * @return 
     */
    public DispenceryOrganization searchDispenceryOrganization(String lincenseNumber) {
        for (DispenceryOrganization dispenceryOrganization : dispenceryOrganizationList){
            if (dispenceryOrganization.getLincense().getLicenseNumber().equals(lincenseNumber)){
                return dispenceryOrganization;
            }
        }
        return null;
    }
}
