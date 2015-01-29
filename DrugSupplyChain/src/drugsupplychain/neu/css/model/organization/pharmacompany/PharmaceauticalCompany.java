/*
 * Class : PharmaceauticalCompany.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:28:05 PM
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

import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.product.ProductCatalog;

/**
 *
 * @author Laksh
 */
public abstract class  PharmaceauticalCompany extends Organization{
    private final ProductCatalog productCatalog;

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public PharmaceauticalCompany(String name) {
        super(name);
        this.productCatalog = new ProductCatalog();
    }  
    
}
