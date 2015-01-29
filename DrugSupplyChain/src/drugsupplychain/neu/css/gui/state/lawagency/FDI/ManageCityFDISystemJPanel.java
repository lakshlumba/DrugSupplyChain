/*
 * Class : FDISystemAdminWorkAreaJPanel.java
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
package drugsupplychain.neu.css.gui.state.lawagency.FDI;

import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgencyDirectory;
import drugsupplychain.neu.css.model.organization.lawAgencies.StateLawAgency;
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
public class ManageCityFDISystemJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final CityLawAgencyDirectory cityLawAgencyDirectory;
    private final StateLawAgency stateLawAgency;
    private final String stateName;
    /**
     * Creates new form ManageCityFDISystemJPanel
     * @param userProcessContainer
     * @param stateLawAgency
     */
    public ManageCityFDISystemJPanel(JPanel userProcessContainer,StateLawAgency stateLawAgency) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.cityLawAgencyDirectory = stateLawAgency.getCityLawAgencyDirectory();
        this.stateLawAgency = stateLawAgency;
        this.stateName = stateLawAgency.getName();
        populateNotification();
        
    }
    private void populateNotification(){
        int notification = 0;
        for (CityLawAgency cityLawAgency : cityLawAgencyDirectory.getCityLawAgencyList()){
            for(WorkRequest workRequest : cityLawAgency.getWorkQueue().getWorkRequestList()){
                LawAgencyCaseRequest lawAgencyCaseRequest = (LawAgencyCaseRequest)workRequest;
                if(lawAgencyCaseRequest.getCaseStatus().equals(ImplConst.CASE_NEW)){
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
        DefaultTableModel defaultTableModel = (DefaultTableModel)cityFDITable.getModel();
        defaultTableModel.setRowCount(0);
        for (CityLawAgency cityLawAgency : cityLawAgencyDirectory.getCityLawAgencyList()){
            Object[] row = new Object[4];
            row[0] = cityLawAgency;
            row[1] = cityLawAgency.getOrganizationID();
            //row[2] = cityLawAgency.getOrganizationDirectory().getOrganizationList().size();
            row[3] = cityLawAgency.getWorkQueue().getWorkRequestList().size();
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
        manageCityFDIButton = new javax.swing.JButton();
        maangeCityCasesButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cityFDITable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        notificationLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Manage City FDI");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 230, -1));

        manageCityFDIButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        manageCityFDIButton.setText("Register City FDI");
        manageCityFDIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCityFDIButtonActionPerformed(evt);
            }
        });
        add(manageCityFDIButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 180, 50));

        maangeCityCasesButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        maangeCityCasesButton.setText("Manage City Cases");
        maangeCityCasesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maangeCityCasesButtonActionPerformed(evt);
            }
        });
        add(maangeCityCasesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 180, 50));

        cityFDITable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "City Name", "Id", "City FDIs", "Open Cases"
            }
        ));
        jScrollPane1.setViewportView(cityFDITable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 510, 170));

        backButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 110, 40));

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

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 20, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void manageCityFDIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCityFDIButtonActionPerformed
       RegisterCityFDIJPanel registerCityFDIJPanel = new RegisterCityFDIJPanel(userProcessContainer,cityLawAgencyDirectory,stateName);
       userProcessContainer.add("RegisterCityFDIJPanel",registerCityFDIJPanel);
       CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
       cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_manageCityFDIButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        populateTable();
        populateNotification();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void maangeCityCasesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maangeCityCasesButtonActionPerformed
        int selectedRow =  cityFDITable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            CityLawAgency cityLawAgency = (CityLawAgency)cityFDITable.getValueAt(selectedRow, 0);
            ManageCityCasesJPanel manageCityCasesJPanel = new ManageCityCasesJPanel(userProcessContainer,cityLawAgency,stateLawAgency);
            userProcessContainer.add("ManageCityCasesJPanel",manageCityCasesJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }       
    }//GEN-LAST:event_maangeCityCasesButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTable cityFDITable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton maangeCityCasesButton;
    private javax.swing.JButton manageCityFDIButton;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
