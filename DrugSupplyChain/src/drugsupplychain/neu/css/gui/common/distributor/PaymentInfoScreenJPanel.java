/*
 * Class : PaymentInfoScreenJPanel.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 16, 2014, 8:05:19 PM
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
package drugsupplychain.neu.css.gui.common.distributor;

import drugsupplychain.neu.css.model.address.Address;
import drugsupplychain.neu.css.model.address.AddressUtils;
import drugsupplychain.neu.css.model.distributor.Distributor;
import drugsupplychain.neu.css.model.order.Order;
import drugsupplychain.neu.css.model.order.OrderItem;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.pharmacompany.PharmaceauticalCompany;
import drugsupplychain.neu.css.model.product.ProductItem;
import drugsupplychain.neu.css.model.product.TrackOrganization;
import drugsupplychain.neu.css.util.ImplCommonUtil;
import drugsupplychain.neu.css.util.ImplConst;
import drugsupplychain.neu.css.util.ImplValidationUtils;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Laksh
 */
public class PaymentInfoScreenJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final Order order;
    private final Distributor distributor;
    /**
     * Creates new form PaymentInfoScreenJPanel
     * @param userProcessContainer
     * @param order
     * @param distributor
     */
    public PaymentInfoScreenJPanel(JPanel userProcessContainer,Order order,Distributor distributor) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.order = order;
        this.distributor = distributor;
        populateValues();
        populateDefaultAddress();
    }
    private void populateDefaultAddress(){
        regionComboBox.removeAllItems();
        for (String region : AddressUtils.getRegion()){
            regionComboBox.addItem(region);
        }
    }
    private void populateCountry(String region){
        countryComboBox.removeAllItems();
        for (String country : AddressUtils.getCountries(region)){
            countryComboBox.addItem(country);
        }
    }
    
    private void populateState(String country){
        stateComboBox.removeAllItems();
        for (String state : AddressUtils.getStates(country)){
            stateComboBox.addItem(state);
        }
    }
    private void populateCity(String state){
        cityComboBox.removeAllItems();
        for (String city : AddressUtils.getCities(state)){
            cityComboBox.addItem(city);
        }
    }
    /**
     * 
     */
    private void populateValues(){
        orderIDTextField.setText(String.valueOf(order.getOrderId()));
        totalPriceTextField.setText(order.getPrice());
        distributorsTextField.setText(String.valueOf(distributor.getOrganizationID()));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        orderIDTextField = new javax.swing.JTextField();
        totalPriceTextField = new javax.swing.JTextField();
        distributorsTextField = new javax.swing.JTextField();
        cancelOrderButton = new javax.swing.JButton();
        proceedToOrderButton = new javax.swing.JButton();
        zipCodeTextField = new javax.swing.JTextField();
        countryComboBox = new javax.swing.JComboBox();
        cityComboBox = new javax.swing.JComboBox();
        stateComboBox = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        addressLine1TextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        addressLine2TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        regionComboBox = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Browse Catalog");

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText(">>");

        jLabel5.setText(">>");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Order Summary");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Payment Screen");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Order Id");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel6.setText("Total Price");

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel9.setText("Distributor ID");

        orderIDTextField.setEditable(false);

        totalPriceTextField.setEditable(false);

        distributorsTextField.setEditable(false);

        cancelOrderButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        cancelOrderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/cancelicon2.png"))); // NOI18N
        cancelOrderButton.setText("Cancel Order");
        cancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderButtonActionPerformed(evt);
            }
        });

        proceedToOrderButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        proceedToOrderButton.setText("Proceed to Order Summary");
        proceedToOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedToOrderButtonActionPerformed(evt);
            }
        });

        countryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryComboBoxActionPerformed(evt);
            }
        });

        stateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateComboBoxActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel16.setText("Zip Code:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel10.setText("Address Line1:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel11.setText("Address Line2: ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel12.setText("Country:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel13.setText("City:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel14.setText("State:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel8.setText("Region:");

        regionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionComboBoxActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel15.setText("Billing Address");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(distributorsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                            .addComponent(totalPriceTextField)
                                            .addComponent(orderIDTextField)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(zipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(addressLine1TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addressLine2TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(countryComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(regionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 203, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cancelOrderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(proceedToOrderButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(totalPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(distributorsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel15)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressLine1TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLine2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(regionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedToOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void proceedToOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedToOrderButtonActionPerformed
        if (validateFields()){
            Address billingAddress = new Address();
            billingAddress.setAddressLine1(addressLine1TextField.getText());
            billingAddress.setAddressLine2(addressLine2TextField.getText());
            billingAddress.setCity(cityComboBox.getSelectedItem().toString());
            billingAddress.setCountry(countryComboBox.getSelectedItem().toString());
            billingAddress.setRegion(regionComboBox.getSelectedItem().toString());
            billingAddress.setState(stateComboBox.getSelectedItem().toString());
            billingAddress.setZipcode(zipCodeTextField.getText());
            //create the order
            order.setCreationDate(new Date());
            distributor.getOrderCatalog().addOrder(order);            
            for(OrderItem orderItem : order.getOrderItemList()){ 
                // Track the product
                TrackOrganization trackOrganization;
                if (null != orderItem.getProduct().getProductTracker().get(String.valueOf(distributor.getOrganizationID()))){
                    trackOrganization = orderItem.getProduct().getProductTracker().get(String.valueOf(distributor.getOrganizationID()));
                    trackOrganization.setPuchaseDate(trackOrganization.getPuchaseDate() + " " + ImplCommonUtil.getTodaysDate());
                    trackOrganization.setQuantity(trackOrganization.getQuantity() + orderItem.getQuantity());
                }
                else {
                    trackOrganization = new TrackOrganization();
                    trackOrganization.setOrganization(distributor);
                    trackOrganization.setPuchaseDate(ImplCommonUtil.getTodaysDate());
                    trackOrganization.setQuantity(orderItem.getQuantity());
                    orderItem.getProduct().getProductTracker().put(String.valueOf(distributor.getOrganizationID()), trackOrganization);
                }
            }
            // add the product in the product catalog
            for(OrderItem orderItem : order.getOrderItemList()){                
                ProductItem productItem = distributor.getProductCatalog().searchProductItem(orderItem.getProduct().getBarcode());
                if (null != productItem){
                    productItem.setProduct(orderItem.getProduct());
                    productItem.setQuantity(productItem.getQuantity() + orderItem.getQuantity());
                }
                else{
                   productItem = distributor.getProductCatalog().addProductItem();
                   productItem.setProduct(orderItem.getProduct());
                   productItem.setQuantity(orderItem.getQuantity());
                }
            }
            OrderSummryScreenJPanel orderSummryScreenJPanel = new OrderSummryScreenJPanel(userProcessContainer,order,distributor,billingAddress);
            userProcessContainer.add("OrderSummryScreenJPanel",orderSummryScreenJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }
    }//GEN-LAST:event_proceedToOrderButtonActionPerformed
     /**
     * validate the fields before submitting
     */
    private boolean validateFields(){        
        StringBuffer validationMessage = new StringBuffer();
        boolean isValidationPassed = true;
        if(ImplValidationUtils.isStringEmptyOrNull(addressLine1TextField.getText())){
            validationMessage.append(ImplConst.VALIDATE_ADDRESS_LINE1);
            validationMessage.append(ImplConst.NEXT_LINE);
            isValidationPassed = false;
        }
        if(!ImplValidationUtils.isInteger(zipCodeTextField.getText())){
            validationMessage.append(ImplConst.VALIDATE_ZIPCODE);
            validationMessage.append(ImplConst.NEXT_LINE);
            isValidationPassed = false;
        }        
        if(!isValidationPassed){
            JOptionPane.showMessageDialog(null,validationMessage);
        } 
        return isValidationPassed;
    }
    private void cancelOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOrderButtonActionPerformed
        for(OrderItem orderItem : order.getOrderItemList()){
           Organization organization = orderItem.getOrganization();
            if (organization instanceof Distributor){
                Distributor distributor1 = (Distributor)organization;
                for(ProductItem productItem : distributor1.getProductCatalog().getProductItems()){
                    if(productItem.getProduct().getBarcode().equals(orderItem.getProduct().getBarcode())){
                        productItem.setQuantity(productItem.getQuantity() +  orderItem.getQuantity());
                    }
                }
            }
            if (organization instanceof PharmaceauticalCompany){
                orderItem.getProduct().setAvailable(orderItem.getQuantity() +  orderItem.getProduct().getAvailable());
            }
        }
        order.setOrderItemList(new ArrayList<>());
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_cancelOrderButtonActionPerformed

    private void countryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryComboBoxActionPerformed
        populateState(String.valueOf(countryComboBox.getSelectedItem()));
    }//GEN-LAST:event_countryComboBoxActionPerformed

    private void stateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateComboBoxActionPerformed
        populateCity(String.valueOf(stateComboBox.getSelectedItem()));
    }//GEN-LAST:event_stateComboBoxActionPerformed

    private void regionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionComboBoxActionPerformed
        populateCountry(String.valueOf(regionComboBox.getSelectedItem()));
    }//GEN-LAST:event_regionComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressLine1TextField;
    private javax.swing.JTextField addressLine2TextField;
    private javax.swing.JButton cancelOrderButton;
    private javax.swing.JComboBox cityComboBox;
    private javax.swing.JComboBox countryComboBox;
    private javax.swing.JTextField distributorsTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField orderIDTextField;
    private javax.swing.JButton proceedToOrderButton;
    private javax.swing.JComboBox regionComboBox;
    private javax.swing.JComboBox stateComboBox;
    private javax.swing.JTextField totalPriceTextField;
    private javax.swing.JTextField zipCodeTextField;
    // End of variables declaration//GEN-END:variables
}