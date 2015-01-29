/*
 * Class : Distributor.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 9, 2014, 6:33:44 PM
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
package drugsupplychain.neu.css.model.distributor;

import drugsupplychain.neu.css.model.order.OrderCatalog;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.product.ProductCatalog;


/**
 *
 * @author Laksh
 */
public abstract class Distributor extends Organization{
    private OrderCatalog orderCatalog;
    private ProductCatalog productCatalog;
    
    public Distributor(String name) {
        super(name);
        orderCatalog = new OrderCatalog();
        productCatalog = new ProductCatalog();
    }
    
    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }
    

}
