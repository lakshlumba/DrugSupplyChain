/*
 * Class : ManageWorkRequestsJPanel.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 15, 2014, 3:15:08 PM
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
package drugsupplychain.neu.css.gui.common.lawAgency.FDI;

import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.LawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.NationalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.StateLawAgency;
import drugsupplychain.neu.css.model.request.LawAgencyCaseRequest;
import drugsupplychain.neu.css.model.request.WorkRequest;
import drugsupplychain.neu.css.model.user.UserAccount;
import drugsupplychain.neu.css.util.ImplCommonUtil;
import drugsupplychain.neu.css.util.ImplConst;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laksh
 */
public class CraeteCaseRequestsJPanel extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private final LawAgency lawAgency;
    private final UserAccount userAccount;
    /**
     * Creates new form ManageWorkRequestsJPanel
     * @param userProcessContainer
     * @param lawAgency
     * @param userAccount
     */
    public CraeteCaseRequestsJPanel(JPanel userProcessContainer,UserAccount userAccount,LawAgency lawAgency) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.lawAgency = lawAgency;
        populateTable();
    }
    /**
     * 
     */
    private void populateTable(){
        DefaultTableModel defaultTableModel = (DefaultTableModel)regionalCaseTable.getModel();
        defaultTableModel.setRowCount(0);
        for (WorkRequest workRequest : lawAgency.getWorkQueue().getWorkRequestList()){
                LawAgencyCaseRequest lawAgencyCaseRequest = (LawAgencyCaseRequest)workRequest;
                Object[] row = new Object[6];
                row[0] = lawAgencyCaseRequest;
                row[1] = lawAgencyCaseRequest.getCaseDescription();
                row[2] = lawAgencyCaseRequest.getSender();
                row[3] = lawAgencyCaseRequest.getRequestDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getRequestDate());
                row[4] = lawAgencyCaseRequest.getResolveDate() == null ? ImplConst.EMPTY : ImplCommonUtil.getFormattedDate(workRequest.getResolveDate());
                row[5] = lawAgencyCaseRequest.getStatus();
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
        createNewRequest = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        regionalCaseTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageTextField = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Create Case Request  ");

        createNewRequest.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        createNewRequest.setText("Create New Request");
        createNewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewRequestActionPerformed(evt);
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
                "CaseId", "Description", "Sender", "Request Date", "Resolve Date", "Status"
            }
        ));
        jScrollPane1.setViewportView(regionalCaseTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Description");

        messageTextField.setColumns(20);
        messageTextField.setRows(5);
        jScrollPane2.setViewportView(messageTextField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(191, 191, 191)))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createNewRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createNewRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createNewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewRequestActionPerformed
        LawAgencyCaseRequest lawAgencyCaseRequest = null;
        if (lawAgency instanceof CityLawAgency){
            lawAgencyCaseRequest = new LawAgencyCaseRequest(ImplConst.CITY_FDI);
        } else if (lawAgency instanceof StateLawAgency){
            lawAgencyCaseRequest = new LawAgencyCaseRequest(ImplConst.STATE_FDI);
        } else if (lawAgency instanceof NationalLawAgency){
            lawAgencyCaseRequest = new LawAgencyCaseRequest(ImplConst.NATIONAL_FDI);
        } else if (lawAgency instanceof RegionalLawAgency){
            lawAgencyCaseRequest = new LawAgencyCaseRequest(ImplConst.REGIONAL_FDI);
        }
       lawAgencyCaseRequest.setCaseDescription(new StringBuffer(messageTextField.getText()));
       lawAgencyCaseRequest.setRequestDate(ImplCommonUtil.getTodaysDateBYDATE());
       lawAgencyCaseRequest.setSender(userAccount);
       lawAgencyCaseRequest.setCaseStatus(ImplConst.CASE_NEW);
       lawAgency.getWorkQueue().getWorkRequestList().add(lawAgencyCaseRequest);
       populateTable();               
    }//GEN-LAST:event_createNewRequestActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton createNewRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageTextField;
    private javax.swing.JTable regionalCaseTable;
    // End of variables declaration//GEN-END:variables
}
