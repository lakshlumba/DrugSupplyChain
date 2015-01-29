/*
 * Class : LawAgencyCaseRequest.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 11, 2014, 12:23:07 AM
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
package drugsupplychain.neu.css.model.request;

import drugsupplychain.neu.css.util.ImplCommonUtil;

/**
 *
 * @author Laksh
 */
public class LawAgencyCaseRequest extends WorkRequest {
    private String caseId;
    private StringBuffer caseDescription;
    private String caseStatus;
    private int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LawAgencyCaseRequest(String authority){
        caseId = ImplCommonUtil.generateCaseNumber(authority);
    }
            
    public String getCaseId() {
        return caseId;
    }
    
    public StringBuffer getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(StringBuffer caseDescription) {
        this.caseDescription = caseDescription;
    }
    
    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
    
     public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }
    
    @Override
    public String toString(){
        return caseId; 
    }
}
