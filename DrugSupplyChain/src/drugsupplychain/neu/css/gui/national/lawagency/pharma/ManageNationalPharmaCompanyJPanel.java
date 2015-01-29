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
package drugsupplychain.neu.css.gui.national.lawagency.pharma;

import drugsupplychain.neu.css.gui.common.panel.RegisterPharmaOrganizationJPanel;
import drugsupplychain.neu.css.gui.common.panel.ManagePharmaCoLisenceJPanel;
import drugsupplychain.neu.css.gui.common.lawAgency.pharma.ManagePharmaProductJPanel;
import drugsupplychain.neu.css.gui.common.lawAgency.pharma.ManagePharmaRequestsJPanel;
import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.organization.Organization.Type;
import drugsupplychain.neu.css.model.organization.lawAgencies.NationalLawAgency;
import drugsupplychain.neu.css.model.organization.pharmacompany.NationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.NationalPharmaceauticalCompanyDirectory;
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
public class ManageNationalPharmaCompanyJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final NationalPharmaceauticalCompanyDirectory nationalPharmaceauticalCompanyDirectory;
    private final NationalLawAgency nationalLawAgency;
    private final String countryName;
    /**
     * Creates new form ManageNationalPharmaCompanyJPanel
     * @param userProcessContainer
     * @param nationalLawAgency
     * @param countryName
     */
    public ManageNationalPharmaCompanyJPanel(JPanel userProcessContainer,NationalLawAgency nationalLawAgency,String countryName) {
        initComponents();
        ImplLogger.enterMethod();
        this.nationalPharmaceauticalCompanyDirectory = nationalLawAgency.getNationalPharmaceauticalCompanyDirectory();
        this.userProcessContainer = userProcessContainer;
        this.countryName = countryName;
        this.nationalLawAgency = nationalLawAgency;
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
        for (NationalPharmaceauticalCompany nationalPharmaceauticalCompany : nationalPharmaceauticalCompanyDirectory.getNationalPharmaceauticalCompanyList()){
            for(WorkRequest workRequest : nationalPharmaceauticalCompany.getWorkQueue().getWorkRequestList()){
                if(workRequest.getStatus().equals(ImplConst.CASE_NEW)){
                    notification++;
                }
            }      
        }
        notificationLabel.setText(String.valueOf(notification));
        ImplLogger.exitMethod();
    }
    /**
     * populate table 
     */
    private void populateTable(){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)pharmaTable.getModel();
        defaultTableModel.setRowCount(0);
        for (NationalPharmaceauticalCompany nationalPharmaceauticalCompany : nationalPharmaceauticalCompanyDirectory.getNationalPharmaceauticalCompanyList()){
            Object[] row = new Object[4];
            row[0] = nationalPharmaceauticalCompany;
            row[1] = nationalPharmaceauticalCompany.getOrganizationID();
            row[2] = nationalPharmaceauticalCompany.getLincense().getLicenseNumber();
            row[3] = nationalPharmaceauticalCompany.getLincense().isIsLicenseValid();
            defaultTableModel.addRow(row);            
        }
        ImplLogger.exitMethod();
    }
    /**
     * populate table
     * @param pharmaId 
     */
    private void populateTable(int pharmaId){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)pharmaTable.getModel();
        defaultTableModel.setRowCount(0);
        for (NationalPharmaceauticalCompany nationalPharmaceauticalCompany : nationalPharmaceauticalCompanyDirectory.getNationalPharmaceauticalCompanyList()){
            if (nationalPharmaceauticalCompany.getOrganizationID()== pharmaId){
                Object[] row = new Object[4];
                row[0] = nationalPharmaceauticalCompany;
                row[1] = nationalPharmaceauticalCompany.getOrganizationID();
                row[2] = nationalPharmaceauticalCompany.getLincense().getLicenseNumber();
                row[3] = nationalPharmaceauticalCompany.getLincense().isIsLicenseValid();
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

        jLabel1 = new javax.swing.JLabel();
        manageLisenceButton = new javax.swing.JButton();
        managePharmaRequest = new javax.swing.JButton();
        registerPharmaButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pharmaTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        pharmaIdTextField = new javax.swing.JTextField();
        searchByIdButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        managePharmaProductButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        notificationLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Manage National Pharama Co.");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        manageLisenceButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageLisenceButton.setText("Manage License ");
        manageLisenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageLisenceButtonActionPerformed(evt);
            }
        });
        add(manageLisenceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 170, 50));

        managePharmaRequest.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        managePharmaRequest.setText("Manage Requests");
        managePharmaRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePharmaRequestActionPerformed(evt);
            }
        });
        add(managePharmaRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, -1, 50));

        registerPharmaButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        registerPharmaButton.setText("Register Pharma Co. ");
        registerPharmaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPharmaButtonActionPerformed(evt);
            }
        });
        add(registerPharmaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 180, 50));

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

        managePharmaProductButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        managePharmaProductButton.setText("Manage Pharma Product");
        managePharmaProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePharmaProductButtonActionPerformed(evt);
            }
        });
        add(managePharmaProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, -1, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.add(notificationLabel);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 20, 20));
    }// </editor-fold>//GEN-END:initComponents
    /**
     * register pharma
     * @param evt 
     */
    private void registerPharmaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPharmaButtonActionPerformed
       ImplLogger.enterMethod();
       RegisterPharmaOrganizationJPanel registerPharmaCOJPanel = new RegisterPharmaOrganizationJPanel(userProcessContainer,nationalPharmaceauticalCompanyDirectory,nationalLawAgency,Type.NATIONAL_PHARMA_CO);
       userProcessContainer.add("RegisterPharmaCOJPanel",registerPharmaCOJPanel);
       CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
       ImplLogger.exitMethod();
    }//GEN-LAST:event_registerPharmaButtonActionPerformed
    /**
     * manage back button
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
     * search by id
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
     * manage license
     * @param evt 
     */
    private void manageLisenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageLisenceButtonActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  pharmaTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            NationalPharmaceauticalCompany nationalPharmaceauticalCompany = (NationalPharmaceauticalCompany)pharmaTable.getValueAt(selectedRow, 0);
            ManagePharmaCoLisenceJPanel managePharmaCoLisenceJPanel =  new ManagePharmaCoLisenceJPanel(userProcessContainer,nationalPharmaceauticalCompany,Type.NATIONAL_PHARMA_CO);
            userProcessContainer.add("ManagePharmaCoLisenceJPanel",managePharmaCoLisenceJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }  
        ImplLogger.exitMethod();
    }//GEN-LAST:event_manageLisenceButtonActionPerformed
    /**
     * manage refresh button
     * @param evt 
     */
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        ImplLogger.enterMethod();
        populateTable();
        populateNotification();
        ImplLogger.exitMethod();
    }//GEN-LAST:event_refreshButtonActionPerformed
    /**
     * manage pharama request
     * @param evt 
     */
    private void managePharmaRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePharmaRequestActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  pharmaTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            NationalPharmaceauticalCompany nationalPharmaceauticalCompany = (NationalPharmaceauticalCompany)pharmaTable.getValueAt(selectedRow, 0);
            ManagePharmaRequestsJPanel managePharmaRequestsJPanel =  new ManagePharmaRequestsJPanel(userProcessContainer,nationalPharmaceauticalCompany);
            userProcessContainer.add("ManagePharmaRequestsJPanel",managePharmaRequestsJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        } 
        ImplLogger.exitMethod();
    }//GEN-LAST:event_managePharmaRequestActionPerformed
    /**
     * manage pharama product
     * @param evt 
     */
    private void managePharmaProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePharmaProductButtonActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  pharmaTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            NationalPharmaceauticalCompany nationalPharmaceauticalCompany = (NationalPharmaceauticalCompany)pharmaTable.getValueAt(selectedRow, 0);
            ManagePharmaProductJPanel managePharmaProductJPanel =  new ManagePharmaProductJPanel(userProcessContainer,nationalPharmaceauticalCompany.getProductCatalog(),nationalPharmaceauticalCompany);
            userProcessContainer.add("ManagePharmaProductJPanel",managePharmaProductJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_managePharmaProductButtonActionPerformed
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageLisenceButton;
    private javax.swing.JButton managePharmaProductButton;
    private javax.swing.JButton managePharmaRequest;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JTextField pharmaIdTextField;
    private javax.swing.JTable pharmaTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton registerPharmaButton;
    private javax.swing.JButton searchByIdButton;
    // End of variables declaration//GEN-END:variables
}
