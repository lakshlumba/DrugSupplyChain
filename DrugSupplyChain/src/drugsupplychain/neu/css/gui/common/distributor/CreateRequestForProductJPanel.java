/*
 * Class : CreateRequestForProductJPanel.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 16, 2014, 12:26:05 AM
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

import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.FDI.FDISystem;
import drugsupplychain.neu.css.model.distributor.CityDistributor;
import drugsupplychain.neu.css.model.distributor.Distributor;
import drugsupplychain.neu.css.model.distributor.NationalDistributor;
import drugsupplychain.neu.css.model.distributor.RegionalDistributor;
import drugsupplychain.neu.css.model.distributor.StateDistributor;
import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.LawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.NationalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.StateLawAgency;
import drugsupplychain.neu.css.model.organization.other.ClinicOrganization;
import drugsupplychain.neu.css.model.organization.other.DispenceryOrganization;
import drugsupplychain.neu.css.model.organization.other.DoctorOrganization;
import drugsupplychain.neu.css.model.organization.other.HospitalOrganization;
import drugsupplychain.neu.css.model.organization.other.PharmacyOrganization;
import drugsupplychain.neu.css.model.organization.pharmacompany.InterNationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.NationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.RegionalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.StatePharmaceauticalCompany;
import drugsupplychain.neu.css.model.product.Product;
import drugsupplychain.neu.css.model.product.ProductItem;
import drugsupplychain.neu.css.model.request.DistributorsRequest;
import drugsupplychain.neu.css.model.request.WorkRequest;
import drugsupplychain.neu.css.model.user.UserAccount;
import drugsupplychain.neu.css.util.ImplCommonUtil;
import drugsupplychain.neu.css.util.ImplConst;
import drugsupplychain.neu.css.util.ImplValidationUtils;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laksh
 */
