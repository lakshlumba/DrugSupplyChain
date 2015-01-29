/*
 * Class : ManageCityPatientJPanel.java
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
package drugsupplychain.neu.css.gui.city.lawagency;


import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.organization.other.ClinicOrganization;
import drugsupplychain.neu.css.model.organization.other.DispenceryOrganization;
import drugsupplychain.neu.css.model.organization.other.DoctorOrganization;
import drugsupplychain.neu.css.model.organization.other.HospitalOrganization;
import drugsupplychain.neu.css.model.organization.other.PatientOrganization;
import drugsupplychain.neu.css.model.organization.other.PharmacyOrganization;
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
public class ManageCityPatientJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final CityLawAgency cityLawAgency;
    private final Organization organization;
    /**
     * Creates new form ManageCityPatientJPanel
     * @param userProcessContainer
     * @param organization
     * @param cityLawAgency
     */
    public ManageCityPatientJPanel(JPanel userProcessContainer,Organization organization,CityLawAgency cityLawAgency) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.cityLawAgency = cityLawAgency;
        this.organization = organization;
        populateTable();
        populateNotification();
        enablePatientFunction();
    }
    /**
     * enablePatientFunction
     */
    private void enablePatientFunction(){
        if (organization instanceof CityLawAgency){
            registerNewPatient.setEnabled(false);
            registerExistingPatient.setEnabled(false);
            
        }   else if(organization instanceof PharmacyOrganization || organization instanceof DoctorOrganization || organization instanceof DispenceryOrganization
                || organization instanceof HospitalOrganization || organization instanceof ClinicOrganization){
            manageRequest.setEnabled(false);
        }
    }
    private void populateNotification(){
        int notification = 0;
            for (PatientOrganization patientOrganization : cityLawAgency.getPatientOrganizationDirectory().getPatientOrganizationList()){
                for(WorkRequest workRequest : patientOrganization.getWorkQueue().getWorkRequestList()){
                    if(workRequest.getStatus().equals(ImplConst.CASE_NEW)){
                        notification++;
                    }
                }      
            }
        notificationLabel.setText(String.valueOf(notification));
    }
    private void populateTable(){
        DefaultTableModel defaultTableModel = (DefaultTableModel)patientTable.getModel();
        defaultTableModel.setRowCount(0);
        if (organization instanceof CityLawAgency){
            CityLawAgency cityLawAgency1 = (CityLawAgency)organization;
            for (PatientOrganization patientOrganization : cityLawAgency1.getPatientOrganizationDirectory().getPatientOrganizationList()){
                Object[] row = new Object[4];
                row[0] = patientOrganization.getOrganizationID();
                row[1] = patientOrganization;
                row[2] = patientOrganization.getLocation();
                row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
                defaultTableModel.addRow(row);
            }
        }   else if(organization instanceof PharmacyOrganization){
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
    }
    
    private void populateTable(int pharmaId){
        DefaultTableModel defaultTableModel = (DefaultTableModel)patientTable.getModel();
        defaultTableModel.setRowCount(0);
        if (organization instanceof CityLawAgency){
            CityLawAgency cityLawAgency1 = (CityLawAgency)organization;
            for (PatientOrganization patientOrganization : cityLawAgency1.getPatientOrganizationDirectory().getPatientOrganizationList()){
                if (patientOrganization.getOrganizationID() == pharmaId){
                    Object[] row = new Object[4];
                    row[0] = patientOrganization.getOrganizationID();
                    row[1] = patientOrganization;
                    row[2] = patientOrganization.getLocation();
                    row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
                    defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof PharmacyOrganization){
            PharmacyOrganization pharmacyOrganization = (PharmacyOrganization)organization;
            for (PatientOrganization patientOrganization : pharmacyOrganization.getPatientOrganizationDirectory().getPatientOrganizationList()){
                if (patientOrganization.getOrganizationID() == pharmaId){
                    Object[] row = new Object[4];
                    row[0] = patientOrganization.getOrganizationID();
                    row[1] = patientOrganization;
                    row[2] = patientOrganization.getLocation();
                    row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
                    defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof DispenceryOrganization){
            DispenceryOrganization dispenceryOrganization = (DispenceryOrganization)organization;
            for (PatientOrganization patientOrganization : dispenceryOrganization.getPatientOrganizationDirectory().getPatientOrganizationList()){
                if (patientOrganization.getOrganizationID() == pharmaId){
                    Object[] row = new Object[4];
                    row[0] = patientOrganization.getOrganizationID();
                    row[1] = patientOrganization;
                    row[2] = patientOrganization.getLocation();
                    row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
                    defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof HospitalOrganization){
            HospitalOrganization hospitalOrganization = (HospitalOrganization)organization;
            for (PatientOrganization patientOrganization : hospitalOrganization.getPatientOrganizationDirectory().getPatientOrganizationList()){
                if (patientOrganization.getOrganizationID() == pharmaId){
                    Object[] row = new Object[4];
                    row[0] = patientOrganization.getOrganizationID();
                    row[1] = patientOrganization;
                    row[2] = patientOrganization.getLocation();
                    row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
                    defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof ClinicOrganization){
            ClinicOrganization clinicOrganization = (ClinicOrganization)organization;
            for (PatientOrganization patientOrganization : clinicOrganization.getPatientOrganizationDirectory().getPatientOrganizationList()){
                if (patientOrganization.getOrganizationID() == pharmaId){
                    Object[] row = new Object[4];
                    row[0] = patientOrganization.getOrganizationID();
                    row[1] = patientOrganization;
                    row[2] = patientOrganization.getLocation();
                    row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
                    defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof DoctorOrganization){
            DoctorOrganization doctorOrganization = (DoctorOrganization)organization;
            for (PatientOrganization patientOrganization : doctorOrganization.getPatientOrganizationDirectory().getPatientOrganizationList()){
                if (patientOrganization.getOrganizationID() == pharmaId){
                    Object[] row = new Object[4];
                    row[0] = patientOrganization.getOrganizationID();
                    row[1] = patientOrganization;
                    row[2] = patientOrganization.getLocation();
                    row[3] = patientOrganization.getPersonDirectory().getPersonList().get(0).getAddress();
                    defaultTableModel.addRow(row);
                }
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
        manageRequest = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        pharmaIdTextField = new javax.swing.JTextField();
        searchByIdButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        notificationLabel = new javax.swing.JLabel();
        viewPatientDetails = new javax.swing.JButton();
        registerExistingPatient = new javax.swing.JButton();
        registerNewPatient = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Manage City Patient");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 230, -1));

        manageRequest.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageRequest.setText("Manage Request Against Medication");
        manageRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRequestActionPerformed(evt);
            }
        });
        add(manageRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, -1, 50));

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "Under Organization", "Patient Address"
            }
        ));
        jScrollPane1.setViewportView(patientTable);
        if (patientTable.getColumnModel().getColumnCount() > 0) {
            patientTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            patientTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 830, 160));

        backButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 110, 40));
        add(pharmaIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 120, 40));

        searchByIdButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        searchByIdButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/searchicon.png"))); // NOI18N
        searchByIdButton.setText("Search By Id");
        searchByIdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByIdButtonActionPerformed(evt);
            }
        });
        add(searchByIdButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, -1, 40));

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

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 20, 20));

        viewPatientDetails.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        viewPatientDetails.setText("View Patient Details");
        viewPatientDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPatientDetailsActionPerformed(evt);
            }
        });
        add(viewPatientDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 170, 50));

        registerExistingPatient.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        registerExistingPatient.setText("Register Exiting Patient");
        registerExistingPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerExistingPatientActionPerformed(evt);
            }
        });
        add(registerExistingPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 190, 50));

        registerNewPatient.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        registerNewPatient.setText("Register New Patient");
        registerNewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerNewPatientActionPerformed(evt);
            }
        });
        add(registerNewPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 170, 50));
    }// </editor-fold>//GEN-END:initComponents

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

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        populateTable();
        populateNotification();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void manageRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRequestActionPerformed
        int selectedRow =  patientTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            PatientOrganization patientOrganization = (PatientOrganization)patientTable.getValueAt(selectedRow, 1);
            ManageRequestAgainstMedicationJPanel manageRequestAgainstMedicationJPanel =  new ManageRequestAgainstMedicationJPanel(userProcessContainer,patientOrganization,cityLawAgency);
            userProcessContainer.add("ManageRequestAgainstMedicationJPanel",manageRequestAgainstMedicationJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }  
    }//GEN-LAST:event_manageRequestActionPerformed

    private void viewPatientDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPatientDetailsActionPerformed
        int selectedRow =  patientTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            PatientOrganization patientOrganization = (PatientOrganization)patientTable.getValueAt(selectedRow, 1);
            ViewPatientDetailsJPanel viewPatientDetailsJPanel =  new ViewPatientDetailsJPanel(userProcessContainer,patientOrganization);
            userProcessContainer.add("ViewPatientDetailsJPanel",viewPatientDetailsJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }
    }//GEN-LAST:event_viewPatientDetailsActionPerformed

    private void registerExistingPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerExistingPatientActionPerformed
        RegisterExistingPatientJPanel registerExistingPatientJPanel =  new RegisterExistingPatientJPanel(userProcessContainer,organization,cityLawAgency);
        userProcessContainer.add("RegisterExistingPatientJPanel",registerExistingPatientJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_registerExistingPatientActionPerformed

    private void registerNewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerNewPatientActionPerformed
        RegisterPatientJPanel registerPatientJPanel =  new RegisterPatientJPanel(userProcessContainer,organization,cityLawAgency);
        userProcessContainer.add("RegisterPatientJPanel",registerPatientJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_registerNewPatientActionPerformed
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageRequest;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JTable patientTable;
    private javax.swing.JTextField pharmaIdTextField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton registerExistingPatient;
    private javax.swing.JButton registerNewPatient;
    private javax.swing.JButton searchByIdButton;
    private javax.swing.JButton viewPatientDetails;
    // End of variables declaration//GEN-END:variables
}
