/*
 * Class : ManagePharmaCoLisenceJPanel.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 12, 2014, 9:43:45 PM
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
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.Organization.Type;
import drugsupplychain.neu.css.util.ImplConst;
import java.awt.CardLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Laksh
 */
public class ManagePharmaCoLisenceJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final Organization organization;
    private final Type type;
    /**
     * Creates new form ManagePharmaCoLisenceJPanel
     * @param userProcessContainer
     * @param organization
     * @param type
     */
    public ManagePharmaCoLisenceJPanel(JPanel userProcessContainer,Organization organization,Type type) {
        initComponents();
        ImplLogger.enterMethod();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.type = type;
        populateLisenceValues();
        populateLabels();
        ImplLogger.exitMethod();
    }
    /**
     * populate the label according to the type of organization 
     */
    private void populateLabels(){
        ImplLogger.enterMethod();
        ImplLogger.info("Type of oganization : " + type.getValue());
        if (type.getValue().equals(Type.INTER_PHARMA_CO.getValue())){
            heading1Text.setText(ImplConst.INTER);
            heading2Text.setText(ImplConst.PHARMA_LABEL);
            regionalLabel.setText(ImplConst.INTER_LABEL);
            regionName.setText(ImplConst.INTER_LABEL);
        } else if (type.getValue().equals(Type.REGIONAL_PHARMA_CO.getValue())){
            heading1Text.setText(ImplConst.REGIONAL_LABEL);
            heading2Text.setText(ImplConst.PHARMA_LABEL);
            regionalLabel.setText(ImplConst.REGIONAL_LABEL);
            regionName.setText(organization.getName());
        } else if (type.getValue().equals(Type.NATIONAL_PHARMA_CO.getValue())){
            heading1Text.setText(ImplConst.NATIONAL_LABEL);
            heading2Text.setText(ImplConst.PHARMA_LABEL);
            regionalLabel.setText(ImplConst.NATIONAL_LABEL);
            regionName.setText(organization.getName());    
        } else if (type.getValue().equals(Type.STATE_PHARMA_CO.getValue())){
            heading1Text.setText(ImplConst.STATE_LABEL);
            heading2Text.setText(ImplConst.PHARMA_LABEL);
            regionalLabel.setText(ImplConst.STATE_LABEL);
            regionName.setText(organization.getName());    
        } else if (type.getValue().equals(Type.REGIONAL_DISTRIBUTOR.getValue())){
            heading1Text.setText(ImplConst.REGIONAL_LABEL);
            heading2Text.setText(ImplConst.DISTRIBUTOR_LABEL);
            regionalLabel.setText(ImplConst.REGIONAL_LABEL);
            regionName.setText(organization.getName());    
        } else if (type.getValue().equals(Type.NATIONAL_DISTRIBUTOR.getValue())){
            heading1Text.setText(ImplConst.NATIONAL_LABEL);
            heading2Text.setText(ImplConst.DISTRIBUTOR_LABEL);
            regionalLabel.setText(ImplConst.NATIONAL_LABEL);
            regionName.setText(organization.getName());    
        } else if (type.getValue().equals(Type.STATE_DISTRIBUTOR.getValue())){
            heading1Text.setText(ImplConst.STATE_LABEL);
            heading2Text.setText(ImplConst.DISTRIBUTOR_LABEL);
            regionalLabel.setText(ImplConst.STATE_LABEL);
            regionName.setText(organization.getName());    
        } else if (type.getValue().equals(Type.CITY_DISTRIBUTOR.getValue())){
            heading1Text.setText(ImplConst.CITY_LABEL);
            heading2Text.setText(ImplConst.DISTRIBUTOR_LABEL);
            regionalLabel.setText(ImplConst.CITY_LABEL);
            regionName.setText(organization.getName());    
        } else if (type.getValue().equals(Type.CLINIC.getValue())){
            heading1Text.setText(ImplConst.CITY_LABEL);
            heading2Text.setText(ImplConst.CLINIC_LABEL);
            regionalLabel.setText(ImplConst.CITY_LABEL);
            regionName.setText(organization.getName());    
        } else if (type.getValue().equals(Type.PHARMACY.getValue())){
            heading1Text.setText(ImplConst.CITY_LABEL);
            heading2Text.setText(ImplConst.PHARMACY_LABEL);
            regionalLabel.setText(ImplConst.CITY_LABEL);
            regionName.setText(organization.getName());    
        } else if (type.getValue().equals(Type.DISPENCERY.getValue())){
            heading1Text.setText(ImplConst.CITY_LABEL);
            heading2Text.setText(ImplConst.DISPENSARY_LABEL);
            regionalLabel.setText(ImplConst.CITY_LABEL);
            regionName.setText(organization.getName());    
        } else if (type.getValue().equals(Type.HOSPITAL.getValue())){
            heading1Text.setText(ImplConst.CITY_LABEL);
            heading2Text.setText(ImplConst.HOSPITAL);
            regionalLabel.setText(ImplConst.CITY_LABEL);
            regionName.setText(organization.getName());    
        } else if (type.getValue().equals(Type.PATIENT.getValue())){
            heading1Text.setText(ImplConst.CITY_LABEL);
            heading2Text.setText(ImplConst.PATIENT_LABEL);
            regionalLabel.setText(ImplConst.CITY_LABEL);
            regionName.setText(organization.getName());    
        } else if (type.getValue().equals(Type.DOCTOR.getValue())){
            heading1Text.setText(ImplConst.CITY_LABEL);
            heading2Text.setText(ImplConst.DOCTOR_LABEL);
            regionalLabel.setText(ImplConst.CITY_LABEL);
            regionName.setText(organization.getName());    
        }
        ImplLogger.exitMethod();
    }
    /**
     * populate the license value of the medicine 
     */
    private void populateLisenceValues(){
        ImplLogger.enterMethod();
        pharmaNameTextField.setText(organization.getName());
        pharmaLicenseNumberTextField.setText(organization.getLincense().getLicenseNumber());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ImplConst.SIMPLE_DATE_FORMAT);
        lastUpdationDateTextField.setText(simpleDateFormat.format(organization.getLincense().getCreationDate()));
        expirationDateTextField.setText(simpleDateFormat.format(organization.getLincense().getExpirationDate()));
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

        jLabel8 = new javax.swing.JLabel();
        licenseTypeGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pharmaNameTextField = new javax.swing.JTextField();
        pharmaLicenseNumberTextField = new javax.swing.JTextField();
        lastUpdationDateTextField = new javax.swing.JTextField();
        expirationDateTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        revokeRadioButton = new javax.swing.JRadioButton();
        twoRadioButton = new javax.swing.JRadioButton();
        threeRadioButton = new javax.swing.JRadioButton();
        fiveRadioButton = new javax.swing.JRadioButton();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        note = new javax.swing.JLabel();
        heading2Text = new javax.swing.JLabel();
        heading1Text = new javax.swing.JLabel();
        regionName = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        regionalLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Manage ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("License Number: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setText("License Expiration Date:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setText("Revoke License:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel6.setText("Extend License By:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setText("Last Updation Date:");

        pharmaNameTextField.setEditable(false);
        pharmaNameTextField.setEnabled(false);

        pharmaLicenseNumberTextField.setEditable(false);
        pharmaLicenseNumberTextField.setEnabled(false);

        lastUpdationDateTextField.setEditable(false);
        lastUpdationDateTextField.setEnabled(false);

        expirationDateTextField.setEditable(false);
        expirationDateTextField.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel9.setText("(MM-DD-YYYY)");

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel10.setText("(MM-DD-YYYY)");

        licenseTypeGroup.add(revokeRadioButton);
        revokeRadioButton.setText("Revoke");

        licenseTypeGroup.add(twoRadioButton);
        twoRadioButton.setSelected(true);
        twoRadioButton.setText("2 year");

        licenseTypeGroup.add(threeRadioButton);
        threeRadioButton.setText("3 Year");

        licenseTypeGroup.add(fiveRadioButton);
        fiveRadioButton.setText("5 Year");

        submitButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Untitledicon.png"))); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
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

        heading2Text.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        heading2Text.setText("jLabel19");

        heading1Text.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        heading1Text.setText("jLabel18");

        regionName.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        regionName.setText("regionalName");

        jLabel17.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel17.setText(":");

        regionalLabel.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        regionalLabel.setText("regionLabel");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel11.setText("License");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(revokeRadioButton))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(twoRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(threeRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(fiveRadioButton)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(note))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton)))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastUpdationDateTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pharmaLicenseNumberTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pharmaNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(31, 31, 31)
                                .addComponent(expirationDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(heading1Text, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(heading2Text, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(regionalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regionName, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(heading2Text)
                    .addComponent(heading1Text)
                    .addComponent(regionName)
                    .addComponent(regionalLabel)
                    .addComponent(jLabel17)
                    .addComponent(jLabel11))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pharmaNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pharmaLicenseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lastUpdationDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(expirationDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(revokeRadioButton)
                    .addComponent(twoRadioButton)
                    .addComponent(threeRadioButton)
                    .addComponent(fiveRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(note))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ImplLogger.enterMethod();
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_backButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        ImplLogger.enterMethod();
        if(licenseTypeGroup.getSelection().equals(revokeRadioButton.getModel())){
            updateLicense(0);
        }else if (licenseTypeGroup.getSelection().equals(twoRadioButton.getModel())){
            updateLicense(2);
        }else if (licenseTypeGroup.getSelection().equals(threeRadioButton.getModel())){
            updateLicense(3);
        }else if (licenseTypeGroup.getSelection().equals(fiveRadioButton.getModel())){
            updateLicense(5);
        }else {
            JOptionPane.showMessageDialog(null, "Please select correct value from the license gruop");
        }
        ImplLogger.exitMethod(); 
    }//GEN-LAST:event_submitButtonActionPerformed
    private void updateLicense(int year){
        ImplLogger.enterMethod();
        Calendar calendar = Calendar.getInstance();
        organization.getLincense().setCreationDate(calendar.getTime());
        calendar.add(Calendar.YEAR, year);
        organization.getLincense().setExpirationDate(calendar.getTime());
        if (year == 0){
            organization.getLincense().setIsLicenseValid(false);
            note.setText("Your Lincense has been revoked.");
            note.setForeground(Color.red);
        } else {           
            organization.getLincense().setIsLicenseValid(true);
            note.setText("Your Lincense has been renewed for " + year + " years");
        }
        populateLisenceValues();
        ImplLogger.exitMethod();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField expirationDateTextField;
    private javax.swing.JRadioButton fiveRadioButton;
    private javax.swing.JLabel heading1Text;
    private javax.swing.JLabel heading2Text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastUpdationDateTextField;
    private javax.swing.ButtonGroup licenseTypeGroup;
    private javax.swing.JLabel note;
    private javax.swing.JTextField pharmaLicenseNumberTextField;
    private javax.swing.JTextField pharmaNameTextField;
    private javax.swing.JLabel regionName;
    private javax.swing.JLabel regionalLabel;
    private javax.swing.JRadioButton revokeRadioButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JRadioButton threeRadioButton;
    private javax.swing.JRadioButton twoRadioButton;
    // End of variables declaration//GEN-END:variables
}
