/*
 * Class : RegisterPharmaOrganizationJPanel.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 12, 2014, 9:42:19 PM
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
import drugsupplychain.neu.css.model.address.Address;
import drugsupplychain.neu.css.model.address.AddressUtils;
import drugsupplychain.neu.css.model.distributor.CityDistributor;
import drugsupplychain.neu.css.model.distributor.CityDistributorDirectory;
import drugsupplychain.neu.css.model.distributor.NationalDistributor;
import drugsupplychain.neu.css.model.distributor.NationalDistributorDirectory;
import drugsupplychain.neu.css.model.distributor.RegionalDistributor;
import drugsupplychain.neu.css.model.distributor.RegionalDistributorDirectory;
import drugsupplychain.neu.css.model.distributor.StateDistributor;
import drugsupplychain.neu.css.model.distributor.StateDistributorDirectory;
import drugsupplychain.neu.css.model.organization.Directory;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.Organization.Type;
import drugsupplychain.neu.css.model.organization.OrganizationDirectory;
import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.organization.pharmacompany.InterNationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.InterNationalPharmaceauticalCompanyDirectory;
import drugsupplychain.neu.css.model.organization.pharmacompany.NationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.NationalPharmaceauticalCompanyDirectory;
import drugsupplychain.neu.css.model.organization.pharmacompany.RegionalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.RegionalPharmaceauticalCompanyDirectory;
import drugsupplychain.neu.css.model.organization.pharmacompany.StatePharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.StatePharmaceauticalCompanyDirectory;
import drugsupplychain.neu.css.model.person.Person;
import drugsupplychain.neu.css.util.ImplCommonUtil;
import drugsupplychain.neu.css.util.ImplConst;
import drugsupplychain.neu.css.util.ImplValidationUtils;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Laksh
 */
