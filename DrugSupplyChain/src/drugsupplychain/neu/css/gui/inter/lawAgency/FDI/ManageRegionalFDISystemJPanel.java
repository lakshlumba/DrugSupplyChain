/*
 * Class : ManageRegionalFDISystemJPanel.java
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
package drugsupplychain.neu.css.gui.inter.lawAgency.FDI;

import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgencyDirectory;
import drugsupplychain.neu.css.model.request.LawAgencyCaseRequest;
import drugsupplychain.neu.css.model.request.WorkRequest;
import drugsupplychain.neu.css.util.ImplConst;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laksh
 */
public class ManageRegionalFDISystemJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final RegionalLawAgencyDirectory regionalLawAgencyDirectory;
    /**
     * Creates new form ManageRegionalFDISystemJPanel
     * @param userProcessContainer
     * @param regionalLawAgencyDirectory
     */
    public ManageRegionalFDISystemJPanel(JPanel userProcessContainer,RegionalLawAgencyDirectory regionalLawAgencyDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.regionalLawAgencyDirectory = regionalLawAgencyDirectory;
        populateTable();
        populateNotification();
    }
    private void populateNotification(){
        int notification = 0;
        for (RegionalLawAgency regionalLawAgency : regionalLawAgencyDirectory.getRegionalLawAgencyList()){
            for(WorkRequest workRequest : regionalLawAgency.getWorkQueue().getWorkRequestList()){
                LawAgencyCaseRequest lawAgencyCaseRequest = (LawAgencyCaseRequest)workRequest;
                if(null != lawAgencyCaseRequest && lawAgencyCaseRequest.getCaseStatus().equals(ImplConst.CASE_NEW)){
                    notification++;
                }
            }      
        }
        notificationLabel.setText(String.valueOf(notification));
    }
    /**
     * populate the table
     */
    private void populateTable(){
        DefaultTableModel defaultTableModel = (DefaultTableModel)regionalFDITable.getModel();
        defaultTableModel.setRowCount(0);
        for (RegionalLawAgency regionalLawAgency : regionalLawAgencyDirectory.getRegionalLawAgencyList()){
            Object[] row = new Object[4];
            row[0] = regionalLawAgency;
            row[1] = regionalLawAgency.getOrganizationID();
            row[2] = regionalLawAgency.getNationalLawAgencyDirectory().getNationalLawAgencyList().size();
            row[3] = regionalLawAgency.getWorkQueue().getWorkRequestList().size();
            defaultTableModel.addRow(row);            
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
        manageRegionalFDIButton = new javax.swing.JButton();
        maangeRegionalCasesButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        regionalFDITable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        notificationLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Manage Regional FDI");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 230, -1));

        manageRegionalFDIButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageRegionalFDIButton.setText("Register Regional FDI");
        manageRegionalFDIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRegionalFDIButtonActionPerformed(evt);
            }
        });
        add(manageRegionalFDIButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 180, 50));

        maangeRegionalCasesButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        maangeRegionalCasesButton.setText("Manage Regional Cases");
        maangeRegionalCasesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maangeRegionalCasesButtonActionPerformed(evt);
            }
        });
        add(maangeRegionalCasesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 180, 50));

        regionalFDITable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Region Name", "Id", "National FDIs", "Total Cases"
            }
        ));
        jScrollPane1.setViewportView(regionalFDITable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 570, 170));

        backButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 110, 40));

        refreshButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.add(notificationLabel);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, 20, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void manageRegionalFDIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRegionalFDIButtonActionPerformed
       RegisterRegionalFDIJPanel registerRegionalFDIJPanel = new RegisterRegionalFDIJPanel(userProcessContainer,regionalLawAgencyDirectory);
       userProcessContainer.add("RegisterRegionalFDIJPanel",registerRegionalFDIJPanel);
       CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_manageRegionalFDIButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        populateTable();
        populateNotification();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void maangeRegionalCasesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maangeRegionalCasesButtonActionPerformed
        int selectedRow =  regionalFDITable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            RegionalLawAgency regionalLawAgency = (RegionalLawAgency)regionalFDITable.getValueAt(selectedRow, 0);
            ManageRegionalCasesJPanel manageRegionalCasesJPanel = new ManageRegionalCasesJPanel(userProcessContainer,regionalLawAgency);
            userProcessContainer.add("ManageRegionalCasesJPanel",manageRegionalCasesJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }       
    }//GEN-LAST:event_maangeRegionalCasesButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton maangeRegionalCasesButton;
    private javax.swing.JButton manageRegionalFDIButton;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTable regionalFDITable;
    // End of variables declaration//GEN-END:variables
}
