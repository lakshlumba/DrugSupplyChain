/*
 * Class : StateDistributorDirectory.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 5:55:31 PM
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

import drugsupplychain.neu.css.model.organization.Directory;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class StatePharmaceauticalCompanyDirectory extends Directory{
    private final ArrayList<StatePharmaceauticalCompany> statePharmaceauticalCompanyList;

    public ArrayList<StatePharmaceauticalCompany> getStatePharmaceauticalCompanyList() {
        return statePharmaceauticalCompanyList;
    }
    /**
     * constructor StatePharmaceauticalCompany
     */
    public StatePharmaceauticalCompanyDirectory() {
        statePharmaceauticalCompanyList = new ArrayList<>();
    }
    
    /**
     * add the StatePharmaceauticalCompany
     * @return 
     */
    public StatePharmaceauticalCompany addStatePharmaceauticalCompany(){
        StatePharmaceauticalCompany statePharmaceauticalCompany =  new StatePharmaceauticalCompany();
        statePharmaceauticalCompanyList.add(statePharmaceauticalCompany);
        return statePharmaceauticalCompany;
    }
    /**
     * remove the StatePharmaceauticalCompany 
     * @param statePharmaceauticalCompany
     */
    public void removeStatePharmaceauticalCompany(StatePharmaceauticalCompany statePharmaceauticalCompany){
        statePharmaceauticalCompanyList.remove(statePharmaceauticalCompany);
    }
    
    /**
     * Search the Agency according to the name
     * @param name
     * @return 
     */
    public StatePharmaceauticalCompany searchStatePharmaceauticalCompany(String name){
        for(StatePharmaceauticalCompany statePharmaceauticalCompany : statePharmaceauticalCompanyList){
            if(statePharmaceauticalCompany.getName().equalsIgnoreCase(name)){
                return statePharmaceauticalCompany;
            }
        }    
        return null;
    }
    
}
