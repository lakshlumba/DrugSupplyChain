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
package drugsupplychain.neu.css.gui.city.lawagency.pharmacies;

import drugsupplychain.neu.css.gui.city.lawagency.ManageOrganizationRequestJPanel;
import drugsupplychain.neu.css.gui.city.lawagency.ManageRequestAgainstMedicationJPanel;
import drugsupplychain.neu.css.gui.common.panel.ManagePharmaCoLisenceJPanel;
import drugsupplychain.neu.css.gui.common.panel.RegisterPharmaOrganizationJPanel;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.Organization.Type;
import drugsupplychain.neu.css.model.organization.OrganizationDirectory;
import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.organization.other.PharmacyOrganization;
import drugsupplychain.neu.css.model.request.DrugCaseRequest;
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
public class ManageCityPharmaciesJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final CityLawAgency cityLawAgency;
    private final OrganizationDirectory organizationDirectory;
    /**
     * Creates new form ManageStateDistributorsJPanel
     * @param userProcessContainer
     * @param cityLawAgency
     */
    public ManageCityPharmaciesJPanel(JPanel userProcessContainer,CityLawAgency cityLawAgency) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.cityLawAgency = cityLawAgency;
        this.organizationDirectory = cityLawAgency.getOrganizationDirectory();
        populateTable();
        populateNotification();
    }
    private void populateNotification(){
        int notification = 0;
        int notificationReportAgainst = 0;
            for (PharmacyOrganization pharmacyOrganization : cityLawAgency.getPharmacyOrganizationDirectory().getPharmacyOrganizationList()){
                for(WorkRequest workRequest : pharmacyOrganization.getWorkQueue().getWorkRequestList()){
                    if(workRequest.getStatus().equals(ImplConst.CASE_NEW)){
                        if (workRequest instanceof DrugCaseRequest){                            
                            notificationReportAgainst++;
                        } else {
                            notification++;
                        }
                    }
                }      
            }
        notificationLabel.setText(String.valueOf(notification));
        medicationReportLabel.setText(String.valueOf(notificationReportAgainst));
    }    
    private void populateTable(){
        DefaultTableModel defaultTableModel = (DefaultTableModel)hospitalTable.getModel();
        defaultTableModel.setRowCount(0);
         for (PharmacyOrganization pharmacyOrganization : cityLawAgency.getPharmacyOrganizationDirectory().getPharmacyOrganizationList()){
                Object[] row = new Object[5];
                row[0] = pharmacyOrganization.getOrganizationID();
                row[1] = pharmacyOrganization;
                row[2] = cityLawAgency.getLocation();
                row[3] = pharmacyOrganization.getLincense().getLicenseNumber();
                row[4] = pharmacyOrganization.getLincense().isIsLicenseValid();
                defaultTableModel.addRow(row);
        }
    }
    
    private void populateTable(int pharmaId){
        DefaultTableModel defaultTableModel = (DefaultTableModel)hospitalTable.getModel();
        defaultTableModel.setRowCount(0);
        for (PharmacyOrganization pharmacyOrganization : cityLawAgency.getPharmacyOrganizationDirectory().getPharmacyOrganizationList()){
            if (pharmacyOrganization.getOrganizationID() == pharmaId){ 
                Object[] row = new Object[5];
                row[0] = pharmacyOrganization.getOrganizationID();
                row[1] = pharmacyOrganization;
                row[2] = cityLawAgency.getLocation();
                row[3] = pharmacyOrganization.getLincense().getLicenseNumber();
                row[4] = pharmacyOrganization.getLincense().isIsLicenseValid();
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
        manageLisence = new javax.swing.JButton();
        manageRequest = new javax.swing.JButton();
        registerPharmacy = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        hospitalTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        pharmaIdTextField = new javax.swing.JTextField();
        searchByIdButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        notificationLabel = new javax.swing.JLabel();
        manageRequest1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        medicationReportLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Manage City Pharmacies");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 230, -1));

        manageLisence.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageLisence.setText("Manage License ");
        manageLisence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageLisenceActionPerformed(evt);
            }
        });
        add(manageLisence, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, 170, 50));

        manageRequest.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageRequest.setText("Manage Requests");
        manageRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRequestActionPerformed(evt);
            }
        });
        add(manageRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, 50));

        registerPharmacy.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        registerPharmacy.setText("Register Pharmacy");
        registerPharmacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPharmacyActionPerformed(evt);
            }
        });
        add(registerPharmacy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 180, 50));

        hospitalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hospital ID", "Hospital Name", "State Name ", "License Number", "Is License Valid"
            }
        ));
        jScrollPane1.setViewportView(hospitalTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 900, 160));

        backButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 110, 40));
        add(pharmaIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 120, 30));

        searchByIdButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        searchByIdButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/searchicon.png"))); // NOI18N
        searchByIdButton.setText("Search By Id");
        searchByIdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByIdButtonActionPerformed(evt);
            }
        });
        add(searchByIdButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, 30));

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

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 20, 20));

        manageRequest1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageRequest1.setText("Manage Request Against Medication");
        manageRequest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRequest1ActionPerformed(evt);
            }
        });
        add(manageRequest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 280, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));
        jPanel2.add(medicationReportLabel);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, 20, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void registerPharmacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPharmacyActionPerformed
       RegisterPharmaOrganizationJPanel registerPharmaOrganizationJPanel = new RegisterPharmaOrganizationJPanel(userProcessContainer,organizationDirectory,cityLawAgency,Organization.Type.PHARMACY);
       userProcessContainer.add("RegisterPharmaOrganizationJPanel",registerPharmaOrganizationJPanel);
       CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_registerPharmacyActionPerformed

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

    private void manageLisenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageLisenceActionPerformed
        int selectedRow =  hospitalTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            PharmacyOrganization pharmacyOrganization = (PharmacyOrganization)hospitalTable.getValueAt(selectedRow, 1);
            ManagePharmaCoLisenceJPanel managePharmaCoLisenceJPanel =  new ManagePharmaCoLisenceJPanel(userProcessContainer,pharmacyOrganization,Type.HOSPITAL);
            userProcessContainer.add("ManagePharmaCoLisenceJPanel",managePharmaCoLisenceJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }  
    }//GEN-LAST:event_manageLisenceActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        populateTable();
        populateNotification();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void manageRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRequestActionPerformed
        int selectedRow =  hospitalTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            PharmacyOrganization pharmacyOrganization = (PharmacyOrganization)hospitalTable.getValueAt(selectedRow, 1);
            ManageOrganizationRequestJPanel manageOrganizationRequestJPanel =  new ManageOrganizationRequestJPanel(userProcessContainer,pharmacyOrganization);
            userProcessContainer.add("ManageRequestsJPanel",manageOrganizationRequestJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }  
    }//GEN-LAST:event_manageRequestActionPerformed

    private void manageRequest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRequest1ActionPerformed
        int selectedRow =  hospitalTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            PharmacyOrganization pharmacyOrganization = (PharmacyOrganization)hospitalTable.getValueAt(selectedRow, 1);
            ManageRequestAgainstMedicationJPanel manageRequestAgainstMedicationJPanel =  new ManageRequestAgainstMedicationJPanel(userProcessContainer,pharmacyOrganization,cityLawAgency);
            userProcessContainer.add("ManageRequestAgainstMedicationJPanel",manageRequestAgainstMedicationJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }
    }//GEN-LAST:event_manageRequest1ActionPerformed
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
    private javax.swing.JTable hospitalTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageLisence;
    private javax.swing.JButton manageRequest;
    private javax.swing.JButton manageRequest1;
    private javax.swing.JLabel medicationReportLabel;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JTextField pharmaIdTextField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton registerPharmacy;
    private javax.swing.JButton searchByIdButton;
    // End of variables declaration//GEN-END:variables
}
