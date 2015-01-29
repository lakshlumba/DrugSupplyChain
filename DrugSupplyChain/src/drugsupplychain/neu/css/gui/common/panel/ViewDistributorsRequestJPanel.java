/*
 * Class : ViewDistributorsRequestJPanel.java
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
package drugsupplychain.neu.css.gui.common.panel;

import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.distributor.CityDistributor;
import drugsupplychain.neu.css.model.distributor.Distributor;
import drugsupplychain.neu.css.model.distributor.NationalDistributor;
import drugsupplychain.neu.css.model.distributor.RegionalDistributor;
import drugsupplychain.neu.css.model.distributor.StateDistributor;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.pharmacompany.InterNationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.NationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.RegionalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.StatePharmaceauticalCompany;
import drugsupplychain.neu.css.model.request.DistributorsRequest;
import drugsupplychain.neu.css.model.request.WorkRequest;
import drugsupplychain.neu.css.model.user.UserAccount;
import drugsupplychain.neu.css.util.ImplCommonUtil;
import drugsupplychain.neu.css.util.ImplConst;
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
public class ViewDistributorsRequestJPanel extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private final UserAccount userAccount;
    private final Organization organization;
    private ArrayList<DistributorsRequest> distributorsRequestList = new ArrayList<>();
    /**
     * Creates new form ViewDistributorsRequestJPanel
     * @param userProcessContainer
     * @param userAccount
     * @param organization
     */
    public ViewDistributorsRequestJPanel(JPanel userProcessContainer,UserAccount userAccount,Organization organization) {
        initComponents();
        ImplLogger.enterMethod();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        ImplLogger.exitMethod();
        populateProductRequests();
    }
    private void populateProductRequests(){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)productTable.getModel();
        defaultTableModel.setRowCount(0);
        distributorsRequestList = new ArrayList<>();
        if(organization instanceof InterNationalPharmaceauticalCompany){
            ImplLogger.info("Orgnaization : InterNationalPharmaceauticalCompany");
            InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany = (InterNationalPharmaceauticalCompany)organization;
            for (RegionalDistributor regionalDistributor : interNationalPharmaceauticalCompany.getRegionalDistributorDirectory().getRegionalDistributorList()){
                for (WorkRequest workRequest : regionalDistributor.getWorkQueue().getWorkRequestList()){
                    if (workRequest instanceof DistributorsRequest){
                        DistributorsRequest distributorsRequest = (DistributorsRequest)workRequest;
                        if (null != interNationalPharmaceauticalCompany.getProductCatalog().searchProduct(distributorsRequest.getProductId())){
                            distributorsRequestList.add(distributorsRequest);
                            Object[] row = new Object[8];
                            row[0] = distributorsRequest;
                            row[1] = distributorsRequest.getProductId();
                            row[2] = distributorsRequest.getProductName();
                            row[3] = distributorsRequest.getQuantity();
                            row[4] = distributorsRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getRequestDate());
                            row[5] = distributorsRequest.getStatus();
                            row[6] = ImplCommonUtil.getPriorityValue(distributorsRequest.getPriority());
                            row[7] = distributorsRequest.getDistributor();
                            defaultTableModel.addRow(row);
                        }
                    }            
                }
            }
        }   else if(organization instanceof RegionalPharmaceauticalCompany){
                ImplLogger.info("Orgnaization : RegionalPharmaceauticalCompany");
                RegionalPharmaceauticalCompany regionalPharmaceauticalCompany = (RegionalPharmaceauticalCompany)organization;
                for (NationalDistributor nationalDistributor : regionalPharmaceauticalCompany.getNationalDistributorDirectory().getNationalDistributorList()){
                    for (WorkRequest workRequest : nationalDistributor.getWorkQueue().getWorkRequestList()){
                        if (workRequest instanceof DistributorsRequest){
                            DistributorsRequest distributorsRequest = (DistributorsRequest)workRequest;
                            if (null != regionalPharmaceauticalCompany.getProductCatalog().searchProduct(distributorsRequest.getProductId())){
                                distributorsRequestList.add(distributorsRequest);
                                Object[] row = new Object[8];
                                row[0] = distributorsRequest;
                                row[1] = distributorsRequest.getProductId();
                                row[2] = distributorsRequest.getProductName();
                                row[3] = distributorsRequest.getQuantity();
                                row[4] = distributorsRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getRequestDate());
                                row[5] = distributorsRequest.getStatus();
                                row[6] = ImplCommonUtil.getPriorityValue(distributorsRequest.getPriority());
                                row[7] = distributorsRequest.getDistributor();
                                defaultTableModel.addRow(row);
                            }
                        }            
                    }
                }
        }   else if(organization instanceof NationalPharmaceauticalCompany){
                ImplLogger.info("Orgnaization : NationalPharmaceauticalCompany");
                NationalPharmaceauticalCompany nationalPharmaceauticalCompany = (NationalPharmaceauticalCompany)organization;
                for (StateDistributor stateDistributor : nationalPharmaceauticalCompany.getStateDistributorDirectory().getStateDistributorList()){
                    for (WorkRequest workRequest : stateDistributor.getWorkQueue().getWorkRequestList()){
                        if (workRequest instanceof DistributorsRequest){
                            DistributorsRequest distributorsRequest = (DistributorsRequest)workRequest;
                            if (null != nationalPharmaceauticalCompany.getProductCatalog().searchProduct(distributorsRequest.getProductId())){
                                distributorsRequestList.add(distributorsRequest);
                                Object[] row = new Object[8];
                                row[0] = distributorsRequest;
                                row[1] = distributorsRequest.getProductId();
                                row[2] = distributorsRequest.getProductName();
                                row[3] = distributorsRequest.getQuantity();
                                row[4] = distributorsRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getRequestDate());
                                row[5] = distributorsRequest.getStatus();
                                row[6] = ImplCommonUtil.getPriorityValue(distributorsRequest.getPriority());
                                row[7] = distributorsRequest.getDistributor();
                                defaultTableModel.addRow(row);
                            }
                        }            
                    }
                }
        }   else if(organization instanceof StatePharmaceauticalCompany){
                ImplLogger.info("Orgnaization : StatePharmaceauticalCompany");
                StatePharmaceauticalCompany statePharmaceauticalCompany = (StatePharmaceauticalCompany)organization;
                for (CityDistributor cityDistributor : statePharmaceauticalCompany.getCityDistributorDirectory().getCityDistributorList()){
                    for (WorkRequest workRequest : cityDistributor.getWorkQueue().getWorkRequestList()){
                        if (workRequest instanceof DistributorsRequest){
                            DistributorsRequest distributorsRequest = (DistributorsRequest)workRequest;
                            if (null != statePharmaceauticalCompany.getProductCatalog().searchProduct(distributorsRequest.getProductId())){
                                distributorsRequestList.add(distributorsRequest);
                                Object[] row = new Object[8];
                                row[0] = distributorsRequest;
                                row[1] = distributorsRequest.getProductId();
                                row[2] = distributorsRequest.getProductName();
                                row[3] = distributorsRequest.getQuantity();
                                row[4] = distributorsRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getRequestDate());
                                row[5] = distributorsRequest.getStatus();
                                row[6] = ImplCommonUtil.getPriorityValue(distributorsRequest.getPriority());
                                row[7] = distributorsRequest.getDistributor();
                                defaultTableModel.addRow(row);
                            }
                        }            
                    }
                }
        }   else if(organization instanceof RegionalDistributor){
                ImplLogger.info("Orgnaization : RegionalDistributor");
                RegionalDistributor regionalDistributor = (RegionalDistributor)organization;
                for (NationalDistributor nationalDistributor : regionalDistributor.getNationalDistributorDirectory().getNationalDistributorList()){
                    for (WorkRequest workRequest : nationalDistributor.getWorkQueue().getWorkRequestList()){
                        if (workRequest instanceof DistributorsRequest){
                            DistributorsRequest distributorsRequest = (DistributorsRequest)workRequest;
                            if (null != regionalDistributor.getProductCatalog().searchProductItem(distributorsRequest.getProductId())){
                                distributorsRequestList.add(distributorsRequest);
                                Object[] row = new Object[8];
                                row[0] = distributorsRequest;
                                row[1] = distributorsRequest.getProductId();
                                row[2] = distributorsRequest.getProductName();
                                row[3] = distributorsRequest.getQuantity();
                                row[4] = distributorsRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getRequestDate());
                                row[5] = distributorsRequest.getStatus();
                                row[6] = ImplCommonUtil.getPriorityValue(distributorsRequest.getPriority());
                                row[7] = distributorsRequest.getDistributor();
                                defaultTableModel.addRow(row);
                            }
                        }            
                    }
                }
        }   else if(organization instanceof NationalDistributor){
                ImplLogger.info("Orgnaization : NationalDistributor");
                NationalDistributor nationalDistributor = (NationalDistributor)organization;
                for (StateDistributor stateDistributor : nationalDistributor.getStateDistributorDirectory().getStateDistributorList()){
                    for (WorkRequest workRequest : stateDistributor.getWorkQueue().getWorkRequestList()){
                        if (workRequest instanceof DistributorsRequest){
                            DistributorsRequest distributorsRequest = (DistributorsRequest)workRequest;
                            if (null != nationalDistributor.getProductCatalog().searchProductItem(distributorsRequest.getProductId())){
                                distributorsRequestList.add(distributorsRequest);
                                Object[] row = new Object[8];
                                row[0] = distributorsRequest;
                                row[1] = distributorsRequest.getProductId();
                                row[2] = distributorsRequest.getProductName();
                                row[3] = distributorsRequest.getQuantity();
                                row[4] = distributorsRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getRequestDate());
                                row[5] = distributorsRequest.getStatus();
                                row[6] = ImplCommonUtil.getPriorityValue(distributorsRequest.getPriority());
                                row[7] = distributorsRequest.getDistributor();
                                defaultTableModel.addRow(row);
                            }
                        }            
                    }
                }
        }   else if(organization instanceof StateDistributor){
                ImplLogger.info("Orgnaization : StateDistributor");
                StateDistributor stateDistributor = (StateDistributor)organization;
                for (CityDistributor cityDistributor : stateDistributor.getCityDistributorDirectory().getCityDistributorList()){
                    for (WorkRequest workRequest : cityDistributor.getWorkQueue().getWorkRequestList()){
                        if (workRequest instanceof DistributorsRequest){
                            DistributorsRequest distributorsRequest = (DistributorsRequest)workRequest;
                            if (null != stateDistributor.getProductCatalog().searchProductItem(distributorsRequest.getProductId())){
                                distributorsRequestList.add(distributorsRequest);
                                Object[] row = new Object[8];
                                row[0] = distributorsRequest;
                                row[1] = distributorsRequest.getProductId();
                                row[2] = distributorsRequest.getProductName();
                                row[3] = distributorsRequest.getQuantity();
                                row[4] = distributorsRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getRequestDate());
                                row[5] = distributorsRequest.getStatus();
                                row[6] = ImplCommonUtil.getPriorityValue(distributorsRequest.getPriority());
                                row[7] = distributorsRequest.getDistributor();
                                defaultTableModel.addRow(row);
                            }
                        }            
                    }
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
                        Object[] row = new Object[8];
                        row[0] = distributorsRequest;
                        row[1] = distributorsRequest.getProductId();
                        row[2] = distributorsRequest.getProductName();
                        row[3] = distributorsRequest.getQuantity();
                        row[4] = distributorsRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(distributorsRequest.getRequestDate());
                        row[5] = distributorsRequest.getStatus();
                        row[6] = ImplCommonUtil.getPriorityValue(distributorsRequest.getPriority());
                        row[7] = distributorsRequest.getDistributor();
                        defaultTableModel.addRow(row);       
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
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        viewRequestDetails = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        approveRequestButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        none = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        priority = new javax.swing.JRadioButton();
        date = new javax.swing.JRadioButton();
        quantity = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Manage Distributors Request for Products");

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Product Id", "Product Name", "Quatity", "Requested Date", "Status", "Priority", "Distributor"
            }
        ));
        jScrollPane1.setViewportView(productTable);

        viewRequestDetails.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        viewRequestDetails.setText("View Request Details");
        viewRequestDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRequestDetailsActionPerformed(evt);
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

        approveRequestButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        approveRequestButton.setText("Approve Request");
        approveRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveRequestButtonActionPerformed(evt);
            }
        });

        refreshButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel6.setText("Sort By:");

        priority.setBackground(new java.awt.Color(255, 255, 255));
        sortBy.add(priority);
        priority.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        priority.setText("Priority");
        priority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priorityActionPerformed(evt);
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

        quantity.setBackground(new java.awt.Color(255, 255, 255));
        sortBy.add(quantity);
        quantity.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        quantity.setText("Quantity");
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(quantity)
                        .addGap(27, 27, 27)
                        .addComponent(date)
                        .addGap(18, 18, 18)
                        .addComponent(priority)
                        .addGap(18, 18, 18)
                        .addComponent(none))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewRequestDetails)
                            .addGap(40, 40, 40)
                            .addComponent(approveRequestButton))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(none)
                        .addComponent(priority)
                        .addComponent(date)
                        .addComponent(quantity)
                        .addComponent(jLabel6))
                    .addComponent(refreshButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approveRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewRequestDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ImplLogger.enterMethod();
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_backButtonActionPerformed

    private void viewRequestDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRequestDetailsActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  productTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            DistributorsRequest distributorsRequest = (DistributorsRequest)productTable.getValueAt(selectedRow, 0);
            Distributor distributor = (Distributor)productTable.getValueAt(selectedRow, 7);
            ViewDistributorsRequestDetailsJPanel viewDistributorsRequestDetailsJPanel =  new ViewDistributorsRequestDetailsJPanel(userProcessContainer,userAccount,distributorsRequest,distributor);
            userProcessContainer.add("ViewDistributorsRequestDetailsJPanel",viewDistributorsRequestDetailsJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_viewRequestDetailsActionPerformed

    private void approveRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveRequestButtonActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  productTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            DistributorsRequest distributorsRequest = (DistributorsRequest)productTable.getValueAt(selectedRow, 0);
            distributorsRequest.setStatus(ImplConst.CASE_APPROVED);
            distributorsRequest.setResolveDate(ImplCommonUtil.getTodaysDateBYDATE());
            distributorsRequest.setReceiver(userAccount);
            populateProductRequests();
        }  
        ImplLogger.exitMethod();
    }//GEN-LAST:event_approveRequestButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        ImplLogger.enterMethod();
        populateProductRequests();
        ImplLogger.exitMethod();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void noneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noneActionPerformed
        sortProductRequests(distributorsRequestList);
    }//GEN-LAST:event_noneActionPerformed

    private void priorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorityActionPerformed
        sortProductRequests(distributorsRequestList);
    }//GEN-LAST:event_priorityActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        sortProductRequests(distributorsRequestList);
    }//GEN-LAST:event_dateActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        sortProductRequests(distributorsRequestList);
    }//GEN-LAST:event_quantityActionPerformed
     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveRequestButton;
    private javax.swing.JButton backButton;
    private javax.swing.JRadioButton date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton none;
    private javax.swing.JRadioButton priority;
    private javax.swing.JTable productTable;
    private javax.swing.JRadioButton quantity;
    private javax.swing.JButton refreshButton;
    private javax.swing.ButtonGroup sortBy;
    private javax.swing.JButton viewRequestDetails;
    // End of variables declaration//GEN-END:variables
}
