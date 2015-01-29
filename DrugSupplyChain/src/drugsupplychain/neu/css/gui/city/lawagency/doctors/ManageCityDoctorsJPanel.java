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
package drugsupplychain.neu.css.gui.city.lawagency.doctors;

import drugsupplychain.neu.css.gui.city.lawagency.ManageOrganizationRequestJPanel;
import drugsupplychain.neu.css.gui.city.lawagency.ManageRequestAgainstMedicationJPanel;
import drugsupplychain.neu.css.gui.common.panel.ManagePharmaCoLisenceJPanel;
import drugsupplychain.neu.css.gui.common.panel.RegisterPharmaOrganizationJPanel;
import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.Organization.Type;
import drugsupplychain.neu.css.model.organization.OrganizationDirectory;
import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.organization.other.DoctorOrganization;
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
public class ManageCityDoctorsJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final CityLawAgency cityLawAgency;
    private final OrganizationDirectory organizationDirectory;
    /**
     * Creates new form ManageStateDistributorsJPanel
     * @param userProcessContainer
     * @param cityLawAgency
     */
    public ManageCityDoctorsJPanel(JPanel userProcessContainer,CityLawAgency cityLawAgency) {
        initComponents();
        ImplLogger.enterMethod();
        this.userProcessContainer = userProcessContainer;
        this.cityLawAgency = cityLawAgency;
        this.organizationDirectory = cityLawAgency.getOrganizationDirectory();
        ImplLogger.exitMethod();
        populateTable();
        populateNotification();
    }
    /**
     * populate  notification
     */
    private void populateNotification(){
        ImplLogger.enterMethod();
        int notification = 0;
            for (DoctorOrganization doctorOrganization : cityLawAgency.getDoctorOrganizationDirectory().getDoctorOrganizationList()){
                for(WorkRequest workRequest : doctorOrganization.getWorkQueue().getWorkRequestList()){
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
        DefaultTableModel defaultTableModel = (DefaultTableModel)hospitalTable.getModel();
        defaultTableModel.setRowCount(0);
        for (DoctorOrganization doctorOrganization : cityLawAgency.getDoctorOrganizationDirectory().getDoctorOrganizationList()){
            Object[] row = new Object[5];
            row[0] = doctorOrganization.getOrganizationID();
            row[1] = doctorOrganization;
            row[2] = cityLawAgency.getLocation();
            row[3] = doctorOrganization.getLincense().getLicenseNumber();
            row[4] = doctorOrganization.getLincense().isIsLicenseValid();
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
        DefaultTableModel defaultTableModel = (DefaultTableModel)hospitalTable.getModel();
        defaultTableModel.setRowCount(0);
        for (DoctorOrganization doctorOrganization : cityLawAgency.getDoctorOrganizationDirectory().getDoctorOrganizationList()){
            if (doctorOrganization.getOrganizationID() == pharmaId){ 
                Object[] row = new Object[5];
                row[0] = doctorOrganization.getOrganizationID();
                row[1] = doctorOrganization;
                row[2] = cityLawAgency.getLocation();
                row[3] = doctorOrganization.getLincense().getLicenseNumber();
                row[4] = doctorOrganization.getLincense().isIsLicenseValid();
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
        manageLisence = new javax.swing.JButton();
        manageRequest = new javax.swing.JButton();
        registerDoctors = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        hospitalTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        pharmaIdTextField = new javax.swing.JTextField();
        searchByIdButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        notificationLabel = new javax.swing.JLabel();
        manageRequestAgainstMedication = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Manage City Doctors");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 230, -1));

        manageLisence.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageLisence.setText("Manage License ");
        manageLisence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageLisenceActionPerformed(evt);
            }
        });
        add(manageLisence, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 170, 50));

        manageRequest.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageRequest.setText("Manage Requests");
        manageRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRequestActionPerformed(evt);
            }
        });
        add(manageRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, -1, 50));

        registerDoctors.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        registerDoctors.setText("Register Doctors");
        registerDoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerDoctorsActionPerformed(evt);
            }
        });
        add(registerDoctors, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 180, 50));

        hospitalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor  ID", "DoctorName", "City Name ", "License Number", "Is License Valid"
            }
        ));
        jScrollPane1.setViewportView(hospitalTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 870, 160));

        backButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 110, 40));
        add(pharmaIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 120, 30));

        searchByIdButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        searchByIdButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/searchicon.png"))); // NOI18N
        searchByIdButton.setText("Search By Id");
        searchByIdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByIdButtonActionPerformed(evt);
            }
        });
        add(searchByIdButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, -1, 30));

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

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 20, 20));

        manageRequestAgainstMedication.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageRequestAgainstMedication.setText("Manage Request Against Medication");
        manageRequestAgainstMedication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRequestAgainstMedicationActionPerformed(evt);
            }
        });
        add(manageRequestAgainstMedication, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 280, 50));
    }// </editor-fold>//GEN-END:initComponents
    /**
     * register doctors
     * @param evt 
     */
    private void registerDoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerDoctorsActionPerformed
       ImplLogger.enterMethod();
       RegisterPharmaOrganizationJPanel registerPharmaOrganizationJPanel = new RegisterPharmaOrganizationJPanel(userProcessContainer,organizationDirectory,cityLawAgency,Organization.Type.DOCTOR);
       userProcessContainer.add("RegisterPharmaOrganizationJPanel",registerPharmaOrganizationJPanel);
       CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
       ImplLogger.exitMethod();
    }//GEN-LAST:event_registerDoctorsActionPerformed
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
    private void manageLisenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageLisenceActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  hospitalTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            DoctorOrganization doctorOrganization = (DoctorOrganization)hospitalTable.getValueAt(selectedRow, 1);
            ManagePharmaCoLisenceJPanel managePharmaCoLisenceJPanel =  new ManagePharmaCoLisenceJPanel(userProcessContainer,doctorOrganization,Type.DOCTOR);
            userProcessContainer.add("ManageOrganizationLisenceJPanel",managePharmaCoLisenceJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_manageLisenceActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        ImplLogger.enterMethod();
        populateTable();
        populateNotification();
        ImplLogger.exitMethod();
    }//GEN-LAST:event_refreshButtonActionPerformed
    /**
     * 
     * @param evt 
     */
    private void manageRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRequestActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  hospitalTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            DoctorOrganization doctorOrganization = (DoctorOrganization)hospitalTable.getValueAt(selectedRow, 1);
            ManageOrganizationRequestJPanel manageOrganizationRequestJPanel =  new ManageOrganizationRequestJPanel(userProcessContainer,doctorOrganization);
            userProcessContainer.add("ManageRequestsJPanel",manageOrganizationRequestJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }  
        ImplLogger.exitMethod();
    }//GEN-LAST:event_manageRequestActionPerformed
    /**
     * manageRequestAgainstMedicationActionPerformed
     * @param evt 
     */
    private void manageRequestAgainstMedicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRequestAgainstMedicationActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  hospitalTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            DoctorOrganization doctorOrganization = (DoctorOrganization)hospitalTable.getValueAt(selectedRow, 1);
            ManageRequestAgainstMedicationJPanel manageRequestAgainstMedicationJPanel =  new ManageRequestAgainstMedicationJPanel(userProcessContainer,doctorOrganization,cityLawAgency);
            userProcessContainer.add("ManageRequestAgainstMedicationJPanel",manageRequestAgainstMedicationJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_manageRequestAgainstMedicationActionPerformed
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageLisence;
    private javax.swing.JButton manageRequest;
    private javax.swing.JButton manageRequestAgainstMedication;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JTextField pharmaIdTextField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton registerDoctors;
    private javax.swing.JButton searchByIdButton;
    // End of variables declaration//GEN-END:variables
}
