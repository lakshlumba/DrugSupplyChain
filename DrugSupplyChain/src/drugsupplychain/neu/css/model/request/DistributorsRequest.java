/*
 * Class : DistributorsRequest.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 16, 2014, 2:24:43 PM
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

import drugsupplychain.neu.css.model.distributor.Distributor;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Laksh
 */
public class DistributorsRequest extends WorkRequest implements Comparable<DistributorsRequest>{
    private String productId;
    private String productName;
    private String quantity;
    private int priority;
    private Distributor distributor;

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }   

    public DistributorsRequest(){
        super();
    }
    
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString(){
        return this.getWorkRequestId();
    }
    
    /*
     * Comparator implementation to Sort DistributorsRequest object based on Amount
     */
    public static class OrderByQuantity implements Comparator<DistributorsRequest> {
        @Override
        public int compare(DistributorsRequest o1, DistributorsRequest o2) { 
            int quantity1 = Integer.parseInt(o1.getQuantity());
            int quantity2 = Integer.parseInt(o2.getQuantity());
            return quantity2 > quantity1 ? 1 : (quantity2 < quantity1 ? -1 : 0);
        }
    }
    /**
     * order by date
     */
    public static class OrderByDate implements Comparator<DistributorsRequest> {
        @Override
        public int compare(DistributorsRequest o1, DistributorsRequest o2) { 
            Date requestedDate1 = o1.getRequestDate();
            Date requestedDate2 = o2.getRequestDate();
            return requestedDate2.compareTo(requestedDate1);
        }
    }
    /**
     * order by priority
     */
    public static class OrderByPriority implements Comparator<DistributorsRequest> {
        @Override
        public int compare(DistributorsRequest o1, DistributorsRequest o2) { 
            int priority1 = o1.getPriority();
            int priority2 = o2.getPriority();
            return priority2 > priority1 ? 1 : (priority2 < priority1 ? -1 : 0);
        }
    }
    
    @Override
    public int compareTo(DistributorsRequest distributorsRequest) {
        return this.productName.compareTo(distributorsRequest.productName);
    }
}
