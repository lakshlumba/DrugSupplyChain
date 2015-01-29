/*
 * Class : ProductCaseCatalog.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 13, 2014, 9:37:20 PM
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

import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class ProductCaseCatalog {
    private final ArrayList<ProductCase> productCaseList;
    /**
     * getter and setter
     * @return 
     */
    public ArrayList<ProductCase> getProductCaseList() {
        return productCaseList;
    }
    /**
     * constructor
     */
    public ProductCaseCatalog(){
        productCaseList = new ArrayList<>();
    }
    /**
     * 
     * @return 
     */
    public ProductCase addProductCase(){
        ProductCase productCase = new ProductCase();
        productCaseList.add(productCase);
        return productCase;
    }
    /**
     * 
     * @param productCase
     */
    public void removeProductCase(ProductCase productCase){
        productCaseList.remove(productCase);
    }
    
}
