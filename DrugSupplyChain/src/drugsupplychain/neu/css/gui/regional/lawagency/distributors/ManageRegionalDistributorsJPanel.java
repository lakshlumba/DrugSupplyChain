/*
 * Class : FDISystemAdminWorkAreaJPanel.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 11, 2014, 11:45:15 PM
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
package drugsupplychain.neu.css.gui.regional.lawagency.distributors;

import drugsupplychain.neu.css.gui.common.lawAgency.distributor.ManageDistributorRequestsJPanel;
import drugsupplychain.neu.css.gui.common.lawAgency.distributor.ManageDistributorProductJPanel;
import drugsupplychain.neu.css.gui.common.panel.ManagePharmaCoLisenceJPanel;
import drugsupplychain.neu.css.gui.common.panel.RegisterPharmaOrganizationJPanel;
import drugsupplychain.neu.css.model.distributor.RegionalDistributor;
import drugsupplychain.neu.css.model.distributor.RegionalDistributorDirectory;
import drugsupplychain.neu.css.model.organization.Organization.Type;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgency;
import drugsupplychain.neu.css.model.organization.pharmacompany.InterNationalPharmaceauticalCompanyDirectory;
import drugsupplychain.neu.css.model.request.DistributorsRequest;
import drugsupplychain.neu.css.model.request.WorkRequest;
import drugsupplychain.neu.css.util.ImplConst;
import drugsupplychain.neu.css.util.ImplValidationUtils;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laksh
 */
public class ManageRegionalDistributorsJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final RegionalDistributorDirectory regionalDistributorDirectory;
    private final RegionalLawAgency regionalLawAgency;
    /**
     * Creates new form ManageRegionalPharmaCompanyJPanel
     * @param userProcessContainer
     * @param interNationalPharmaceauticalCompanyDirectory
     * @param regionalLawAgency
     */
    public ManageRegionalDistributorsJPanel(JPanel userProcessContainer,InterNationalPharmaceauticalCompanyDirectory interNationalPharmaceauticalCompanyDirectory,RegionalLawAgency regionalLawAgency) {
        initComponents();
        this.regionalDistributorDirectory = regionalLawAgency.getRegionalDistributorDirectory();
        this.userProcessContainer = userProcessContainer;
        this.regionalLawAgency = regionalLawAgency;
        populateTable();
        populateNotification();
    }
    private void populateNotification(){
        int notification = 0;
        for (RegionalDistributor regionalDistributor : regionalLawAgency.getRegionalDistributorDirectory().getRegionalDistributorList()){
            for(WorkRequest workRequest : regionalDistributor.getWorkQueue().getWorkRequestList()){
                if(!(workRequest instanceof DistributorsRequest)){
                    if(workRequest.getStatus().equals(ImplConst.CASE_NEW)){
                        notification++;
                    }
                }
            }      
        }

        notificationLabel.setText(String.valueOf(notification));
    }
    private void populateTable(){
        DefaultTableModel defaultTableModel = (DefaultTableModel)distributorTable.getModel();
        defaultTableModel.setRowCount(0);     
        for (RegionalDistributor regionalDistributor : regionalLawAgency.getRegionalDistributorDirectory().getRegionalDistributorList()){
                Object[] row = new Object[5];
                row[0] = regionalDistributor.getOrganizationID();
                row[1] = regionalDistributor;
                row[2] = regionalLawAgency.getName();
                row[3] = regionalDistributor.getLincense().getLicenseNumber();
                row[4] = regionalDistributor.getLincense().isIsLicenseValid();
                defaultTableModel.addRow(row);
        }
    }
    
    private void populateTable(int pharmaId){
        DefaultTableModel defaultTableModel = (DefaultTableModel)distributorTable.getModel();
        defaultTableModel.setRowCount(0);
        for (RegionalDistributor regionalDistributor : regionalLawAgency.getRegionalDistributorDirectory().getRegionalDistributorList()){
                if (regionalDistributor.getOrganizationID()== pharmaId){
                    Object[] row = new Object[4];
                        row[0] = regionalDistributor.getOrganizationID();
                        row[1] = regionalDistributor;
                        row[2] = regionalLawAgency.getName();
                        row[3] = regionalDistributor.getLincense().getLicenseNumber();
                        row[4] = regionalDistributor.getLincense().isIsLicenseValid();
                        defaultTableModel.addRow(row);           
                }
        }
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
        manageLisenceButton = new javax.swing.JButton();
        manageDistributorsRequest = new javax.swing.JButton();
        registerDistributorButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        distributorTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        pharmaIdTextField = new javax.swing.JTextField();
        searchByIdButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        notificationLabel = new javax.swing.JLabel();
        manageDistributorProduct = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Manage Regional Distributors Pharama Co.");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        manageLisenceButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageLisenceButton.setText("Manage License ");
        manageLisenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageLisenceButtonActionPerformed(evt);
            }
        });
        add(manageLisenceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 170, 50));

        manageDistributorsRequest.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageDistributorsRequest.setText("Manage Requests");
        manageDistributorsRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDistributorsRequestActionPerformed(evt);
            }
        });
        add(manageDistributorsRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, 50));

        registerDistributorButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        registerDistributorButton.setText("Register Distributor ");
        registerDistributorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerDistributorButtonActionPerformed(evt);
            }
        });
        add(registerDistributorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 180, 50));

        distributorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Distributor ID", "Distributors Name", "Region Name", "License Number", "Is License Valid"
            }
        ));
        jScrollPane1.setViewportView(distributorTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 730, 160));

        backButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 110, 40));
        add(pharmaIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 120, 30));

        searchByIdButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        searchByIdButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/searchicon.png"))); // NOI18N
        searchByIdButton.setText("Search By Id");
        searchByIdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByIdButtonActionPerformed(evt);
            }
        });
        add(searchByIdButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, 30));

        refreshButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.add(notificationLabel);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 20, 20));

        manageDistributorProduct.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageDistributorProduct.setText("Distributors Product");
        manageDistributorProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDistributorProductActionPerformed(evt);
            }
        });
        add(manageDistributorProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, -1, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void registerDistributorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerDistributorButtonActionPerformed
       RegisterPharmaOrganizationJPanel registerPharmaOrganizationJPanel = new RegisterPharmaOrganizationJPanel(userProcessContainer,regionalDistributorDirectory,regionalLawAgency,Type.REGIONAL_DISTRIBUTOR);
       userProcessContainer.add("RegisterPharmaOrganizationJPanel",registerPharmaOrganizationJPanel);
       CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_registerDistributorButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void searchByIdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByIdButtonActionPerformed
        if(validateFields()){
            int pharmaId = Integer.parseInt(pharmaIdTextField.getText());
            populateTable(pharmaId);
        }
    }//GEN-LAST:event_searchByIdButtonActionPerformed

    private void manageLisenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageLisenceButtonActionPerformed
        int selectedRow =  distributorTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            RegionalDistributor regionalDistributor = (RegionalDistributor)distributorTable.getValueAt(selectedRow, 1);
            ManagePharmaCoLisenceJPanel managePharmaCoLisenceJPanel =  new ManagePharmaCoLisenceJPanel(userProcessContainer,regionalDistributor,Type.REGIONAL_DISTRIBUTOR);
            userProcessContainer.add("ManageDistributorLisenceJPanel",managePharmaCoLisenceJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }  
    }//GEN-LAST:event_manageLisenceButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        populateTable();
        populateNotification();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void manageDistributorsRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDistributorsRequestActionPerformed
        int selectedRow =  distributorTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            RegionalDistributor regionalDistributor = (RegionalDistributor)distributorTable.getValueAt(selectedRow, 1);
            ManageDistributorRequestsJPanel manageDistributorRequestsJPanel =  new ManageDistributorRequestsJPanel(userProcessContainer,regionalDistributor);
            userProcessContainer.add("ManagePharmaRequestsJPanel",manageDistributorRequestsJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }  
    }//GEN-LAST:event_manageDistributorsRequestActionPerformed

    private void manageDistributorProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDistributorProductActionPerformed
        int selectedRow =  distributorTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            RegionalDistributor regionalDistributor = (RegionalDistributor)distributorTable.getValueAt(selectedRow, 1);
            ManageDistributorProductJPanel managePharmaProductJPanel =  new ManageDistributorProductJPanel(userProcessContainer,regionalDistributor.getProductCatalog(),regionalDistributor);
            userProcessContainer.add("ManagePharmaProductJPanel",managePharmaProductJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }
    }//GEN-LAST:event_manageDistributorProductActionPerformed
     /**
     * validate the fields before submitting
     */
    private boolean validateFields(){        
        StringBuffer validationMessage = new StringBuffer();
        boolean isValidationPassed = true;
        if(!ImplValidationUtils.isInteger(pharmaIdTextField.getText())){
            validationMessage.append(ImplConst.VALIDATE_INTEGER_VALUE);
            validationMessage.append(ImplConst.NEXT_LINE);
            isValidationPassed = false;
        }
        if(!isValidationPassed){
            JOptionPane.showMessageDialog(null,validationMessage);
        } 
        return isValidationPassed;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTable distributorTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageDistributorProduct;
    private javax.swing.JButton manageDistributorsRequest;
    private javax.swing.JButton manageLisenceButton;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JTextField pharmaIdTextField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton registerDistributorButton;
    private javax.swing.JButton searchByIdButton;
    // End of variables declaration//GEN-END:variables
}
