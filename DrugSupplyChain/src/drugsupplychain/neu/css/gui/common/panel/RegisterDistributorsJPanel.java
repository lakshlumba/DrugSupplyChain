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
package drugsupplychain.neu.css.gui.common.panel;

import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.FDI.FDISystem;
import drugsupplychain.neu.css.model.distributor.CityDistributor;
import drugsupplychain.neu.css.model.distributor.NationalDistributor;
import drugsupplychain.neu.css.model.distributor.RegionalDistributor;
import drugsupplychain.neu.css.model.distributor.StateDistributor;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.NationalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.StateLawAgency;
import drugsupplychain.neu.css.model.organization.other.ClinicOrganization;
import drugsupplychain.neu.css.model.organization.other.DispenceryOrganization;
import drugsupplychain.neu.css.model.organization.other.DoctorOrganization;
import drugsupplychain.neu.css.model.organization.other.HospitalOrganization;
import drugsupplychain.neu.css.model.organization.other.PharmacyOrganization;
import drugsupplychain.neu.css.model.organization.pharmacompany.InterNationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.NationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.RegionalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.StatePharmaceauticalCompany;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laksh
 */
public class RegisterDistributorsJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final Organization organization;
    private final Organization higherOrganization;
    /**
     * Creates new form RegisterDistributorsJPanel
     * @param userProcessContainer
     * @param organization
     * @param higherOrganization
     */
    public RegisterDistributorsJPanel(JPanel userProcessContainer,Organization organization,Organization higherOrganization) {
        initComponents();
        ImplLogger.enterMethod();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.higherOrganization = higherOrganization;
        populateRegisteredTable();
        populateUnregisteredTable();
        ImplLogger.exitMethod();
    }
    /**
     * populate the registered distributors
     */
    private void populateRegisteredTable(){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)registerTable.getModel();
        defaultTableModel.setRowCount(0);
        if(organization instanceof InterNationalPharmaceauticalCompany){
            ImplLogger.info("organization : InterNationalPharmaceauticalCompany");
            FDISystem fDISystem = (FDISystem)higherOrganization;
            for (RegionalLawAgency regionalLawAgency : fDISystem.getRegionalLawAgencyDirectory().getRegionalLawAgencyList()){
                for (RegionalDistributor regionalDistributor : regionalLawAgency.getRegionalDistributorDirectory().getRegionalDistributorList()){
                        Object[] row = new Object[5];
                        row[0] = regionalDistributor.getOrganizationID();
                        row[1] = regionalDistributor;
                        row[2] = regionalDistributor.getLocation();
                        row[3] = regionalDistributor.getLincense().getLicenseNumber();
                        row[4] = regionalDistributor.getLincense().isIsLicenseValid();
                        defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof RegionalPharmaceauticalCompany){
            ImplLogger.info("organization : RegionalPharmaceauticalCompany");
            RegionalLawAgency regionalLawAgency = (RegionalLawAgency)higherOrganization;
            for (NationalLawAgency nationalLawAgency : regionalLawAgency.getNationalLawAgencyDirectory().getNationalLawAgencyList()){
                for (NationalDistributor nationalDistributor : nationalLawAgency.getNationalDistributorDirectory().getNationalDistributorList()){
                        Object[] row = new Object[5];
                        row[0] = nationalDistributor.getOrganizationID();
                        row[1] = nationalDistributor;
                        row[2] = nationalDistributor.getLocation();
                        row[3] = nationalDistributor.getLincense().getLicenseNumber();
                        row[4] = nationalDistributor.getLincense().isIsLicenseValid();
                        defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof NationalPharmaceauticalCompany){
            ImplLogger.info("organization : NationalPharmaceauticalCompany");
            NationalLawAgency nationalLawAgency = (NationalLawAgency)higherOrganization;
            for (StateLawAgency stateLawAgency : nationalLawAgency.getStateLawAgencyDirectory().getStateLawAgencyList()){
                for (StateDistributor stateDistributor : stateLawAgency.getStateDistributorDirectory().getStateDistributorList()){
                        Object[] row = new Object[5];
                        row[0] = stateDistributor.getOrganizationID();
                        row[1] = stateDistributor;
                        row[2] = stateDistributor.getLocation();
                        row[3] = stateDistributor.getLincense().getLicenseNumber();
                        row[4] = stateDistributor.getLincense().isIsLicenseValid();
                        defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof StatePharmaceauticalCompany){
            ImplLogger.info("organization : StatePharmaceauticalCompany");
            StateLawAgency stateLawAgency = (StateLawAgency)higherOrganization;
            for (CityLawAgency cityLawAgency : stateLawAgency.getCityLawAgencyDirectory().getCityLawAgencyList()){
                for (CityDistributor cityDistributor : cityLawAgency.getCityDistributorDirectory().getCityDistributorList()){
                        Object[] row = new Object[5];
                        row[0] = cityDistributor.getOrganizationID();
                        row[1] = cityDistributor;
                        row[2] = cityDistributor.getLocation();
                        row[3] = cityDistributor.getLincense().getLicenseNumber();
                        row[4] = cityDistributor.getLincense().isIsLicenseValid();
                        defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof RegionalDistributor){
            ImplLogger.info("organization : RegionalDistributor");
            RegionalLawAgency regionalLawAgency = (RegionalLawAgency)higherOrganization;
            for (NationalLawAgency nationalLawAgency : regionalLawAgency.getNationalLawAgencyDirectory().getNationalLawAgencyList()){
                for (NationalDistributor nationalDistributor : nationalLawAgency.getNationalDistributorDirectory().getNationalDistributorList()){
                        Object[] row = new Object[5];
                        row[0] = nationalDistributor.getOrganizationID();
                        row[1] = nationalDistributor;
                        row[2] = nationalDistributor.getLocation();
                        row[3] = nationalDistributor.getLincense().getLicenseNumber();
                        row[4] = nationalDistributor.getLincense().isIsLicenseValid();
                        defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof NationalDistributor){
            ImplLogger.info("organization : NationalDistributor");
            NationalLawAgency nationalLawAgency = (NationalLawAgency)higherOrganization;
            for (StateLawAgency stateLawAgency : nationalLawAgency.getStateLawAgencyDirectory().getStateLawAgencyList()){
                for (StateDistributor stateDistributor : stateLawAgency.getStateDistributorDirectory().getStateDistributorList()){
                        Object[] row = new Object[5];
                        row[0] = stateDistributor.getOrganizationID();
                        row[1] = stateDistributor;
                        row[2] = stateDistributor.getLocation();
                        row[3] = stateDistributor.getLincense().getLicenseNumber();
                        row[4] = stateDistributor.getLincense().isIsLicenseValid();
                        defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof StateDistributor){
            ImplLogger.info("organization : StateDistributor");
            StateLawAgency stateLawAgency = (StateLawAgency)higherOrganization;
            for (CityLawAgency cityLawAgency : stateLawAgency.getCityLawAgencyDirectory().getCityLawAgencyList()){
                for (CityDistributor cityDistributor : cityLawAgency.getCityDistributorDirectory().getCityDistributorList()){
                        Object[] row = new Object[5];
                        row[0] = cityDistributor.getOrganizationID();
                        row[1] = cityDistributor;
                        row[2] = cityDistributor.getLocation();
                        row[3] = cityDistributor.getLincense().getLicenseNumber();
                        row[4] = cityDistributor.getLincense().isIsLicenseValid();
                        defaultTableModel.addRow(row);
                }
            }
        }   else if(organization instanceof CityDistributor){
            ImplLogger.info("organization : CityDistributor");
            CityLawAgency cityLawAgency = (CityLawAgency)higherOrganization;            
                for (Organization organization1 : cityLawAgency.getOrganizationDirectory().getOrganizationList()){
                        if (organization1 instanceof PharmacyOrganization || organization1 instanceof HospitalOrganization || organization1 instanceof DispenceryOrganization
                            || organization1 instanceof ClinicOrganization || organization1 instanceof DoctorOrganization){
                            Object[] row = new Object[5];
                            row[0] = organization1.getOrganizationID();
                            row[1] = organization1;
                            row[2] = organization1.getLocation();
                            row[3] = organization1.getLincense().getLicenseNumber();
                            row[4] = organization1.getLincense().isIsLicenseValid();
                            defaultTableModel.addRow(row);
                        }
                }
        }
        ImplLogger.exitMethod();
    }
    /**
     * populate unregistered distributors
     */
    private void populateUnregisteredTable(){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)unRegisterTable.getModel();
        defaultTableModel.setRowCount(0);
        if(organization instanceof InterNationalPharmaceauticalCompany){
            ImplLogger.info("organization : InterNationalPharmaceauticalCompany");
            InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany = (InterNationalPharmaceauticalCompany)organization;
            for (RegionalDistributor regionalDistributor : interNationalPharmaceauticalCompany.getRegionalDistributorDirectory().getRegionalDistributorList()){
                Object[] row = new Object[5];
                row[0] = regionalDistributor.getOrganizationID();
                row[1] = regionalDistributor;
                row[2] = regionalDistributor.getLocation();
                row[3] = regionalDistributor.getLincense().getLicenseNumber();
                row[4] = regionalDistributor.getLincense().isIsLicenseValid();
                defaultTableModel.addRow(row);
            }
        }   else if(organization instanceof RegionalPharmaceauticalCompany){
                ImplLogger.info("organization : RegionalPharmaceauticalCompany");
                RegionalPharmaceauticalCompany regionalPharmaceauticalCompany = (RegionalPharmaceauticalCompany)organization;
                for (NationalDistributor nationalDistributor : regionalPharmaceauticalCompany.getNationalDistributorDirectory().getNationalDistributorList()){
                    Object[] row = new Object[5];
                    row[0] = nationalDistributor.getOrganizationID();
                    row[1] = nationalDistributor;
                    row[2] = nationalDistributor.getLocation();
                    row[3] = nationalDistributor.getLincense().getLicenseNumber();
                    row[4] = nationalDistributor.getLincense().isIsLicenseValid();
                    defaultTableModel.addRow(row);
                }
        }   else if(organization instanceof NationalPharmaceauticalCompany){
                ImplLogger.info("organization : NationalPharmaceauticalCompany");
                NationalPharmaceauticalCompany nationalPharmaceauticalCompany = (NationalPharmaceauticalCompany)organization;
                for (StateDistributor stateDistributor : nationalPharmaceauticalCompany.getStateDistributorDirectory().getStateDistributorList()){
                    Object[] row = new Object[5];
                    row[0] = stateDistributor.getOrganizationID();
                    row[1] = stateDistributor;
                    row[2] = stateDistributor.getLocation();
                    row[3] = stateDistributor.getLincense().getLicenseNumber();
                    row[4] = stateDistributor.getLincense().isIsLicenseValid();
                    defaultTableModel.addRow(row);
                }
        }   else if(organization instanceof StatePharmaceauticalCompany){
                ImplLogger.info("organization : StatePharmaceauticalCompany");
                StatePharmaceauticalCompany statePharmaceauticalCompany = (StatePharmaceauticalCompany)organization;
                for (CityDistributor cityDistributor : statePharmaceauticalCompany.getCityDistributorDirectory().getCityDistributorList()){
                    Object[] row = new Object[5];
                    row[0] = cityDistributor.getOrganizationID();
                    row[1] = cityDistributor;
                    row[2] = cityDistributor.getLocation();
                    row[3] = cityDistributor.getLincense().getLicenseNumber();
                    row[4] = cityDistributor.getLincense().isIsLicenseValid();
                    defaultTableModel.addRow(row);
                }
        }   else if(organization instanceof RegionalDistributor){
                ImplLogger.info("organization : RegionalDistributor");
                RegionalDistributor regionalDistributor = (RegionalDistributor)organization;
                for (NationalDistributor nationalDistributor : regionalDistributor.getNationalDistributorDirectory().getNationalDistributorList()){
                    Object[] row = new Object[5];
                    row[0] = nationalDistributor.getOrganizationID();
                    row[1] = nationalDistributor;
                    row[2] = nationalDistributor.getLocation();
                    row[3] = nationalDistributor.getLincense().getLicenseNumber();
                    row[4] = nationalDistributor.getLincense().isIsLicenseValid();
                    defaultTableModel.addRow(row);
                }
        }   else if(organization instanceof NationalDistributor){
                ImplLogger.info("organization : NationalDistributor");
                NationalDistributor nationalDistributor = (NationalDistributor)organization;
                for (StateDistributor stateDistributor : nationalDistributor.getStateDistributorDirectory().getStateDistributorList()){
                    Object[] row = new Object[5];
                    row[0] = stateDistributor.getOrganizationID();
                    row[1] = stateDistributor;
                    row[2] = stateDistributor.getLocation();
                    row[3] = stateDistributor.getLincense().getLicenseNumber();
                    row[4] = stateDistributor.getLincense().isIsLicenseValid();
                    defaultTableModel.addRow(row);
                }
        }   else if(organization instanceof StateDistributor){
                ImplLogger.info("organization : StateDistributor");
                StateDistributor stateDistributor = (StateDistributor)organization;
                for (CityDistributor cityDistributor : stateDistributor.getCityDistributorDirectory().getCityDistributorList()){
                    Object[] row = new Object[5];
                    row[0] = cityDistributor.getOrganizationID();
                    row[1] = cityDistributor;
                    row[2] = cityDistributor.getLocation();
                    row[3] = cityDistributor.getLincense().getLicenseNumber();
                    row[4] = cityDistributor.getLincense().isIsLicenseValid();
                    defaultTableModel.addRow(row);
                }
        }   else if(organization instanceof CityDistributor){
                ImplLogger.info("organization : CityDistributor");
                CityDistributor cityDistributor = (CityDistributor)organization;
                for (Organization organization1 : cityDistributor.getOrganizationDirectory().getOrganizationList()){
                    Object[] row = new Object[5];
                    row[0] = organization1.getOrganizationID();
                    row[1] = organization1;
                    row[2] = organization1.getLocation();
                    row[3] = organization1.getLincense().getLicenseNumber();
                    row[4] = organization1.getLincense().isIsLicenseValid();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        unRegisterTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        registerDistributor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        registerTable = new javax.swing.JTable();
        unregisterDistributor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Register Distributors");

        unRegisterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Distributor ID", "Distributor Name", "Region Name", "Lincense Number", "Is License Valid"
            }
        ));
        jScrollPane1.setViewportView(unRegisterTable);

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

        registerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Distributor ID", "Distributor Name", "Region Name", "Lincense Number", "Is License Valid"
            }
        ));
        jScrollPane2.setViewportView(registerTable);

        unregisterDistributor.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        unregisterDistributor.setText("Unregistered Distributor");
        unregisterDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unregisterDistributorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Unregister Distributor ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209)
                        .addComponent(registerDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(unregisterDistributor)))))
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(431, 431, 431)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unregisterDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
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
     * register distributor
     * @param evt 
     */
    private void registerDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerDistributorActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  registerTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            if(organization instanceof InterNationalPharmaceauticalCompany){
                ImplLogger.info("organization : InterNationalPharmaceauticalCompany");
                RegionalDistributor regionalDistributor = (RegionalDistributor)registerTable.getValueAt(selectedRow, 1);
                InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany = (InterNationalPharmaceauticalCompany)organization;
                if (regionalDistributor.getLincense().isIsLicenseValid()){
                    if(null == interNationalPharmaceauticalCompany.getDistributorList().get(regionalDistributor.getLocation())){
                        interNationalPharmaceauticalCompany.getDistributorList().put(regionalDistributor.getLocation(), regionalDistributor);
                        interNationalPharmaceauticalCompany.getRegionalDistributorDirectory().addRegionalDistributor(regionalDistributor);
                    } else {
                        JOptionPane.showMessageDialog(null, "Distributor Already exist in this region"); 
                    }
                } else {
                        JOptionPane.showMessageDialog(null, "Distributor Licesence is not valid"); 
                }
            }   else if(organization instanceof RegionalPharmaceauticalCompany){
                    ImplLogger.info("organization : RegionalPharmaceauticalCompany");
                    NationalDistributor nationalDistributor = (NationalDistributor)registerTable.getValueAt(selectedRow, 1);
                    RegionalPharmaceauticalCompany regionalPharmaceauticalCompany = (RegionalPharmaceauticalCompany)organization;
                    if (nationalDistributor.getLincense().isIsLicenseValid()){
                        if(null == regionalPharmaceauticalCompany.getDistributorList().get(nationalDistributor.getLocation())){
                            regionalPharmaceauticalCompany.getDistributorList().put(nationalDistributor.getLocation(), nationalDistributor);
                            regionalPharmaceauticalCompany.getNationalDistributorDirectory().addNationalDistributor(nationalDistributor);
                        } else {
                            JOptionPane.showMessageDialog(null, "Distributor Already exist in this region"); 
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Distributor Licesence is not valid"); 
                    }
            }   else if(organization instanceof NationalPharmaceauticalCompany){
                    ImplLogger.info("organization : NationalPharmaceauticalCompany");
                    StateDistributor stateDistributor = (StateDistributor)registerTable.getValueAt(selectedRow, 1);
                    NationalPharmaceauticalCompany nationalPharmaceauticalCompany = (NationalPharmaceauticalCompany)organization;
                    if (stateDistributor.getLincense().isIsLicenseValid()){
                        if(null == nationalPharmaceauticalCompany.getDistributorList().get(stateDistributor.getLocation())){
                            nationalPharmaceauticalCompany.getDistributorList().put(stateDistributor.getLocation(), stateDistributor);
                            nationalPharmaceauticalCompany.getStateDistributorDirectory().addStateDistributor(stateDistributor);
                        } else {
                            JOptionPane.showMessageDialog(null, "Distributor Already exist in this region"); 
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Distributor Licesence is not valid"); 
                    }
            }   else if(organization instanceof StatePharmaceauticalCompany){
                    ImplLogger.info("organization : StatePharmaceauticalCompany");
                    CityDistributor cityDistributor = (CityDistributor)registerTable.getValueAt(selectedRow, 1);
                    StatePharmaceauticalCompany statePharmaceauticalCompany = (StatePharmaceauticalCompany)organization;
                    if (cityDistributor.getLincense().isIsLicenseValid()){
                        if(null == statePharmaceauticalCompany.getDistributorList().get(cityDistributor.getLocation())){
                            statePharmaceauticalCompany.getDistributorList().put(cityDistributor.getLocation(), cityDistributor);
                            statePharmaceauticalCompany.getCityDistributorDirectory().addCityDistributor(cityDistributor);
                        } else {
                            JOptionPane.showMessageDialog(null, "Distributor Already exist in this region"); 
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Distributor Licesence is not valid"); 
                    }
            }   else if(organization instanceof RegionalDistributor){
                    ImplLogger.info("organization : RegionalDistributor");
                    NationalDistributor nationalDistributor = (NationalDistributor)registerTable.getValueAt(selectedRow, 1);
                    RegionalDistributor regionalDistributor = (RegionalDistributor)organization;
                    if (nationalDistributor.getLincense().isIsLicenseValid()){
                        if(null == regionalDistributor.getDistributorList().get(nationalDistributor.getLocation())){
                            regionalDistributor.getDistributorList().put(nationalDistributor.getLocation(), nationalDistributor);
                            regionalDistributor.getNationalDistributorDirectory().addNationalDistributor(nationalDistributor);
                        } else {
                            JOptionPane.showMessageDialog(null, "Distributor Already exist in this region"); 
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Distributor Licesence is not valid"); 
                    }
            }   else if(organization instanceof NationalDistributor){
                    ImplLogger.info("organization : NationalDistributor");
                    StateDistributor stateDistributor = (StateDistributor)registerTable.getValueAt(selectedRow, 1);
                    NationalDistributor nationalDistributor = (NationalDistributor)organization;
                    if (stateDistributor.getLincense().isIsLicenseValid()){
                        if(null == nationalDistributor.getDistributorList().get(stateDistributor.getLocation())){
                            nationalDistributor.getDistributorList().put(stateDistributor.getLocation(), stateDistributor);
                            nationalDistributor.getStateDistributorDirectory().addStateDistributor(stateDistributor);
                        } else {
                            JOptionPane.showMessageDialog(null, "Distributor Already exist in this region"); 
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Distributor Licesence is not valid"); 
                    }
            }   else if(organization instanceof StateDistributor){
                    ImplLogger.info("organization : StateDistributor");
                    CityDistributor cityDistributor = (CityDistributor)registerTable.getValueAt(selectedRow, 1);
                    StateDistributor stateDistributor = (StateDistributor)organization;
                    if (cityDistributor.getLincense().isIsLicenseValid()){
                        if(null == stateDistributor.getDistributorList().get(cityDistributor.getLocation())){
                            stateDistributor.getDistributorList().put(cityDistributor.getLocation(), cityDistributor);
                            stateDistributor.getCityDistributorDirectory().addCityDistributor(cityDistributor);
                        } else {
                            JOptionPane.showMessageDialog(null, "Distributor Already exist in this region"); 
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Distributor Licesence is not valid");
                    }
            }   else if(organization instanceof CityDistributor){
                    ImplLogger.info("organization : CityDistributor");
                    Organization organization1 = (Organization)registerTable.getValueAt(selectedRow, 1);
                    CityDistributor cityDistributor = (CityDistributor)organization;
                    if (organization1.getLincense().isIsLicenseValid()){
                        if(null == cityDistributor.getOrganizationDirectory().searchOrganization(organization1.getOrganizationID())){
                             cityDistributor.getOrganizationDirectory().addOrganization(organization1);
                        } else {
                            JOptionPane.showMessageDialog(null, "Distributor Already exist in this region"); 
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Distributor Licesence is not valid");
                    }
            }
            populateRegisteredTable();
            populateUnregisteredTable();
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_registerDistributorActionPerformed
    /**
     * unregister distributor
     * @param evt 
     */
    private void unregisterDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unregisterDistributorActionPerformed
        int selectedRow =  unRegisterTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            if(organization instanceof InterNationalPharmaceauticalCompany){
                ImplLogger.info("organization : InterNationalPharmaceauticalCompany");
                RegionalDistributor regionalDistributor = (RegionalDistributor)unRegisterTable.getValueAt(selectedRow, 1);
                InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany = (InterNationalPharmaceauticalCompany)organization;
                interNationalPharmaceauticalCompany.getDistributorList().remove(regionalDistributor.getLocation(), regionalDistributor);
                interNationalPharmaceauticalCompany.getRegionalDistributorDirectory().removeRegionalDistributor(regionalDistributor);

            }   else if(organization instanceof RegionalPharmaceauticalCompany){
                    ImplLogger.info("organization : RegionalPharmaceauticalCompany");
                    NationalDistributor nationalDistributor = (NationalDistributor)unRegisterTable.getValueAt(selectedRow, 1);
                    RegionalPharmaceauticalCompany regionalPharmaceauticalCompany = (RegionalPharmaceauticalCompany)organization;
                    regionalPharmaceauticalCompany.getDistributorList().remove(nationalDistributor.getLocation(), nationalDistributor);
                    regionalPharmaceauticalCompany.getNationalDistributorDirectory().removeNationalDistributor(nationalDistributor);

            }   else if(organization instanceof NationalPharmaceauticalCompany){
                    ImplLogger.info("organization : NationalPharmaceauticalCompany");
                    StateDistributor stateDistributor = (StateDistributor)unRegisterTable.getValueAt(selectedRow, 1);
                    NationalPharmaceauticalCompany nationalPharmaceauticalCompany = (NationalPharmaceauticalCompany)organization;
                    nationalPharmaceauticalCompany.getDistributorList().remove(stateDistributor.getLocation(), stateDistributor);
                    nationalPharmaceauticalCompany.getStateDistributorDirectory().removeStateDistributor(stateDistributor);
            }   else if(organization instanceof StatePharmaceauticalCompany){
                    ImplLogger.info("organization : StatePharmaceauticalCompany");
                    CityDistributor cityDistributor = (CityDistributor)unRegisterTable.getValueAt(selectedRow, 1);
                    StatePharmaceauticalCompany statePharmaceauticalCompany = (StatePharmaceauticalCompany)organization;
                    statePharmaceauticalCompany.getDistributorList().remove(cityDistributor.getLocation(), cityDistributor);
                    statePharmaceauticalCompany.getCityDistributorDirectory().removeCityDistributor(cityDistributor);
            }   else if(organization instanceof RegionalDistributor){
                    ImplLogger.info("organization : RegionalDistributor");
                    NationalDistributor nationalDistributor = (NationalDistributor)unRegisterTable.getValueAt(selectedRow, 1);
                    RegionalDistributor regionalDistributor = (RegionalDistributor)organization;
                    regionalDistributor.getDistributorList().remove(nationalDistributor.getLocation(), nationalDistributor);
                    regionalDistributor.getNationalDistributorDirectory().removeNationalDistributor(nationalDistributor);
            }   else if(organization instanceof NationalDistributor){
                    ImplLogger.info("organization : NationalDistributor");
                    StateDistributor stateDistributor = (StateDistributor)unRegisterTable.getValueAt(selectedRow, 1);
                    NationalDistributor nationalDistributor = (NationalDistributor)organization;
                    nationalDistributor.getDistributorList().remove(stateDistributor.getLocation(), stateDistributor);
                    nationalDistributor.getStateDistributorDirectory().removeStateDistributor(stateDistributor);
                   
            }   else if(organization instanceof StateDistributor){
                    ImplLogger.info("organization : StateDistributor");
                    CityDistributor cityDistributor = (CityDistributor)unRegisterTable.getValueAt(selectedRow, 1);
                    StateDistributor stateDistributor = (StateDistributor)organization;
                    stateDistributor.getDistributorList().remove(cityDistributor.getLocation(), cityDistributor);
                    stateDistributor.getCityDistributorDirectory().removeCityDistributor(cityDistributor);
                    
            }   else if(organization instanceof CityDistributor){
                    ImplLogger.info("organization : CityDistributor");
                    Organization organization1 = (Organization)unRegisterTable.getValueAt(selectedRow, 1);
                    CityDistributor cityDistributor = (CityDistributor)organization;
                    cityDistributor.getOrganizationDirectory().removeOrganization(organization1);
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton registerDistributor;
    private javax.swing.JTable registerTable;
    private javax.swing.JTable unRegisterTable;
    private javax.swing.JButton unregisterDistributor;
    // End of variables declaration//GEN-END:variables
}