public class CreateRequestForProductJPanel extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private final UserAccount userAccount;
    private final Distributor distributor;
    private final LawAgency lawAgency;
    private final FDISystem fDISystem;
    private final ArrayList<DistributorsRequest> distributorsRequestList = new ArrayList<>();
    /**
     * Creates new form CreateRequestForProductJPanel
     * @param userProcessContainer
     * @param userAccount
     * @param distributor
     * @param lawAgency
     * @param fDISystem
     */
    public CreateRequestForProductJPanel(JPanel userProcessContainer, UserAccount userAccount,Distributor distributor,LawAgency lawAgency,FDISystem fDISystem) {
        initComponents();
        ImplLogger.enterMethod();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.distributor = distributor; 
        this.lawAgency = lawAgency;
        this.fDISystem = fDISystem;
        ImplLogger.exitMethod();
        populateProductRequests();
        populateProductsName();       
    }
    /**
     * populate product request
     */
    private void populateProductRequests(){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)productTable.getModel();
        defaultTableModel.setRowCount(0);
        for (WorkRequest workRequest : distributor.getWorkQueue().getWorkRequestList()){
            if (workRequest instanceof DistributorsRequest){
                DistributorsRequest distributorsRequest = (DistributorsRequest)workRequest;                    
                Object[] row = new Object[7];
                row[0] = distributorsRequest;
                row[1] = distributorsRequest.getProductId();
                row[2] = distributorsRequest.getProductName();
                row[3] = distributorsRequest.getQuantity();
                row[4] = distributorsRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getRequestDate());
                row[5] = distributorsRequest.getStatus();
                row[6] = ImplCommonUtil.getPriorityValue(distributorsRequest.getPriority());
                defaultTableModel.addRow(row);
            }          
        }
        ImplLogger.exitMethod();
    }
    /**
     * populate request list by comparator
     * @param distributorsRequestList 
     */
    private void sortProductRequests(ArrayList<DistributorsRequest> distributorsRequestList){
        ImplLogger.exitMethod();
        if (null != distributorsRequestList && distributorsRequestList.size() > 0){
            DefaultTableModel defaultTableModel = (DefaultTableModel)productTable.getModel();
            defaultTableModel.setRowCount(0);
            if(sortBy.getSelection().equals(quantity.getModel())){
                Collections.sort(distributorsRequestList, new DistributorsRequest.OrderByQuantity());
            }else if (sortBy.getSelection().equals(date.getModel())){
               Collections.sort(distributorsRequestList, new DistributorsRequest.OrderByDate());
            }else if (sortBy.getSelection().equals(priority.getModel())){
                Collections.sort(distributorsRequestList, new DistributorsRequest.OrderByPriority());
            }else if (sortBy.getSelection().equals(none.getModel())){
                populateProductRequests();
                return;
            }else {
                JOptionPane.showMessageDialog(null, "Please select correct value from the sortby gruop");
            }
            for (DistributorsRequest distributorsRequest : distributorsRequestList){
                        Object[] row = new Object[7];
                        row[0] = distributorsRequest;
                        row[1] = distributorsRequest.getProductId();
                        row[2] = distributorsRequest.getProductName();
                        row[3] = distributorsRequest.getQuantity();
                        row[4] = distributorsRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(distributorsRequest.getRequestDate());
                        row[5] = distributorsRequest.getStatus();
                        row[6] = ImplCommonUtil.getPriorityValue(distributorsRequest.getPriority());
                        defaultTableModel.addRow(row);       
                }
            }
        ImplLogger.exitMethod();
    }
    /**
     * populate product name
     */
    private void populateProductsName(){
        ImplLogger.enterMethod();
        productIdComboBox.removeAllItems();
        if (distributor instanceof PharmacyOrganization || distributor instanceof HospitalOrganization || distributor instanceof ClinicOrganization
                || distributor instanceof DoctorOrganization || distributor instanceof DispenceryOrganization){
            CityLawAgency cityLawAgency = (CityLawAgency)lawAgency;
            if (null != cityLawAgency){                
                for (CityDistributor cityDistributor : cityLawAgency.getCityDistributorDirectory().getCityDistributorList()){
                    if (null != cityDistributor.getOrganizationDirectory().searchOrganization(distributor.getOrganizationID())){
                        for (ProductItem productItem :  cityDistributor.getProductCatalog().getProductItems()){   
                            productIdComboBox.addItem(productItem.getProduct());   
                        }
                    }
                }
            }
        }
        if (distributor instanceof CityDistributor){
            StateLawAgency stateLawAgency = (StateLawAgency)lawAgency;
            if (null != stateLawAgency){                
                for (StatePharmaceauticalCompany statePharmaceauticalCompany : stateLawAgency.getStatePharmaceauticalCompanyDirectory().getStatePharmaceauticalCompanyList()){
                    if (null != statePharmaceauticalCompany.getCityDistributorDirectory().searchCityDistributor(distributor.getOrganizationID())){
                        for (Product product :  statePharmaceauticalCompany.getProductCatalog().getProductList()){   
                            productIdComboBox.addItem(product);   
                        }
                    }
                }
                for (StateDistributor stateDistributor : stateLawAgency.getStateDistributorDirectory().getStateDistributorList()){
                  if (null != stateDistributor.getCityDistributorDirectory().searchCityDistributor(distributor.getOrganizationID())){
                    for (ProductItem productItem :  stateDistributor.getProductCatalog().getProductItems()){   
                        productIdComboBox.addItem(productItem.getProduct());   
                    }
                  }
                }
            }
        }
        if (distributor instanceof StateDistributor){
            NationalLawAgency nationalLawAgency = (NationalLawAgency)lawAgency;
            if (null != nationalLawAgency){
                    for (NationalPharmaceauticalCompany nationalPharmaceauticalCompany : nationalLawAgency.getNationalPharmaceauticalCompanyDirectory().getNationalPharmaceauticalCompanyList()){
                      if (null != nationalPharmaceauticalCompany.getStateDistributorDirectory().searchStateDistributor(distributor.getOrganizationID())){
                        for (Product product :  nationalPharmaceauticalCompany.getProductCatalog().getProductList()){   
                            productIdComboBox.addItem(product);    
                        }
                      }
                    }
                    for (NationalDistributor nationalDistributor : nationalLawAgency.getNationalDistributorDirectory().getNationalDistributorList()){
                      if (null != nationalDistributor.getStateDistributorDirectory().searchStateDistributor(distributor.getOrganizationID())){
                        for (ProductItem productItem :  nationalDistributor.getProductCatalog().getProductItems()){   
                            productIdComboBox.addItem(productItem.getProduct());    
                        }
                      }
                    }
            }
        } 
        if (distributor instanceof NationalDistributor){
            RegionalLawAgency regionalLawAgency = (RegionalLawAgency)lawAgency;
            if (null != regionalLawAgency){
                for (RegionalPharmaceauticalCompany regionalPharmaceauticalCompany : regionalLawAgency.getRegionalPharmaceauticalCompanyDirectory().getRegionalPharmaceauticalCompanyList()){
                    if(null != regionalPharmaceauticalCompany.getNationalDistributorDirectory().searchNationalDistributor(distributor.getOrganizationID())){
                        for (Product product :  regionalPharmaceauticalCompany.getProductCatalog().getProductList()){   
                           productIdComboBox.addItem(product); 
                        }
                    }
                }
                for (RegionalDistributor regionalDistributor : regionalLawAgency.getRegionalDistributorDirectory().getRegionalDistributorList()){
                    if(null != regionalDistributor.getNationalDistributorDirectory().searchNationalDistributor(distributor.getOrganizationID())){
                        for (ProductItem productItem : regionalDistributor.getProductCatalog().getProductItems()){  
                           productIdComboBox.addItem(productItem.getProduct()); 
                        }
                    }
                }
            }
        }
        if (distributor instanceof RegionalDistributor) {
            if (null != fDISystem){
                for (InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany : fDISystem.getInterNationalPharmaceauticalCompanyDirectory().getInterNationalPharmaceauticalCompanyList()){       
                    if (null != interNationalPharmaceauticalCompany.getRegionalDistributorDirectory().searchRegionalDistributor(distributor.getOrganizationID())){
                        for (Product product :  interNationalPharmaceauticalCompany.getProductCatalog().getProductList()){   
                            productIdComboBox.addItem(product);    
                        }
                    }      
                }
            
            }
        }
        ImplLogger.exitMethod();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sortBy = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productNameTextField = new javax.swing.JTextField();
        quantityTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        requestProductButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        productIdComboBox = new javax.swing.JComboBox();
        backButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        prioritySlider = new javax.swing.JSlider();
        priorityLabel = new javax.swing.JLabel();
        quantity = new javax.swing.JRadioButton();
        date = new javax.swing.JRadioButton();
        priority = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        none = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Create Request for Products");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Product Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("Quantity Needed:");

        productNameTextField.setEditable(false);

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Product Id", "Product Name", "Quatity", "Requested Date", "Status", "Priority"
            }
        ));
        jScrollPane1.setViewportView(productTable);

        requestProductButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        requestProductButton.setText("Request Product");
        requestProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestProductButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setText("Product Id:");

        productIdComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        productIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdComboBoxActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setText("Priority");

        prioritySlider.setBackground(new java.awt.Color(51, 255, 51));
        prioritySlider.setForeground(new java.awt.Color(0, 0, 255));
        prioritySlider.setMajorTickSpacing(25);
        prioritySlider.setMaximum(75);
        prioritySlider.setPaintLabels(true);
        prioritySlider.setPaintTicks(true);
        prioritySlider.setPaintTrack(false);
        prioritySlider.setValue(0);
        prioritySlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        prioritySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                prioritySliderStateChanged(evt);
            }
        });

        priorityLabel.setText("LOW");

        quantity.setBackground(new java.awt.Color(255, 255, 255));
        sortBy.add(quantity);
        quantity.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        quantity.setText("Quantity");
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        date.setBackground(new java.awt.Color(255, 255, 255));
        sortBy.add(date);
        date.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        date.setText("Requested Date");
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        priority.setBackground(new java.awt.Color(255, 255, 255));
        sortBy.add(priority);
        priority.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        priority.setText("Priority");
        priority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priorityActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel6.setText("Sort By:");

        none.setBackground(new java.awt.Color(255, 255, 255));
        sortBy.add(none);
        none.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        none.setSelected(true);
        none.setText("None");
        none.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prioritySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priorityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 389, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(quantity))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(210, 210, 210)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(date)
                                .addGap(18, 18, 18)
                                .addComponent(priority)
                                .addGap(18, 18, 18)
                                .addComponent(none)
                                .addGap(3, 3, 3)))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(requestProductButton)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(none)
                    .addComponent(priority)
                    .addComponent(date)
                    .addComponent(quantity)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(productIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(prioritySlider, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(priorityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * back button
     * @param evt 
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ImplLogger.enterMethod();
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_backButtonActionPerformed
    /**
     * request product
     * @param evt 
     */
    private void requestProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestProductButtonActionPerformed
        ImplLogger.enterMethod();
        if (validateFields()){
            Product product = (Product)productIdComboBox.getSelectedItem();       
            DistributorsRequest distributorsRequest = new DistributorsRequest();
            distributorsRequest.setProductId(product.getBarcode());
            distributorsRequest.setProductName(productNameTextField.getText());
            distributorsRequest.setQuantity(quantityTextField.getText());
            distributorsRequest.setSender(userAccount);
            distributorsRequest.setMessage("ID: " + distributor.getOrganizationID() + " Name:" + distributor.getName() + " Region:" + distributor.getLocation() + " Lincense:" + distributor.getLincense());
            distributorsRequest.setRequestDate(ImplCommonUtil.getTodaysDateBYDATE());
            distributorsRequest.setStatus(ImplConst.CASE_NEW);
            distributorsRequest.setPriority(prioritySlider.getValue());
            distributorsRequest.setDistributor(distributor);
            distributor.getWorkQueue().getWorkRequestList().add(distributorsRequest);
            clearAll();
            distributorsRequestList.add(distributorsRequest);
            populateProductRequests();  
        } 
        ImplLogger.exitMethod();
    }//GEN-LAST:event_requestProductButtonActionPerformed
    
    /**
     * validate the fields before submitting
     */
    private boolean validateFields(){        
        ImplLogger.enterMethod();
        StringBuffer validationMessage = new StringBuffer();
        boolean isValidationPassed = true;
        Product product = (Product)productIdComboBox.getSelectedItem(); 
        if(null != product){
            if(ImplValidationUtils.isStringEmptyOrNull(productNameTextField.getText())){
                validationMessage.append(ImplConst.VALIDATE_DISTRIBUTOR_NAME);
                validationMessage.append(ImplConst.NEXT_LINE);
                isValidationPassed = false;
            }
            if (!ImplValidationUtils.isInteger(quantityTextField.getText())){
                validationMessage.append(ImplConst.VALIDATE_QUANTITY);
                validationMessage.append(ImplConst.NEXT_LINE);
                isValidationPassed = false;
            }          
            if(!isValidationPassed){
                JOptionPane.showMessageDialog(null,validationMessage);
            }
            return isValidationPassed;
        } 
        ImplLogger.exitMethod();
        return false;
    }
    /**
     * clear all the text field
     */
    private void clearAll(){
        ImplLogger.enterMethod();
        productIdComboBox.setSelectedIndex(0);
        productNameTextField.setText(ImplConst.EMPTY);
        quantityTextField.setText(ImplConst.EMPTY);
        ImplLogger.exitMethod();
    }  
    /**
     * product id
     * @param evt 
     */
    private void productIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdComboBoxActionPerformed
        ImplLogger.enterMethod();
        Product product = (Product)productIdComboBox.getSelectedItem();
        if (null != product){
           productNameTextField.setText(product.getProductName());
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_productIdComboBoxActionPerformed
    /**
     * priority slider
     * @param evt 
     */
    private void prioritySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_prioritySliderStateChanged
        priorityLabel.setText(ImplCommonUtil.getPriorityValue(prioritySlider.getValue()));
    }//GEN-LAST:event_prioritySliderStateChanged

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        sortProductRequests(distributorsRequestList);
    }//GEN-LAST:event_quantityActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
         sortProductRequests(distributorsRequestList);
    }//GEN-LAST:event_dateActionPerformed

    private void priorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorityActionPerformed
        sortProductRequests(distributorsRequestList);
    }//GEN-LAST:event_priorityActionPerformed

    private void noneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noneActionPerformed
        sortProductRequests(distributorsRequestList);
    }//GEN-LAST:event_noneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JRadioButton date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton none;
    private javax.swing.JRadioButton priority;
    private javax.swing.JLabel priorityLabel;
    private javax.swing.JSlider prioritySlider;
    private javax.swing.JComboBox productIdComboBox;
    private javax.swing.JTextField productNameTextField;
    private javax.swing.JTable productTable;
    private javax.swing.JRadioButton quantity;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JButton requestProductButton;
    private javax.swing.ButtonGroup sortBy;
    // End of variables declaration//GEN-END:variables
}
