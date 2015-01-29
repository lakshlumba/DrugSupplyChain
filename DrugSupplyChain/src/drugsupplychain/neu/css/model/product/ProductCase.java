/*
 * Class : ProductCases.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 13, 2014, 9:37:05 PM
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
package drugsupplychain.neu.css.model.product;

import drugsupplychain.neu.css.model.person.Person;
import drugsupplychain.neu.css.model.request.DrugCaseRequest;


/**
 *
 * @author Laksh
 */
public class ProductCase {
    private DrugCaseRequest drugCaseRequest;
    private String caseId;
    private String caseDescription;
    private Person person;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public DrugCaseRequest getDrugCaseRequest() {
        return drugCaseRequest;
    }

    public void setDrugCaseRequest(DrugCaseRequest drugCaseRequest) {
        this.drugCaseRequest = drugCaseRequest;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return caseId;
    }
}
