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
package drugsupplychain.neu.css.gui.inter.lawAgency.pharma;

import drugsupplychain.neu.css.gui.common.panel.RegisterPharmaOrganizationJPanel;
import drugsupplychain.neu.css.gui.common.lawAgency.pharma.ManagePharmaProductJPanel;
import drugsupplychain.neu.css.gui.common.lawAgency.pharma.ManagePharmaRequestsJPanel;
import drugsupplychain.neu.css.gui.common.panel.ManagePharmaCoLisenceJPanel;
import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.FDI.FDISystem;
import drugsupplychain.neu.css.model.organization.Organization.Type;
import drugsupplychain.neu.css.model.organization.pharmacompany.InterNationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.InterNationalPharmaceauticalCompanyDirectory;
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
public class ManageInterPharmaCompanyJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final InterNationalPharmaceauticalCompanyDirectory interNationalPharmaceauticalCompanyDirectory;
    private final FDISystem fDISystem;
    /**
     * Creates new form ManageInterPharmaCompanyJPanel
     * @param userProcessContainer
     * @param fDISystem
     */
    public ManageInterPharmaCompanyJPanel(JPanel userProcessContainer,FDISystem fDISystem) {
        initComponents();
        ImplLogger.enterMethod();
        this.interNationalPharmaceauticalCompanyDirectory = fDISystem.getInterNationalPharmaceauticalCompanyDirectory();
        this.userProcessContainer = userProcessContainer;
        this.fDISystem = fDISystem;
        ImplLogger.exitMethod();
        populateTable();
        populateNotification();
    }
    /**
     * populate notification
     */
    private void populateNotification(){
        ImplLogger.enterMethod();
        int notification = 0;
        for (InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany : interNationalPharmaceauticalCompanyDirectory.getInterNationalPharmaceauticalCompanyList()){
            for(WorkRequest workRequest : interNationalPharmaceauticalCompany.getWorkQueue().getWorkRequestList()){
                if(workRequest.getStatus().equals(ImplConst.CASE_NEW)){
                    notification++;
                }
            }      
        }
        notificationLabel.setText(String.valueOf(notification));
        ImplLogger.exitMethod();
    }
    /**
     * populate the table
     */
    private void populateTable(){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)pharmaTable.getModel();
        defaultTableModel.setRowCount(0);
        for (InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany : interNationalPharmaceauticalCompanyDirectory.getInterNationalPharmaceauticalCompanyList()){
            Object[] row = new Object[4];
            row[0] = interNationalPharmaceauticalCompany;
            row[1] = interNationalPharmaceauticalCompany.getOrganizationID();
            row[2] = interNationalPharmaceauticalCompany.getLincense().getLicenseNumber();
            row[3] = interNationalPharmaceauticalCompany.getLincense().isIsLicenseValid();
            defaultTableModel.addRow(row);            
        }
        ImplLogger.exitMethod();
    }
    /**
     * populate the table with pharmaid
     * @param pharmaId 
     */
    private void populateTable(int pharmaId){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)pharmaTable.getModel();
        defaultTableModel.setRowCount(0);
        for (InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany : interNationalPharmaceauticalCompanyDirectory.getInterNationalPharmaceauticalCompanyList()){
            if (interNationalPharmaceauticalCompany.getOrganizationID()== pharmaId){
                Object[] row = new Object[4];
                row[0] = interNationalPharmaceauticalCompany;
                row[1] = interNationalPharmaceauticalCompany.getOrganizationID();
                row[2] = interNationalPharmaceauticalCompany.getLincense().getLicenseNumber();
                row[3] = interNationalPharmaceauticalCompany.getLincense().isIsLicenseValid();
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

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        manageLisenceButton = new javax.swing.JButton();
        managePharmRequest = new javax.swing.JButton();
        registerPharmaCoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pharmaTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        pharmaIdTextField = new javax.swing.JTextField();
        searchByIdButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        managePharmaProduct = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        notificationLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Manage Inter Pharama Co.");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        manageLisenceButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageLisenceButton.setText("Manage License ");
        manageLisenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageLisenceButtonActionPerformed(evt);
            }
        });
        add(manageLisenceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 170, 50));

        managePharmRequest.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        managePharmRequest.setText("Manage Requests");
        managePharmRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePharmRequestActionPerformed(evt);
            }
        });
        add(managePharmRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, 50));

        registerPharmaCoButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        registerPharmaCoButton.setText("Register Pharma Co. ");
        registerPharmaCoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPharmaCoButtonActionPerformed(evt);
            }
        });
        add(registerPharmaCoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 180, 50));

        pharmaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pharmaceautical Name", "PharmaId", "License Number", "Is License Valid"
            }
        ));
        jScrollPane1.setViewportView(pharmaTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 730, 160));

        backButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 110, 40));
        add(pharmaIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 120, 40));

        searchByIdButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        searchByIdButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/searchicon.png"))); // NOI18N
        searchByIdButton.setText("Search By Id");
        searchByIdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByIdButtonActionPerformed(evt);
            }
        });
        add(searchByIdButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, -1, 40));

        refreshButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        managePharmaProduct.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        managePharmaProduct.setText("Manage Pharma Product");
        managePharmaProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePharmaProductActionPerformed(evt);
            }
        });
        add(managePharmaProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.add(notificationLabel);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 20, 20));
    }// </editor-fold>//GEN-END:initComponents
    /**
     * manage the pharma company
     * @param evt 
     */
    private void registerPharmaCoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPharmaCoButtonActionPerformed
       ImplLogger.enterMethod();
       RegisterPharmaOrganizationJPanel registerPharmaCOJPanel = new RegisterPharmaOrganizationJPanel(userProcessContainer,interNationalPharmaceauticalCompanyDirectory,fDISystem,Type.INTER_PHARMA_CO);
       userProcessContainer.add("RegisterPharmaCOJPanel",registerPharmaCOJPanel);
       CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
       ImplLogger.exitMethod();
    }//GEN-LAST:event_registerPharmaCoButtonActionPerformed
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
     * populate by search by id
     * @param evt 
     */
    private void searchByIdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByIdButtonActionPerformed
        ImplLogger.enterMethod();
        if(validateFields()){
            int pharmaId = Integer.parseInt(pharmaIdTextField.getText());
            populateTable(pharmaId);
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_searchByIdButtonActionPerformed
    /**
     * manage the license of pharma company
     * @param evt 
     */
    private void manageLisenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageLisenceButtonActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  pharmaTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany = (InterNationalPharmaceauticalCompany)pharmaTable.getValueAt(selectedRow, 0);
            ManagePharmaCoLisenceJPanel managePharmaCoLisenceJPanel =  new ManagePharmaCoLisenceJPanel(userProcessContainer,interNationalPharmaceauticalCompany,Type.INTER_PHARMA_CO);
            userProcessContainer.add("ManagePharmaCoLisenceJPanel",managePharmaCoLisenceJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        } 
        ImplLogger.exitMethod();
    }//GEN-LAST:event_manageLisenceButtonActionPerformed
    /**
     * refresh button
     * @param evt 
     */
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        ImplLogger.enterMethod();
        populateTable();
        populateNotification();
        ImplLogger.exitMethod();
    }//GEN-LAST:event_refreshButtonActionPerformed
    /**
     * manage pharma button
     * @param evt 
     */
    private void managePharmRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePharmRequestActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  pharmaTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany = (InterNationalPharmaceauticalCompany)pharmaTable.getValueAt(selectedRow, 0);
            ManagePharmaRequestsJPanel managePharmaRequestsJPanel =  new ManagePharmaRequestsJPanel(userProcessContainer,interNationalPharmaceauticalCompany);
            userProcessContainer.add("ManagePharmaRequestsJPanel",managePharmaRequestsJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }  
        ImplLogger.exitMethod();
    }//GEN-LAST:event_managePharmRequestActionPerformed
    /**
     * manage the pharma product button
     * @param evt 
     */
    private void managePharmaProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePharmaProductActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  pharmaTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany = (InterNationalPharmaceauticalCompany)pharmaTable.getValueAt(selectedRow, 0);
            ManagePharmaProductJPanel managePharmaProductJPanel =  new ManagePharmaProductJPanel(userProcessContainer,interNationalPharmaceauticalCompany.getProductCatalog(),interNationalPharmaceauticalCompany);
            userProcessContainer.add("ManagePharmaProductJPanel",managePharmaProductJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        } 
        ImplLogger.exitMethod();
    }//GEN-LAST:event_managePharmaProductActionPerformed
     /**
     * validate the fields before submitting
     */
    private boolean validateFields(){
        ImplLogger.enterMethod();
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
        ImplLogger.exitMethod();
        return isValidationPassed;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageLisenceButton;
    private javax.swing.JButton managePharmRequest;
    private javax.swing.JButton managePharmaProduct;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JTextField pharmaIdTextField;
    private javax.swing.JTable pharmaTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton registerPharmaCoButton;
    private javax.swing.JButton searchByIdButton;
    // End of variables declaration//GEN-END:variables
}
