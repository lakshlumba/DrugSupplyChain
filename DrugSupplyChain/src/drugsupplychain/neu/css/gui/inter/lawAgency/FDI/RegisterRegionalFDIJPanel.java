/*
 * Class : RegisterRegionalFDIJPanel.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 12, 2014, 9:27:42 PM
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
package drugsupplychain.neu.css.gui.inter.lawAgency.FDI;

import drugsupplychain.neu.css.model.address.AddressUtils;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgencyDirectory;
import drugsupplychain.neu.css.model.person.Person;
import drugsupplychain.neu.css.model.role.lawagency.RegionalLawAgencyRole;
import drugsupplychain.neu.css.util.ImplCommonUtil;
import drugsupplychain.neu.css.util.ImplConst;
import drugsupplychain.neu.css.util.ImplValidationUtils;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Laksh
 */
public class RegisterRegionalFDIJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final RegionalLawAgencyDirectory regionalLawAgencyDirectory;
    /**
     * Creates new form RegisterRegionalFDIJPanel
     * @param userProcessContainer
     * @param regionalLawAgencyDirectory
     */
    public RegisterRegionalFDIJPanel(JPanel userProcessContainer,RegionalLawAgencyDirectory regionalLawAgencyDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.regionalLawAgencyDirectory = regionalLawAgencyDirectory;
        populateRegion();        
    }
    private void populateRegion(){
        regionLabel.setText(ImplConst.INTER);
        regionNameComboBox.removeAllItems();
        for(String region : AddressUtils.getRegion())
            regionNameComboBox.addItem(region);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        regionNameComboBox = new javax.swing.JComboBox();
        userNameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        registerRegionalFDIButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        regionLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Register Regional FDI");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Region Name: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setText("Password:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setText("Confirm Pasword:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel6.setText("Generated ID Number:");

        regionNameComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Region" }));

        registerRegionalFDIButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        registerRegionalFDIButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Untitledicon.png"))); // NOI18N
        registerRegionalFDIButton.setText("Submit");
        registerRegionalFDIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerRegionalFDIButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N

        refreshButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
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

        regionLabel.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        regionLabel.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(0, 360, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(186, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(regionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(114, 114, 114)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(confirmPasswordField))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(35, 35, 35)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(regionNameComboBox, 0, 152, Short.MAX_VALUE)
                                        .addComponent(userNameTextField)
                                        .addComponent(passwordField)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(170, 170, 170)
                            .addComponent(refreshButton)
                            .addGap(34, 34, 34)
                            .addComponent(registerRegionalFDIButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(regionLabel))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(regionNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshButton)
                    .addComponent(registerRegionalFDIButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registerRegionalFDIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerRegionalFDIButtonActionPerformed
        if(validateFields()){
            String selectedValue = (String)regionNameComboBox.getSelectedItem();
            String username = userNameTextField.getText();
            String password = passwordField.getText();
            RegionalLawAgency regionalLawAgency = regionalLawAgencyDirectory.addRegionalLawAgency();
            regionalLawAgency.setName(selectedValue);
            regionalLawAgency.setLocation(ImplConst.INTER);
            Person person = regionalLawAgency.getPersonDirectory().createPerson(selectedValue);
            regionalLawAgency.getUserAccountDirectory().createUserAccount(username, password, person, new RegionalLawAgencyRole());
            ImplCommonUtil.updateUserNameList(username);
            jLabel7.setText(regionalLawAgency.getLincense().getLicenseNumber());
            clearAll();
        }
    }//GEN-LAST:event_registerRegionalFDIButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        clearAll();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed
    /**
     * validate the fields before submitting
     */
    private boolean validateFields(){        
        StringBuffer validationMessage = new StringBuffer();
        boolean isValidationPassed = true;
        String selectedValue = (String)regionNameComboBox.getSelectedItem();
        if(null != regionalLawAgencyDirectory.searchRegionalLawAgency(selectedValue)){
            validationMessage.append(ImplConst.VALIDATE_LAW_AGENCY_EXIST);
            validationMessage.append(ImplConst.NEXT_LINE);
            isValidationPassed = false;
        }
        if(ImplValidationUtils.isStringEmptyOrNull(userNameTextField.getText())){
            validationMessage.append(ImplConst.VALIDATE_USERNAME);
            validationMessage.append(ImplConst.NEXT_LINE);
            isValidationPassed = false;
        }
        if(ImplCommonUtil.isUserNameExist(userNameTextField.getText())){
            validationMessage.append(ImplConst.VALIDATE_USERNAME_EXIST);
            validationMessage.append(ImplConst.NEXT_LINE);
            isValidationPassed = false;
        }
        if(ImplValidationUtils.isStringEmptyOrNull(passwordField.getText())){
            validationMessage.append(ImplConst.VALIDATE_PASSWORD);
            validationMessage.append(ImplConst.NEXT_LINE);
            isValidationPassed = false;
        }
        if(ImplValidationUtils.isStringEmptyOrNull(confirmPasswordField.getText())){
            validationMessage.append(ImplConst.CONFIRM_VALIDATE_PASSWORD);
            validationMessage.append(ImplConst.NEXT_LINE);
            isValidationPassed = false;
        }
        if (!ImplValidationUtils.isStringEmptyOrNull(confirmPasswordField.getText()) && !confirmPasswordField.getText().equals(passwordField.getText())){
            validationMessage.append(ImplConst.CONFIRM_VALIDATE_PASSWORD);
            validationMessage.append(ImplConst.NEXT_LINE);
            isValidationPassed = false;        
        }
        if(!isValidationPassed){
            JOptionPane.showMessageDialog(null,validationMessage);
        } 
        return isValidationPassed;
    }
    /**
     * clear all the text field
     */
    private void clearAll(){
        regionNameComboBox.setSelectedIndex(0);
        userNameTextField.setText(ImplConst.EMPTY);
        passwordField.setText(ImplConst.EMPTY);
        confirmPasswordField.setText(ImplConst.EMPTY);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel regionLabel;
    private javax.swing.JComboBox regionNameComboBox;
    private javax.swing.JButton registerRegionalFDIButton;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}
