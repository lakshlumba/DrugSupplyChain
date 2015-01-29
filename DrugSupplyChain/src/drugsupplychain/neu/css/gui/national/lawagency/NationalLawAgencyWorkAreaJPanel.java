/*
 * Class : NationalLawAgencyWorkAreaJPanel.java
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
package drugsupplychain.neu.css.gui.national.lawagency;

import drugsupplychain.neu.css.gui.common.lawAgency.FDI.CraeteCaseRequestsJPanel;
import drugsupplychain.neu.css.gui.common.panel.UpdateContactJPanel;
import drugsupplychain.neu.css.gui.national.lawagency.FDI.ManageStateFDISystemJPanel;
import drugsupplychain.neu.css.gui.national.lawagency.distributors.ManageNationalDistributorsJPanel;
import drugsupplychain.neu.css.gui.national.lawagency.pharma.ManageNationalPharmaCompanyJPanel;
import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.organization.lawAgencies.NationalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgency;
import drugsupplychain.neu.css.model.user.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Laksh
 */
public class NationalLawAgencyWorkAreaJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final UserAccount userAccount;
    private final NationalLawAgency nationalLawAgency;
    private final RegionalLawAgency regionalLawAgency;
    /**
     * Creates new form NationalLawAgencyWorkAreaJPanel
     * @param userProcessContainer
     * @param userAccount
     * @param nationalLawAgency
     * @param regionalLawAgency
     */
    public NationalLawAgencyWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount,NationalLawAgency nationalLawAgency,RegionalLawAgency regionalLawAgency) {
        initComponents();
        ImplLogger.enterMethod();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.nationalLawAgency = nationalLawAgency;
        this.regionalLawAgency = regionalLawAgency;  
        ImplLogger.exitMethod();
        populateAddressInfo();
    }
    /**
     * populate the address info
     */
    private void populateAddressInfo(){
        userNameLabel.setText(userAccount.getUsername());
        address1Label.setText(userAccount.getPerson().getAddress().getAddressLine1());
        address2Label.setText(userAccount.getPerson().getAddress().getAddressLine2());
        cityLabel.setText(userAccount.getPerson().getAddress().getCity());
        stateLabel.setText(userAccount.getPerson().getAddress().getState());
        nationLabel.setText(userAccount.getPerson().getAddress().getCountry());
        zipLabel.setText(userAccount.getPerson().getAddress().getZipcode());
        emailLabel.setText(userAccount.getPerson().getEmail());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        managePharmaCompanyButton = new javax.swing.JButton();
        manageStateFDIButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        updateContact = new javax.swing.JButton();
        manageNationalDistributor = new javax.swing.JButton();
        createCase = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        address1Label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        address2Label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        nationLabel = new javax.swing.JLabel();
        zipLabel = new javax.swing.JLabel();
        fdiProcessContainerPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSplitPane1.setDividerLocation(200);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        managePharmaCompanyButton.setBackground(new java.awt.Color(255, 255, 255));
        managePharmaCompanyButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        managePharmaCompanyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Folder.png"))); // NOI18N
        managePharmaCompanyButton.setText("National Pharama Co.");
        managePharmaCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePharmaCompanyButtonActionPerformed(evt);
            }
        });

        manageStateFDIButton.setBackground(new java.awt.Color(255, 255, 255));
        manageStateFDIButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageStateFDIButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Folder.png"))); // NOI18N
        manageStateFDIButton.setText(" State FDI          ");
        manageStateFDIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStateFDIButtonActionPerformed(evt);
            }
        });

        updateContact.setBackground(new java.awt.Color(255, 255, 255));
        updateContact.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        updateContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Folder.png"))); // NOI18N
        updateContact.setText("Update Contact");
        updateContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateContactActionPerformed(evt);
            }
        });

        manageNationalDistributor.setBackground(new java.awt.Color(255, 255, 255));
        manageNationalDistributor.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageNationalDistributor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Folder.png"))); // NOI18N
        manageNationalDistributor.setText("National Distributor");
        manageNationalDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNationalDistributorActionPerformed(evt);
            }
        });

        createCase.setBackground(new java.awt.Color(255, 255, 255));
        createCase.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        createCase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Folder.png"))); // NOI18N
        createCase.setText("Create Case");
        createCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCaseActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel10.setText("Email : ");

        emailLabel.setText("email");

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setText("Username:");

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Address:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel4.setText("City:");

        userNameLabel.setText("user");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel5.setText("State:");

        address1Label.setText("address1");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel6.setText("Country:");

        address2Label.setText("address2");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel7.setText("Zip Code:");

        cityLabel.setText("city");

        stateLabel.setText("state");

        nationLabel.setText("nation");

        zipLabel.setText("zip");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(managePharmaCompanyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageStateFDIButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageNationalDistributor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createCase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateContact)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zipLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nationLabel))
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userNameLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityLabel)
                            .addComponent(stateLabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(address1Label)
                        .addGap(24, 24, 24)
                        .addComponent(address2Label)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(managePharmaCompanyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageStateFDIButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageNationalDistributor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createCase)
                .addGap(9, 9, 9)
                .addComponent(updateContact)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userNameLabel))
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(address2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(address1Label)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cityLabel))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(stateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nationLabel))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(zipLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(emailLabel))
                .addGap(24, 24, 24))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        fdiProcessContainerPanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout fdiProcessContainerPanelLayout = new javax.swing.GroupLayout(fdiProcessContainerPanel);
        fdiProcessContainerPanel.setLayout(fdiProcessContainerPanelLayout);
        fdiProcessContainerPanelLayout.setHorizontalGroup(
            fdiProcessContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        fdiProcessContainerPanelLayout.setVerticalGroup(
            fdiProcessContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(fdiProcessContainerPanel);

        add(jSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -5, 840, 530));
    }// </editor-fold>//GEN-END:initComponents
    /**
     * manage state
     * @param evt 
     */
    private void manageStateFDIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStateFDIButtonActionPerformed
       ImplLogger.enterMethod();
       ManageStateFDISystemJPanel manageStateFDISystemJPanel = new ManageStateFDISystemJPanel(userProcessContainer,nationalLawAgency);
       userProcessContainer.add("ManageNationalFDISystemJPanel",manageStateFDISystemJPanel);
       CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
       ImplLogger.exitMethod();
    }//GEN-LAST:event_manageStateFDIButtonActionPerformed
    /**
     * manage pharama company
     * @param evt 
     */
    private void managePharmaCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePharmaCompanyButtonActionPerformed
       ImplLogger.enterMethod();
       ManageNationalPharmaCompanyJPanel manageNationalPharmaCompanyJPanel = new ManageNationalPharmaCompanyJPanel(userProcessContainer,nationalLawAgency,nationalLawAgency.getName());
       userProcessContainer.add("ManageNationalPharmaCompanyJPanel",manageNationalPharmaCompanyJPanel);
       CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
       ImplLogger.exitMethod();
    }//GEN-LAST:event_managePharmaCompanyButtonActionPerformed
    /**
     * update contact
     * @param evt 
     */
    private void updateContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateContactActionPerformed
       ImplLogger.enterMethod();
       UpdateContactJPanel updateContactJPanel = new UpdateContactJPanel(userProcessContainer,nationalLawAgency);
       userProcessContainer.add("UpdateContactJPanel",updateContactJPanel);
       CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
       ImplLogger.exitMethod();
    }//GEN-LAST:event_updateContactActionPerformed
    /**
     * manage national distributor
     * @param evt 
     */
    private void manageNationalDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNationalDistributorActionPerformed
       ImplLogger.enterMethod();
       ManageNationalDistributorsJPanel manageNationalDistributorsJPanel = new ManageNationalDistributorsJPanel(userProcessContainer,regionalLawAgency,nationalLawAgency);
       userProcessContainer.add("ManageNationalDistributorsJPanel",manageNationalDistributorsJPanel);
       CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
       ImplLogger.exitMethod();
    }//GEN-LAST:event_manageNationalDistributorActionPerformed
    /**
     * create case
     * @param evt 
     */
    private void createCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCaseActionPerformed
        ImplLogger.enterMethod();
        CraeteCaseRequestsJPanel craeteCaseRequestsJPanel = new CraeteCaseRequestsJPanel(userProcessContainer,userAccount,nationalLawAgency);
        userProcessContainer.add("CraeteCaseRequestsJPanel",craeteCaseRequestsJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_createCaseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address1Label;
    private javax.swing.JLabel address2Label;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JButton createCase;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel fdiProcessContainerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton manageNationalDistributor;
    private javax.swing.JButton managePharmaCompanyButton;
    private javax.swing.JButton manageStateFDIButton;
    private javax.swing.JLabel nationLabel;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JButton updateContact;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel zipLabel;
    // End of variables declaration//GEN-END:variables
}