public class RegisterPharmaOrganizationJPanel extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private final Directory directory;
    private final Organization organization;
    private final Type type;
    /**
     * Creates new form RegisterPharmaOrganizationJPanel
     * @param userProcessContainer
     * @param directory
     * @param organization
     * @param type
     */
    public RegisterPharmaOrganizationJPanel(JPanel userProcessContainer,Directory directory,Organization organization,Type type) {
        initComponents();
        ImplLogger.enterMethod();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        this.organization = organization;
        this.type = type;
        lincenseNumber.setText(ImplConst.EMPTY);
        populateLabels();
        populateDefaultAddress();
        ImplLogger.exitMethod();
    }
    private void populateDefaultAddress(){
        ImplLogger.enterMethod();
        regionComboBox.removeAllItems();
        for (String region : AddressUtils.getRegion()){
            regionComboBox.addItem(region);
        }
        ImplLogger.exitMethod();
    }
    private void populateCountry(String region){
        ImplLogger.enterMethod();
        countryComboBox.removeAllItems();
        for (String country : AddressUtils.getCountries(region)){
            countryComboBox.addItem(country);
        }
        ImplLogger.exitMethod();
    }
    
    private void populateState(String country){
        ImplLogger.enterMethod();
        stateComboBox.removeAllItems();
        for (String state : AddressUtils.getStates(country)){
            stateComboBox.addItem(state);
        }
        ImplLogger.exitMethod();
    }
    private void populateCity(String state){
        ImplLogger.enterMethod();
        cityComboBox.removeAllItems();
        for (String city : AddressUtils.getCities(state)){
            cityComboBox.addItem(city);
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
        userNameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        registerRegionalFDIButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lincenseNumber = new javax.swing.JLabel();
        pharmaNameTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        addressLine1TextField = new javax.swing.JTextField();
        addressLine2TextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        contactTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        zipCodeTextField = new javax.swing.JTextField();
        regionalLabel = new javax.swing.JLabel();
        regionName = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        countryComboBox = new javax.swing.JComboBox();
        stateComboBox = new javax.swing.JComboBox();
        cityComboBox = new javax.swing.JComboBox();
        regionComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        heading1Text = new javax.swing.JLabel();
        heading2Text = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Register ");

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

        registerRegionalFDIButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        registerRegionalFDIButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Untitledicon.png"))); // NOI18N
        registerRegionalFDIButton.setText("Submit");
        registerRegionalFDIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerRegionalFDIButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Name: ");

        refreshButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setText("Password:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setText("Confirm Pasword:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel6.setText("Generated License Number:");

        lincenseNumber.setText("lincenseNumber");

        pharmaNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pharmaNameTextFieldKeyTyped(evt);
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel8.setText("HeadQuaters Address");

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel9.setText("Address Line1:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel10.setText("Address Line2: ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel11.setText("City:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel12.setText("Country:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel13.setText("State:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel14.setText("Email:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel15.setText("Contact:");

        emailTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailTextFieldKeyTyped(evt);
            }
        });

        contactTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactTextFieldKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel16.setText("Zip Code:");

        zipCodeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                zipCodeTextFieldKeyTyped(evt);
            }
        });

        regionalLabel.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        regionalLabel.setText("regionLabel");

        regionName.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        regionName.setText("regionalName");

        jLabel17.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel17.setText(":");

        countryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryComboBoxActionPerformed(evt);
            }
        });

        stateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateComboBoxActionPerformed(evt);
            }
        });

        regionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionComboBoxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setText("Region:");

        heading1Text.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        heading1Text.setText("jLabel18");

        heading2Text.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        heading2Text.setText("jLabel19");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refreshButton)
                        .addGap(18, 18, 18)
                        .addComponent(registerRegionalFDIButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(heading1Text)
                        .addGap(37, 37, 37)
                        .addComponent(heading2Text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(regionalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(regionName, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(32, 32, 32)
                        .addComponent(lincenseNumber))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel16)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel12)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(regionComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addressLine1TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addressLine2TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(countryComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 207, Short.MAX_VALUE))
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(pharmaNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)))
                .addGap(0, 334, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(regionalLabel)
                        .addComponent(regionName)
                        .addComponent(jLabel17))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(heading2Text)
                        .addComponent(heading1Text)
                        .addComponent(jLabel1)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pharmaNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(contactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(addressLine1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLine2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(lincenseNumber))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(refreshButton)
                        .addComponent(registerRegionalFDIButton)))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * populate labels
     * 
     */
    private void populateLabels(){
        ImplLogger.enterMethod();
        ImplLogger.info("Organization : " + type.getValue());
        if (type.getValue().equals(Type.INTER_PHARMA_CO.getValue())){
            heading1Text.setText(ImplConst.INTER);
            heading2Text.setText(ImplConst.PHARMA_LABEL);
            regionalLabel.setText(ImplConst.INTER_LABEL);
            regionName.setText(ImplConst.INTER_LABEL);
        }   else if (type.getValue().equals(Type.REGIONAL_PHARMA_CO.getValue())){
            heading1Text.setText(ImplConst.REGIONAL_LABEL);
            heading2Text.setText(ImplConst.PHARMA_LABEL);
            regionalLabel.setText(ImplConst.REGIONAL_LABEL);
            regionName.setText(organization.getName());
        }   else if (type.getValue().equals(Type.NATIONAL_PHARMA_CO.getValue())){
            heading1Text.setText(ImplConst.NATIONAL_LABEL);
            heading2Text.setText(ImplConst.PHARMA_LABEL);
            regionalLabel.setText(ImplConst.NATIONAL_LABEL);
            regionName.setText(organization.getName());    
        }   else if (type.getValue().equals(Type.STATE_PHARMA_CO.getValue())){
            heading1Text.setText(ImplConst.STATE_LABEL);
            heading2Text.setText(ImplConst.PHARMA_LABEL);
            regionalLabel.setText(ImplConst.STATE_LABEL);
            regionName.setText(organization.getName());    
        }   else if (type.getValue().equals(Type.REGIONAL_DISTRIBUTOR.getValue())){
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
    
    
    private void registerRegionalFDIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerRegionalFDIButtonActionPerformed
        ImplLogger.enterMethod();
        lincenseNumber.setText(ImplConst.EMPTY);
        if(validateFields()){
            if (type.getValue().equals(Type.INTER_PHARMA_CO.getValue())){
                    InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany = ((InterNationalPharmaceauticalCompanyDirectory)directory).addInterNationalPharmaceauticalCompany();
                    if (null == ((InterNationalPharmaceauticalCompanyDirectory)directory).searchInterNationalPharmaceauticalCompany(pharmaNameTextField.getText())){
                        createOrganization(interNationalPharmaceauticalCompany);
                    }
            }   else if (type.getValue().equals(Type.REGIONAL_PHARMA_CO.getValue())){
                    RegionalPharmaceauticalCompany regionalPharmaceauticalCompany = ((RegionalPharmaceauticalCompanyDirectory)directory).addRegionalPharmaceauticalCompany();
                    if (null == ((RegionalPharmaceauticalCompanyDirectory)directory).searchRegionalPharmaceauticalCompany(pharmaNameTextField.getText())){
                        createOrganization(regionalPharmaceauticalCompany);       
                    }                
            }   else if (type.getValue().equals(Type.NATIONAL_PHARMA_CO.getValue())){
                    NationalPharmaceauticalCompany nationalPharmaceauticalCompany = ((NationalPharmaceauticalCompanyDirectory)directory).addNationalPharmaceauticalCompany();
                    if (null == ((NationalPharmaceauticalCompanyDirectory)directory).searchNationalPharmaceauticalCompany(pharmaNameTextField.getText())){
                        createOrganization(nationalPharmaceauticalCompany);       
                    }
            }   else if (type.getValue().equals(Type.STATE_PHARMA_CO.getValue())){
                    StatePharmaceauticalCompany statePharmaceauticalCompany = ((StatePharmaceauticalCompanyDirectory)directory).addStatePharmaceauticalCompany();
                    if (null == ((StatePharmaceauticalCompanyDirectory)directory).searchStatePharmaceauticalCompany(pharmaNameTextField.getText())){
                        createOrganization(statePharmaceauticalCompany);       
                    }
            }   else if (type.getValue().equals(Type.REGIONAL_DISTRIBUTOR.getValue())){
                    RegionalDistributor regionalDistributor = ((RegionalDistributorDirectory)directory).addRegionalDistributor();
                    if (null == ((RegionalDistributorDirectory)directory).searchRegionalDistributor(pharmaNameTextField.getText())){
                        createOrganization(regionalDistributor);       
                    }                
            }   else if (type.getValue().equals(Type.NATIONAL_DISTRIBUTOR.getValue())){
                    NationalDistributor nationalDistributor = ((NationalDistributorDirectory)directory).addNationalDistributor();
                    if (null == ((NationalDistributorDirectory)directory).searchNationalDistributor(pharmaNameTextField.getText())){
                        createOrganization(nationalDistributor);       
                    } 
            }   else if (type.getValue().equals(Type.STATE_DISTRIBUTOR.getValue())){
                    StateDistributor stateDistributor = ((StateDistributorDirectory)directory).addStateDistributor();
                    if (null == ((StateDistributorDirectory)directory).searchStateDistributor(pharmaNameTextField.getText())){
                        createOrganization(stateDistributor);       
                    } 
            }   else if (type.getValue().equals(Type.CITY_DISTRIBUTOR.getValue())){
                    CityDistributor cityDistributor = ((CityDistributorDirectory)directory).addCityDistributor();
                    if (null == ((CityDistributorDirectory)directory).searchCityDistributor(pharmaNameTextField.getText())){
                        createOrganization(cityDistributor);       
                    } 
            }   else if (type.getValue().equals(Type.CLINIC.getValue()) || type.getValue().equals(Type.PHARMACY.getValue()) || 
                          type.getValue().equals(Type.HOSPITAL.getValue()) || type.getValue().equals(Type.DISPENCERY.getValue()) || 
                            type.getValue().equals(Type.DOCTOR.getValue()) || type.getValue().equals(Type.PATIENT.getValue())){
                    Organization  organization1 = ((OrganizationDirectory)directory).createOrganization(type);
                    createOrganization(organization1);
                    CityLawAgency cityLawAgency = (CityLawAgency)organization;
                    cityLawAgency.addOrganizationToDirectory(type, organization1);
            }
            else {
                JOptionPane.showMessageDialog(null,ImplConst.VALIDATE_NAME_EXIST);
            }
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_registerRegionalFDIButtonActionPerformed
    
    private void createOrganization(Organization organization1){        
        ImplLogger.enterMethod(); 
        ImplLogger.info(organization1.getClass());
            String selectedValue = pharmaNameTextField.getText();
            String username = userNameTextField.getText();
            String password = passwordField.getText();
            organization1.setName(selectedValue);
            organization1.setLocation(organization.getName());
            Person person = organization1.getPersonDirectory().createPerson(selectedValue);
            person.setContactNumber(contactTextField.getText());
            person.setEmail(emailTextField.getText());
            Address address = new Address();
            address.setAddressLine1(addressLine1TextField.getText());
            address.setAddressLine2(addressLine2TextField.getText());
            address.setRegion(regionComboBox.getSelectedItem().toString());
            address.setCity(cityComboBox.getSelectedItem().toString());
            address.setState(stateComboBox.getSelectedItem().toString());
            address.setCountry(countryComboBox.getSelectedItem().toString());
            address.setZipcode(zipCodeTextField.getText());
            person.setAddress(address);
            organization1.getUserAccountDirectory().createUserAccount(username, password, person, ImplCommonUtil.getOrganizationRole(type));
            ImplCommonUtil.updateUserNameList(username);
            lincenseNumber.setText(organization1.getLincense().getLicenseNumber());
            clearAll();
        ImplLogger.exitMethod();
    }
    
    /**
     * validate the fields before submitting
     */
    private boolean validateFields(){        
        ImplLogger.enterMethod(); 
            StringBuffer validationMessage = new StringBuffer();
            boolean isValidationPassed = true;
            if(!ImplValidationUtils.isAlphaSpace(pharmaNameTextField.getText())){
                validationMessage.append(ImplConst.VALIDATE_NAME);
                validationMessage.append(ImplConst.NEXT_LINE);
                pharmaNameTextField.setBackground(Color.red);
                isValidationPassed = false;
            }        
            if(!ImplValidationUtils.isAlphabetOnly(userNameTextField.getText())){
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
            if(!ImplValidationUtils.isInteger(contactTextField.getText())){
                validationMessage.append(ImplConst.VALIDATE_CONTACT);
                validationMessage.append(ImplConst.NEXT_LINE);
                contactTextField.setBackground(Color.red);
                isValidationPassed = false;
            }
            if(!ImplValidationUtils.isInteger(zipCodeTextField.getText())){
                validationMessage.append(ImplConst.VALIDATE_ZIPCODE);
                validationMessage.append(ImplConst.NEXT_LINE);
                zipCodeTextField.setBackground(Color.red);
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
        ImplLogger.enterMethod(); 
            pharmaNameTextField.setText(ImplConst.EMPTY);
            userNameTextField.setText(ImplConst.EMPTY);
            passwordField.setText(ImplConst.EMPTY);
            confirmPasswordField.setText(ImplConst.EMPTY);
            addressLine1TextField.setText(ImplConst.EMPTY);
            addressLine2TextField.setText(ImplConst.EMPTY);
            regionComboBox.setSelectedIndex(0);
            emailTextField.setText(ImplConst.EMPTY);
            contactTextField.setText(ImplConst.EMPTY);
            zipCodeTextField.setText(ImplConst.EMPTY);
        ImplLogger.exitMethod();
    }
    /**
     * 
     * @param evt 
     */
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        clearAll();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ImplLogger.enterMethod();
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_backButtonActionPerformed

    private void regionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionComboBoxActionPerformed
        populateCountry(String.valueOf(regionComboBox.getSelectedItem()));
    }//GEN-LAST:event_regionComboBoxActionPerformed

    private void countryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryComboBoxActionPerformed
        populateState(String.valueOf(countryComboBox.getSelectedItem()));
    }//GEN-LAST:event_countryComboBoxActionPerformed

    private void stateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateComboBoxActionPerformed
        populateCity(String.valueOf(stateComboBox.getSelectedItem()));
    }//GEN-LAST:event_stateComboBoxActionPerformed

    private void pharmaNameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pharmaNameTextFieldKeyTyped
        pharmaNameTextField.setBackground(Color.white);
    }//GEN-LAST:event_pharmaNameTextFieldKeyTyped

    private void userNameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTextFieldKeyTyped
        userNameTextField.setBackground(Color.white);
    }//GEN-LAST:event_userNameTextFieldKeyTyped

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyTyped
        passwordField.setBackground(Color.white);
    }//GEN-LAST:event_passwordFieldKeyTyped

    private void confirmPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPasswordFieldKeyTyped
        confirmPasswordField.setBackground(Color.white);
    }//GEN-LAST:event_confirmPasswordFieldKeyTyped

    private void emailTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTextFieldKeyTyped
        emailTextField.setBackground(Color.white);
    }//GEN-LAST:event_emailTextFieldKeyTyped

    private void contactTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactTextFieldKeyTyped
        contactTextField.setBackground(Color.white);
    }//GEN-LAST:event_contactTextFieldKeyTyped

    private void zipCodeTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zipCodeTextFieldKeyTyped
        zipCodeTextField.setBackground(Color.white);
    }//GEN-LAST:event_zipCodeTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressLine1TextField;
    private javax.swing.JTextField addressLine2TextField;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox cityComboBox;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JTextField contactTextField;
    private javax.swing.JComboBox countryComboBox;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel heading1Text;
    private javax.swing.JLabel heading2Text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lincenseNumber;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField pharmaNameTextField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JComboBox regionComboBox;
    private javax.swing.JLabel regionName;
    private javax.swing.JLabel regionalLabel;
    private javax.swing.JButton registerRegionalFDIButton;
    private javax.swing.JComboBox stateComboBox;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JTextField zipCodeTextField;
    // End of variables declaration//GEN-END:variables
}
