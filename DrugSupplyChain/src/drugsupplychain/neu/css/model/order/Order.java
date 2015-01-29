/*
 * Class : Order.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 3:36:12 PM
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

import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.product.Product;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Laksh
 */
public class Order {
    private static int count = 0;
    private ArrayList<OrderItem> orderItemList;
    private int orderId;
    private Date creationDate;

    public Order() {
        count++;
        this.orderItemList =  new ArrayList<OrderItem>();
        this.orderId = count;
    }
       
    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
     /**
     * add orderItem to Order
     * @param product
     * @param quantity
     * @param shopId
     * @param shopName
     * @return 
     */
    public OrderItem addOrderItem(Product product,int quantity,int shopId, Organization shopName){
        ImplLogger.enterMethod();
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setShopId(shopId);
        orderItem.setOrganization(shopName);
        ImplLogger.debug("Product: " + product + " quantity " + quantity);
        orderItemList.add(orderItem);
        ImplLogger.exitMethod();
        return orderItem;        
    }/**
     * 
     * @return 
     */
    public String getPrice(){
        int totalPrice = 0;
        for (OrderItem orderItem : orderItemList){
            totalPrice = totalPrice + orderItem.getQuantity()  * orderItem.getProduct().getPrice();
        }
        return String.valueOf(totalPrice);
    }
    /**
     * remove the order item
     * @param orderItem 
     */
    public void removeItem(OrderItem orderItem) {
        ImplLogger.enterMethod();
        ImplLogger.debug("Removing Order Item: " + orderItem);
        orderItemList.remove(orderItem);
        ImplLogger.exitMethod();
    }

    @Override
    public String toString() {
        return String.valueOf(orderId);
    }
    
    
}
