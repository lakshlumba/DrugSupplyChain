/*
 * Class : RegisterDistributorsJPanel.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 24, 2014, 12:35:13 AM
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
package drugsupplychain.neu.css.gui.city.lawagency;

import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.organization.other.ClinicOrganization;
import drugsupplychain.neu.css.model.organization.other.DispenceryOrganization;
import drugsupplychain.neu.css.model.organization.other.DoctorOrganization;
import drugsupplychain.neu.css.model.organization.other.HospitalOrganization;
import drugsupplychain.neu.css.model.organization.other.PatientOrganization;
import drugsupplychain.neu.css.model.organization.other.PharmacyOrganization;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laksh
 */
public class RegisterExistingPatientJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final Organization organization;
    private final CityLawAgency cityLawAgency;
    /**
     * Creates new form RegisterDistributorsJPanel
     * @param userProcessContainer
     * @param organization
     * @param cityLawAgency
     */
    public RegisterExistingPatientJPanel(JPanel userProcessContainer,Organization organization,CityLawAgency cityLawAgency) {
        initComponents();
        ImplLogger.enterMethod();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.cityLawAgency = cityLawAgency;
        populateRegisteredTable();
        populateUnregisteredTable();
        ImplLogger.exitMethod();
    }
    private void populateRegisteredTable(){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)registerPatientTable.getModel();
        defaultTableModel.setRowCount(0);
        for (PatientOrganization patientOrganization : cityLawAgency.getPatientOrganizationDirectory().getPatientOrganizationList()){
            Object[] row = new Object[4];
            row[0] = patientOrganization.getOrganizationID();
            row[1] = patientOrganization;
            row[2] = patientOrganization.getLocation();
            row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
            defaultTableModel.addRow(row);
        }
        ImplLogger.exitMethod();
    }
    private void populateUnregisteredTable(){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)unregisterPatientTable.getModel();
        defaultTableModel.setRowCount(0);
        if(organization instanceof PharmacyOrganization){
            PharmacyOrganization pharmacyOrganization = (PharmacyOrganization)organization;
            for (PatientOrganization patientOrganization : pharmacyOrganization.getPatientOrganizationDirectory().getPatientOrganizationList()){
                Object[] row = new Object[4];
                row[0] = patientOrganization.getOrganizationID();
                row[1] = patientOrganization;
                row[2] = patientOrganization.getLocation();
                row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
                defaultTableModel.addRow(row);
            }
        }   else if(organization instanceof DispenceryOrganization){
            DispenceryOrganization dispenceryOrganization = (DispenceryOrganization)organization;
            for (PatientOrganization patientOrganization : dispenceryOrganization.getPatientOrganizationDirectory().getPatientOrganizationList()){
                Object[] row = new Object[4];
                row[0] = patientOrganization.getOrganizationID();
                row[1] = patientOrganization;
                row[2] = patientOrganization.getLocation();
                row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
                defaultTableModel.addRow(row);
            }
        }   else if(organization instanceof HospitalOrganization){
            HospitalOrganization hospitalOrganization = (HospitalOrganization)organization;
            for (PatientOrganization patientOrganization : hospitalOrganization.getPatientOrganizationDirectory().getPatientOrganizationList()){
                Object[] row = new Object[4];
                row[0] = patientOrganization.getOrganizationID();
                row[1] = patientOrganization;
                row[2] = patientOrganization.getLocation();
                row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
                defaultTableModel.addRow(row);
            }
        }   else if(organization instanceof ClinicOrganization){
            ClinicOrganization clinicOrganization = (ClinicOrganization)organization;
            for (PatientOrganization patientOrganization : clinicOrganization.getPatientOrganizationDirectory().getPatientOrganizationList()){
                Object[] row = new Object[4];
                row[0] = patientOrganization.getOrganizationID();
                row[1] = patientOrganization;
                row[2] = patientOrganization.getLocation();
                row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
                defaultTableModel.addRow(row);
            }
        }   else if(organization instanceof DoctorOrganization){
            DoctorOrganization doctorOrganization = (DoctorOrganization)organization;
            for (PatientOrganization patientOrganization : doctorOrganization.getPatientOrganizationDirectory().getPatientOrganizationList()){
                Object[] row = new Object[4];
                row[0] = patientOrganization.getOrganizationID();
                row[1] = patientOrganization;
                row[2] = patientOrganization.getLocation();
                row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
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
        backButton = new javax.swing.JButton();
        registerDistributor = new javax.swing.JButton();
        unregisterDistributor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        registerPatientTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        unregisterPatientTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Register Patient");

        backButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        registerDistributor.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        registerDistributor.setText("Register Distributor");
        registerDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerDistributorActionPerformed(evt);
            }
        });

        unregisterDistributor.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        unregisterDistributor.setText("Unregistered Distributor");
        unregisterDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unregisterDistributorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Unregister Register");

        registerPatientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "Under Organization", "Patient Address"
            }
        ));
        jScrollPane3.setViewportView(registerPatientTable);

        unregisterPatientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "Under Organization", "Patient Address"
            }
        ));
        jScrollPane1.setViewportView(unregisterPatientTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(registerDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(unregisterDistributor))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(registerDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unregisterDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ImplLogger.enterMethod();
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_backButtonActionPerformed

    private void registerDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerDistributorActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  registerPatientTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            if(organization instanceof PharmacyOrganization){
                    ImplLogger.info("organization : PharmacyOrganization");
                    PatientOrganization patientOrganization = (PatientOrganization)registerPatientTable.getValueAt(selectedRow, 1);
                    PharmacyOrganization pharmacyOrganization = (PharmacyOrganization)organization;
                    if(null == pharmacyOrganization.getPatientOrganizationDirectory().searchPatientOrganization(patientOrganization.getOrganizationID())){
                        pharmacyOrganization.getPatientOrganizationDirectory().addPatientOrganization(patientOrganization);
                    } else {
                        JOptionPane.showMessageDialog(null, "Patient Already exist"); 
                    }
            }   else if(organization instanceof DispenceryOrganization){
                    ImplLogger.info("organization : DispenceryOrganization");
                    PatientOrganization patientOrganization = (PatientOrganization)registerPatientTable.getValueAt(selectedRow, 1);
                    DispenceryOrganization dispenceryOrganization = (DispenceryOrganization)organization;
                    if(null == dispenceryOrganization.getPatientOrganizationDirectory().searchPatientOrganization(patientOrganization.getOrganizationID())){
                        dispenceryOrganization.getPatientOrganizationDirectory().addPatientOrganization(patientOrganization);
                    } else {
                        JOptionPane.showMessageDialog(null, "Patient Already exist"); 
                    }
            }   else if(organization instanceof HospitalOrganization){
                    ImplLogger.info("organization : HospitalOrganization");
                    PatientOrganization patientOrganization = (PatientOrganization)registerPatientTable.getValueAt(selectedRow, 1);
                    HospitalOrganization hospitalOrganization = (HospitalOrganization)organization;
                    if(null == hospitalOrganization.getPatientOrganizationDirectory().searchPatientOrganization(patientOrganization.getOrganizationID())){
                        hospitalOrganization.getPatientOrganizationDirectory().addPatientOrganization(patientOrganization);
                    } else {
                        JOptionPane.showMessageDialog(null, "Patient Already exist"); 
                    }
            }   else if(organization instanceof ClinicOrganization){
                    ImplLogger.info("organization : ClinicOrganization");
                    PatientOrganization patientOrganization = (PatientOrganization)registerPatientTable.getValueAt(selectedRow, 1);
                    ClinicOrganization clinicOrganization = (ClinicOrganization)organization;
                    if(null == clinicOrganization.getPatientOrganizationDirectory().searchPatientOrganization(patientOrganization.getOrganizationID())){
                        clinicOrganization.getPatientOrganizationDirectory().addPatientOrganization(patientOrganization);
                    } else {
                        JOptionPane.showMessageDialog(null, "Patient Already exist"); 
                    }
            }   else if(organization instanceof DoctorOrganization){
                    ImplLogger.info("organization : DoctorOrganization");
                    PatientOrganization patientOrganization = (PatientOrganization)registerPatientTable.getValueAt(selectedRow, 1);
                    DoctorOrganization doctorOrganization = (DoctorOrganization)organization;
                    if(null == doctorOrganization.getPatientOrganizationDirectory().searchPatientOrganization(patientOrganization.getOrganizationID())){
                        doctorOrganization.getPatientOrganizationDirectory().addPatientOrganization(patientOrganization);
                    } else {
                        JOptionPane.showMessageDialog(null, "Patient Already exist"); 
                    }
            }
            populateRegisteredTable();
            populateUnregisteredTable();
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_registerDistributorActionPerformed

    private void unregisterDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unregisterDistributorActionPerformed
        int selectedRow =  unregisterPatientTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            PatientOrganization patientOrganization = (PatientOrganization)registerPatientTable.getValueAt(selectedRow, 1);
            if(organization instanceof PharmacyOrganization){
                ImplLogger.info("organization : PharmacyOrganization");                
                PharmacyOrganization pharmacyOrganization = (PharmacyOrganization)organization;
                pharmacyOrganization.getPatientOrganizationDirectory().removePatientOrganization(patientOrganization);

            }   else if(organization instanceof DispenceryOrganization){
                    ImplLogger.info("organization : DispenceryOrganization");                
                    DispenceryOrganization dispenceryOrganization = (DispenceryOrganization)organization;
                    dispenceryOrganization.getPatientOrganizationDirectory().removePatientOrganization(patientOrganization);

            }   else if(organization instanceof HospitalOrganization){
                    ImplLogger.info("organization : HospitalOrganization");                
                    HospitalOrganization hospitalOrganization = (HospitalOrganization)organization;
                    hospitalOrganization.getPatientOrganizationDirectory().removePatientOrganization(patientOrganization);
            }   else if(organization instanceof ClinicOrganization){
                    ImplLogger.info("organization : ClinicOrganization");                
                    ClinicOrganization clinicOrganization = (ClinicOrganization)organization;
                    clinicOrganization.getPatientOrganizationDirectory().removePatientOrganization(patientOrganization);
            }   else if(organization instanceof DoctorOrganization){
                    ImplLogger.info("organization : DoctorOrganization");                
                    DoctorOrganization doctorOrganization = (DoctorOrganization)organization;
                    doctorOrganization.getPatientOrganizationDirectory().removePatientOrganization(patientOrganization);
            }
            populateRegisteredTable();
            populateUnregisteredTable();
        }
    }//GEN-LAST:event_unregisterDistributorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton registerDistributor;
    private javax.swing.JTable registerPatientTable;
    private javax.swing.JButton unregisterDistributor;
    private javax.swing.JTable unregisterPatientTable;
    // End of variables declaration//GEN-END:variables
}
