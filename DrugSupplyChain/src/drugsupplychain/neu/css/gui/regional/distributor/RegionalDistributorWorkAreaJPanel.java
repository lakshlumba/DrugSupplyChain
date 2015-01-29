/*
 * Class : RegionalDistributorWorkAreaJPanel.java
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
package drugsupplychain.neu.css.gui.regional.distributor;

import drugsupplychain.neu.css.gui.common.distributor.BrowseProductCatalogJPanel;
import drugsupplychain.neu.css.gui.common.distributor.CreateRequestForProductJPanel;
import drugsupplychain.neu.css.gui.common.distributor.ManageProductCatalogJPanel;
import drugsupplychain.neu.css.gui.common.panel.ManageDistributorsJPanel;
import drugsupplychain.neu.css.gui.common.panel.ManageWorkRequestsJPanel;
import drugsupplychain.neu.css.gui.common.panel.UpdateContactJPanel;
import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.FDI.FDISystem;
import drugsupplychain.neu.css.model.distributor.RegionalDistributor;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgency;
import drugsupplychain.neu.css.model.user.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Laksh
 */
public class RegionalDistributorWorkAreaJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final UserAccount userAccount;
    private final RegionalDistributor regionalDistributor;
    private final FDISystem fDISystem;
    private final RegionalLawAgency regionalLawAgency;
    /**
     * Creates new form RegionalDistributorWorkAreaJPanel
     * @param userProcessContainer
     * @param userAccount
     * @param organization
     * @param regionalLawAgency
     * @param fDISystem
     */
    public RegionalDistributorWorkAreaJPanel(JPanel userProcessContainer,UserAccount userAccount,Organization organization,RegionalLawAgency regionalLawAgency,FDISystem fDISystem) {
        initComponents();
        ImplLogger.enterMethod();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.regionalDistributor = (RegionalDistributor)organization; 
        this.fDISystem = fDISystem;
        this.regionalLawAgency = regionalLawAgency;
        ImplLogger.exitMethod();
        enableFunctionality();
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
     * enable the functionality of National distributor
     */
    private void enableFunctionality(){
        ImplLogger.enterMethod();
        if (!regionalDistributor.getLincense().isIsLicenseValid()){
            ImplLogger.info("RegionalDistributor lincense is not valid");
            shopPharmaProduct.setEnabled(false);
            managePharmaProduct.setEnabled(false);
            createProductRequest.setEnabled(false);
            distributorsRequest.setEnabled(false);
        } else{
            ImplLogger.info("RegionalDistributor lincense is valid");
            shopPharmaProduct.setEnabled(true);
            managePharmaProduct.setEnabled(true);
            createProductRequest.setEnabled(true);
            distributorsRequest.setEnabled(true);
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        managePharmaProduct = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        updateContact = new javax.swing.JButton();
        createProductRequest = new javax.swing.JButton();
        shopPharmaProduct = new javax.swing.JButton();
        distributorsRequest = new javax.swing.JButton();
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
        manageRequest = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        fdiProcessContainerPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSplitPane1.setDividerLocation(220);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        managePharmaProduct.setBackground(new java.awt.Color(255, 255, 255));
        managePharmaProduct.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        managePharmaProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Folder.png"))); // NOI18N
        managePharmaProduct.setText("Manage Product");
        managePharmaProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePharmaProductActionPerformed(evt);
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

        createProductRequest.setBackground(new java.awt.Color(255, 255, 255));
        createProductRequest.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        createProductRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Folder.png"))); // NOI18N
        createProductRequest.setText("Request More Product ");
        createProductRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProductRequestActionPerformed(evt);
            }
        });

        shopPharmaProduct.setBackground(new java.awt.Color(255, 255, 255));
        shopPharmaProduct.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        shopPharmaProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Folder.png"))); // NOI18N
        shopPharmaProduct.setText("Shop Product");
        shopPharmaProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopPharmaProductActionPerformed(evt);
            }
        });

        distributorsRequest.setBackground(new java.awt.Color(255, 255, 255));
        distributorsRequest.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        distributorsRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Folder.png"))); // NOI18N
        distributorsRequest.setText("Manage Distriburs ");
        distributorsRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distributorsRequestActionPerformed(evt);
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

        manageRequest.setBackground(new java.awt.Color(255, 255, 255));
        manageRequest.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/Folder.png"))); // NOI18N
        manageRequest.setText("Request Law Agency");
        manageRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(updateContact)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1))
            .addComponent(createProductRequest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
            .addComponent(managePharmaProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(shopPharmaProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(distributorsRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(manageRequest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addComponent(managePharmaProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shopPharmaProduct)
                .addGap(9, 9, 9)
                .addComponent(createProductRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(distributorsRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(updateContact)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(60, 60, 60))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        fdiProcessContainerPanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout fdiProcessContainerPanelLayout = new javax.swing.GroupLayout(fdiProcessContainerPanel);
        fdiProcessContainerPanel.setLayout(fdiProcessContainerPanelLayout);
        fdiProcessContainerPanelLayout.setHorizontalGroup(
            fdiProcessContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        fdiProcessContainerPanelLayout.setVerticalGroup(
            fdiProcessContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(fdiProcessContainerPanel);

        add(jSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -5, 960, 630));
    }// </editor-fold>//GEN-END:initComponents

    private void manageRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRequestActionPerformed
        ImplLogger.enterMethod();
        ManageWorkRequestsJPanel manageWorkRequestsJPanel = new ManageWorkRequestsJPanel(userProcessContainer,regionalDistributor,userAccount);
        userProcessContainer.add("ManageWorkRequestsJPanel",manageWorkRequestsJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_manageRequestActionPerformed

    private void distributorsRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distributorsRequestActionPerformed
        ImplLogger.enterMethod();
        ManageDistributorsJPanel manageDistributorsJPanel = new ManageDistributorsJPanel(userProcessContainer,userAccount,regionalDistributor,regionalLawAgency);
        userProcessContainer.add("ManageDistributorsJPanel",manageDistributorsJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_distributorsRequestActionPerformed

    private void shopPharmaProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopPharmaProductActionPerformed
        ImplLogger.enterMethod();
        BrowseProductCatalogJPanel browseProductCatalogJPanel = new BrowseProductCatalogJPanel(userProcessContainer,regionalDistributor,regionalLawAgency,fDISystem);
        userProcessContainer.add("BrowseProductCatalogJPanel",browseProductCatalogJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_shopPharmaProductActionPerformed

    private void createProductRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProductRequestActionPerformed
        ImplLogger.enterMethod();
        CreateRequestForProductJPanel createRequestForProductJPanel = new CreateRequestForProductJPanel(userProcessContainer,userAccount,regionalDistributor,regionalLawAgency,fDISystem);
        userProcessContainer.add("CreateRequestForProductJPanel",createRequestForProductJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_createProductRequestActionPerformed

    private void updateContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateContactActionPerformed
        ImplLogger.enterMethod();
        UpdateContactJPanel updateContactJPanel = new UpdateContactJPanel(userProcessContainer,regionalDistributor);
        userProcessContainer.add("UpdateContactJPanel",updateContactJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_updateContactActionPerformed

    private void managePharmaProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePharmaProductActionPerformed
        ImplLogger.enterMethod();
        ManageProductCatalogJPanel manageProductCatalogJPanel = new ManageProductCatalogJPanel(userProcessContainer,regionalDistributor);
        userProcessContainer.add("ManageProductCatalogJPanel",manageProductCatalogJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_managePharmaProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address1Label;
    private javax.swing.JLabel address2Label;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JButton createProductRequest;
    private javax.swing.JButton distributorsRequest;
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton managePharmaProduct;
    private javax.swing.JButton manageRequest;
    private javax.swing.JLabel nationLabel;
    private javax.swing.JButton shopPharmaProduct;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JButton updateContact;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel zipLabel;
    // End of variables declaration//GEN-END:variables
}