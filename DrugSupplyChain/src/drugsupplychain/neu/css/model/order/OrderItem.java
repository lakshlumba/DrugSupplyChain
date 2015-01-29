/*
 * Class : OrderItem.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 3:42:23 PM
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
package drugsupplychain.neu.css.model.order;

import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.product.Product;

/**
 *
 * @author Laksh
 */
public class OrderItem {
    private Product product;
    private int quantity;
    private int shopId;
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
  

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * implemented the to string method to return the product name
     * @return 
     */
    @Override
    public String toString() {
        return product.getBarcode();
    }
}
