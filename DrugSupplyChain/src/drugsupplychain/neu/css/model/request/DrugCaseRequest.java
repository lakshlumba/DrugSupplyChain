/*
 * Class : DrugCaseRequest.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 20, 2014, 4:36:24 PM
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

import drugsupplychain.neu.css.model.product.Product;

/**
 *
 * @author Laksh
 */
public class DrugCaseRequest extends WorkRequest{
    private Product product;
    private String  priority;
    private String  problem;
    private String  description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }    

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    @Override
    public String toString(){
        return this.getWorkRequestId();
    }
}
