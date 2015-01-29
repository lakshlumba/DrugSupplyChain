/*
 * Class : ManageRegionalCasesJPanel.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 12, 2014, 9:39:42 PM
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

import drugsupplychain.neu.css.gui.common.lawAgency.FDI.ViewFDICaseDetailsJPanel;
import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgency;
import drugsupplychain.neu.css.model.request.LawAgencyCaseRequest;
import drugsupplychain.neu.css.model.request.WorkRequest;
import drugsupplychain.neu.css.util.ImplCommonUtil;
import drugsupplychain.neu.css.util.ImplConst;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laksh
 */
public class ManageRegionalCasesJPanel extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private final RegionalLawAgency regionalLawAgency;
    /**
     * Creates new form ManageRegionalCasesJPanel
     * @param userProcessContainer
     * @param regionalLawAgency
     */
    public ManageRegionalCasesJPanel(JPanel userProcessContainer,RegionalLawAgency regionalLawAgency) {
        initComponents();
        ImplLogger.enterMethod();
        this.userProcessContainer = userProcessContainer;
        this.regionalLawAgency = regionalLawAgency;
        ImplLogger.exitMethod();
        populateTable();
    }
    /**
     * populate the table
     */
    private void populateTable(){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)regionalCaseTable.getModel();
        defaultTableModel.setRowCount(0);
        for (WorkRequest workRequest : regionalLawAgency.getWorkQueue().getWorkRequestList()){
            LawAgencyCaseRequest lawAgencyCaseRequest = (LawAgencyCaseRequest)workRequest;
            if (null != lawAgencyCaseRequest) {
                Object[] row = new Object[4];
                row[0] = lawAgencyCaseRequest;
                row[1] = lawAgencyCaseRequest.getCaseDescription();
                row[2] = lawAgencyCaseRequest.getCaseStatus();
                row[3] = regionalLawAgency.getName();
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
        approveButton = new javax.swing.JButton();
        viewDetailsButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        regionalCaseTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Manage Regional Cases");

        approveButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        approveButton.setText("Approve");
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
            }
        });

        viewDetailsButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        viewDetailsButton.setText("View Case Details");
        viewDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsButtonActionPerformed(evt);
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

        regionalCaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Case Id", "Case description", "Status", "Opened By (Region)"
            }
        ));
        jScrollPane1.setViewportView(regionalCaseTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(182, 182, 182))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(viewDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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
     * approove the button
     * @param evt 
     */
    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  regionalCaseTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            LawAgencyCaseRequest lawAgencyCaseRequest = (LawAgencyCaseRequest)regionalCaseTable.getValueAt(selectedRow, 0);
            lawAgencyCaseRequest.setCaseStatus(ImplConst.CASE_APPROVED);
            lawAgencyCaseRequest.setResolveDate(ImplCommonUtil.getTodaysDateBYDATE());
            refresh();
        } 
        ImplLogger.exitMethod();
        
    }//GEN-LAST:event_approveButtonActionPerformed
    /**
     * view the request details
     * @param evt 
     */
    private void viewDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsButtonActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  regionalCaseTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            LawAgencyCaseRequest lawAgencyCaseRequest = (LawAgencyCaseRequest)regionalCaseTable.getValueAt(selectedRow, 0);
            lawAgencyCaseRequest.setCaseStatus(ImplConst.CASE_PENDING);
            ViewFDICaseDetailsJPanel viewFDICaseDetailsJPanel = new ViewFDICaseDetailsJPanel(userProcessContainer,lawAgencyCaseRequest,null);
            userProcessContainer.add("ViewFDICaseDetailsJPanel",viewFDICaseDetailsJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        } 
        ImplLogger.exitMethod();
    }//GEN-LAST:event_viewDetailsButtonActionPerformed
    /**
     * refresh the table
     */
    private void refresh(){
        populateTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable regionalCaseTable;
    private javax.swing.JButton viewDetailsButton;
    // End of variables declaration//GEN-END:variables
}
