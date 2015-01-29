/*
 * Class : OrderCatalog.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 3:36:24 PM
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
import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class OrderCatalog {
    private ArrayList<Order> orderList;

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    
    public OrderCatalog() {
        this.orderList = new ArrayList<Order>();
    }
    /**
     * add order to the order catalog
     * @param order
     * @return 
     */
    public Order addOrder(Order order){
        ImplLogger.enterMethod();
        ImplLogger.debug("Order : " + order);
        orderList.add(order);
        ImplLogger.exitMethod();
        return order;
    }
    
}
