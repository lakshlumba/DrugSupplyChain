/*
 * Class : ProductCatalog.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 3:35:48 PM
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

import drugsupplychain.neu.css.log.ImplLogger;
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class ProductCatalog {
    private ArrayList<Product> productList;
    private ArrayList<ProductItem> productItems;
    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    
    public ProductCatalog() {
        productList = new ArrayList<>();
        productItems = new ArrayList<>();
    }

    public ArrayList<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(ArrayList<ProductItem> productItems) {
        this.productItems = productItems;
    }

    /**
     *  add new product
     * @return 
     */
    public Product addProduct() {
        ImplLogger.enterMethod();
        Product product = new Product();
        productList.add(product);
        ImplLogger.exitMethod();
        return product;
    }
    
    /**
     *  add product
     * @param product
     * @param quantity 
     */
    public void addProductQuantity(Product product,int quantity) {
        ImplLogger.enterMethod();
        product.setAvailable(quantity);
        productList.add(product);
        ImplLogger.exitMethod();
    }
    /**
     * remove product
     * @param product 
     */
    public void removeProduct(Product product) {
        ImplLogger.enterMethod();
        productList.remove(product);
        ImplLogger.exitMethod();
    }
    /**
     * search product with bar code
     * @param barcode
     * @return 
     */
    public Product searchProduct(String barcode) {
        ImplLogger.enterMethod();
        for(Product product : productList) {
            if(product.getBarcode().equals(barcode)) {
                ImplLogger.debug("Product Found: " +  barcode);
                ImplLogger.exitMethod();                
                return product;
            }
        }
        ImplLogger.debug("No Product Found: " +  barcode);
        return null;
    }
    /**
     * search productItem with bar code
     * @param barcode
     * @return 
     */
    public ProductItem searchProductItem(String barcode) {
        ImplLogger.enterMethod();
        for(ProductItem productItem : productItems) {
            if(productItem.getProduct().getBarcode().equals(barcode)) {
                ImplLogger.debug("ProductItem Found: " +  barcode);
                ImplLogger.exitMethod();                
                return productItem;
            }
        }
        ImplLogger.debug("No ProductItem Found: " +  barcode);
        return null;
    }
    /**
     * remove productItem with bar code
     * @param productItem 
     */
    public void removeProductItem(ProductItem productItem) {
        ImplLogger.enterMethod();
        productItems.remove(productItem);
        ImplLogger.exitMethod();
    }
    /**
     *  add new productItem
     * @return 
     */
    public ProductItem addProductItem() {
        ImplLogger.enterMethod();
        ProductItem productItem = new ProductItem();
        productItems.add(productItem);
        ImplLogger.exitMethod();
        return productItem;
    }
}
