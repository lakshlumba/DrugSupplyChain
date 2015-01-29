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
package drugsupplychain.neu.css.gui.common.lawAgency.pharma;

import drugsupplychain.neu.css.model.organization.pharmacompany.PharmaceauticalCompany;
import drugsupplychain.neu.css.model.request.DistributorsRequest;
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
public class ManagePharmaRequestsJPanel extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private final PharmaceauticalCompany pharmaceauticalCompany ;
    /**
     * Creates new form ManagePharmaRequestsJPanel
     * @param userProcessContainer
     * @param pharmaceauticalCompany
     */
    public ManagePharmaRequestsJPanel(JPanel userProcessContainer,PharmaceauticalCompany pharmaceauticalCompany) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.pharmaceauticalCompany = pharmaceauticalCompany;
        populateTable();
    }
    /**
     * populate report table
     */
    private void populateTable(){
        DefaultTableModel defaultTableModel = (DefaultTableModel)regionalCaseTable.getModel();
        defaultTableModel.setRowCount(0);
        for (WorkRequest workRequest : pharmaceauticalCompany.getWorkQueue().getWorkRequestList()){
                if (! (workRequest instanceof DistributorsRequest)){
                    Object[] row = new Object[5];
                    row[0] = workRequest;
                    row[1] = workRequest.getSender();
                    row[2] = workRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getRequestDate());
                    row[3] = workRequest.getResolveDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getResolveDate());
                    row[4] = workRequest.getStatus();
                    defaultTableModel.addRow(row);            
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
        approveButton = new javax.swing.JButton();
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
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Request Date", "Resolve Date", "Status"
            }
        ));
        jScrollPane1.setViewportView(regionalCaseTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(677, 677, 677)
                        .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(344, 344, 344)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
        int selectedRow =  regionalCaseTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            WorkRequest workRequest = (WorkRequest)regionalCaseTable.getValueAt(selectedRow, 0);
            workRequest.setStatus(ImplConst.CASE_APPROVED);
            workRequest.setResolveDate(ImplCommonUtil.getTodaysDateBYDATE());
            refresh();
        } 
        
    }//GEN-LAST:event_approveButtonActionPerformed
    private void refresh(){
        populateTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable regionalCaseTable;
    // End of variables declaration//GEN-END:variables
}
