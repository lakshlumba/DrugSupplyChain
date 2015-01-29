/*
 * Class : RegisterNationalFDIJPanel.java
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
package drugsupplychain.neu.css.gui.regional.lawagency.FDI;

import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.address.AddressUtils;
import drugsupplychain.neu.css.model.organization.lawAgencies.NationalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.NationalLawAgencyDirectory;
import drugsupplychain.neu.css.model.person.Person;
import drugsupplychain.neu.css.model.role.lawagency.NationalLawAgencyRole;
import drugsupplychain.neu.css.util.ImplCommonUtil;
import drugsupplychain.neu.css.util.ImplConst;
import drugsupplychain.neu.css.util.ImplValidationUtils;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Laksh
 */
public class RegisterNationalFDIJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final NationalLawAgencyDirectory nationalLawAgencyDirectory;
    private final String regionName;
    /**
     * Creates new form RegisterNationalFDIJPanel
     * @param userProcessContainer
     * @param nationalLawAgencyDirectory
     */
    public RegisterNationalFDIJPanel(JPanel userProcessContainer,NationalLawAgencyDirectory nationalLawAgencyDirectory,String regionName) {
        initComponents();
        ImplLogger.enterMethod();
        this.userProcessContainer = userProcessContainer;
        this.nationalLawAgencyDirectory = nationalLawAgencyDirectory;
        this.regionName = regionName;
        ImplLogger.exitMethod();
        populateRegion();
    }
    /**
     * populate region
     */
    private void populateRegion(){
        ImplLogger.enterMethod();
        regionLabel.setText(regionName);
        nationNameComboBox.removeAllItems();
        ArrayList<String> countryList = AddressUtils.getCountries(regionName);
        for(String country : countryList){
            nationNameComboBox.addItem(country);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nationNameComboBox = new javax.swing.JComboBox();
        userNameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        registerNationalFDIButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        regionLabel = new javax.swing.JLabel();
        lincenseNumber = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Register National FDI");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Country Name: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setText("Password:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setText("Confirm Pasword:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel6.setText("Generated ID Number:");

        nationNameComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        userNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userNameTextFieldKeyTyped(evt);
            }
        });

        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFieldKeyTyped(evt);
            }
        });

        confirmPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                confirmPasswordFieldKeyTyped(evt);
            }
        });

        registerNationalFDIButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        registerNationalFDIButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Untitledicon.png"))); // NOI18N
        registerNationalFDIButton.setText("Submit");
        registerNationalFDIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerNationalFDIButtonActionPerformed(evt);
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

        lincenseNumber.setText("licenseNumber");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nationNameComboBox, 0, 152, Short.MAX_VALUE)
                                    .addComponent(userNameTextField)
                                    .addComponent(passwordField))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton)
                        .addGap(34, 34, 34)
                        .addComponent(registerNationalFDIButton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(regionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lincenseNumber)
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
                    .addComponent(nationNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lincenseNumber))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(registerNationalFDIButton)
                        .addComponent(refreshButton)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * register national
     * @param evt 
     */
    private void registerNationalFDIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerNationalFDIButtonActionPerformed
        ImplLogger.enterMethod();
        if(validateFields()){
            String selectedValue = (String)nationNameComboBox.getSelectedItem();
            String username = userNameTextField.getText();
            String password = passwordField.getText();
            NationalLawAgency nationalLawAgency = nationalLawAgencyDirectory.addNationalLawAgency();
            nationalLawAgency.setName(selectedValue);
            nationalLawAgency.setLocation(regionName);
            Person person = nationalLawAgency.getPersonDirectory().createPerson(selectedValue);
            nationalLawAgency.getUserAccountDirectory().createUserAccount(username, password, person, new NationalLawAgencyRole());
            ImplCommonUtil.updateUserNameList(username);
            lincenseNumber.setText(nationalLawAgency.getLincense().getLicenseNumber());
            clearAll();
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_registerNationalFDIButtonActionPerformed
    /**
     * refresh
     * @param evt 
     */
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        ImplLogger.enterMethod();
        clearAll();
        ImplLogger.exitMethod();
    }//GEN-LAST:event_refreshButtonActionPerformed
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
     * username
     * @param evt 
     */
    private void userNameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTextFieldKeyTyped
        userNameTextField.setBackground(Color.white);
    }//GEN-LAST:event_userNameTextFieldKeyTyped
    /**
     * password
     * @param evt 
     */
    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyTyped
        passwordField.setBackground(Color.white);
    }//GEN-LAST:event_passwordFieldKeyTyped
    /**
     * confirm password
     * @param evt 
     */
    private void confirmPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPasswordFieldKeyTyped
        confirmPasswordField.setBackground(Color.white);
    }//GEN-LAST:event_confirmPasswordFieldKeyTyped
    /**
     * validate the fields before submitting
     */
    private boolean validateFields(){
        ImplLogger.enterMethod();
        StringBuffer validationMessage = new StringBuffer();
        boolean isValidationPassed = true;
        String selectedValue = (String)nationNameComboBox.getSelectedItem();
        if(null != nationalLawAgencyDirectory.searchNationalLawAgency(selectedValue)){
            validationMessage.append(ImplConst.VALIDATE_LAW_AGENCY_EXIST);
            validationMessage.append(ImplConst.NEXT_LINE);
            isValidationPassed = false;
        }
        if(ImplValidationUtils.isStringEmptyOrNull(userNameTextField.getText())){
            validationMessage.append(ImplConst.VALIDATE_USERNAME);
            validationMessage.append(ImplConst.NEXT_LINE);
            userNameTextField.setBackground(Color.red);
            isValidationPassed = false;
        }
        if(ImplCommonUtil.isUserNameExist(userNameTextField.getText())){
            validationMessage.append(ImplConst.VALIDATE_USERNAME_EXIST);
            validationMessage.append(ImplConst.NEXT_LINE);
            userNameTextField.setBackground(Color.red);
            isValidationPassed = false;
        }
        if(ImplValidationUtils.isStringEmptyOrNull(passwordField.getText())){
            validationMessage.append(ImplConst.VALIDATE_PASSWORD);
            validationMessage.append(ImplConst.NEXT_LINE);
            passwordField.setBackground(Color.red);
            isValidationPassed = false;
        }
        if(ImplValidationUtils.isStringEmptyOrNull(confirmPasswordField.getText())){
            validationMessage.append(ImplConst.CONFIRM_VALIDATE_PASSWORD);
            validationMessage.append(ImplConst.NEXT_LINE);
            confirmPasswordField.setBackground(Color.red);
            isValidationPassed = false;
        }
        if (!ImplValidationUtils.isStringEmptyOrNull(confirmPasswordField.getText()) && !confirmPasswordField.getText().equals(passwordField.getText())){
            validationMessage.append(ImplConst.CONFIRM_VALIDATE_PASSWORD);
            validationMessage.append(ImplConst.NEXT_LINE);
            passwordField.setBackground(Color.red);
            confirmPasswordField.setBackground(Color.red);
            isValidationPassed = false;        
        }
        if(!isValidationPassed){
            JOptionPane.showMessageDialog(null,validationMessage);
        } 
        ImplLogger.exitMethod();
        return isValidationPassed;
    }
    /**
     * clear all the text field
     */
    private void clearAll(){
        nationNameComboBox.setSelectedIndex(0);
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
    private javax.swing.JLabel lincenseNumber;
    private javax.swing.JComboBox nationNameComboBox;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel regionLabel;
    private javax.swing.JButton registerNationalFDIButton;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}
