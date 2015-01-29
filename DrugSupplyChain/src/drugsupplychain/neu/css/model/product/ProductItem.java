/*
 * Class : ProductItem.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 29, 2014, 12:17:18 AM
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

/**
 *
 * @author Laksh
 */
public class ProductItem {
    private Product product;
    private int quantity;

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
