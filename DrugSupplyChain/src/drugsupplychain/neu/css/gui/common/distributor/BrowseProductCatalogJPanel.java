/*
 * Class : BrowseProductCatalogJPanel.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 16, 2014, 6:45:25 PM
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
package drugsupplychain.neu.css.gui.common.distributor;

import drugsupplychain.neu.css.gui.common.panel.ViewMedicineDetails;
import drugsupplychain.neu.css.log.ImplLogger;
import drugsupplychain.neu.css.model.FDI.FDISystem;
import drugsupplychain.neu.css.model.distributor.CityDistributor;
import drugsupplychain.neu.css.model.distributor.Distributor;
import drugsupplychain.neu.css.model.distributor.NationalDistributor;
import drugsupplychain.neu.css.model.distributor.RegionalDistributor;
import drugsupplychain.neu.css.model.distributor.StateDistributor;
import drugsupplychain.neu.css.model.order.Order;
import drugsupplychain.neu.css.model.order.OrderItem;
import drugsupplychain.neu.css.model.organization.Organization;
import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.LawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.NationalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.RegionalLawAgency;
import drugsupplychain.neu.css.model.organization.lawAgencies.StateLawAgency;
import drugsupplychain.neu.css.model.organization.other.ClinicOrganization;
import drugsupplychain.neu.css.model.organization.other.DispenceryOrganization;
import drugsupplychain.neu.css.model.organization.other.DoctorOrganization;
import drugsupplychain.neu.css.model.organization.other.HospitalOrganization;
import drugsupplychain.neu.css.model.organization.other.PatientOrganization;
import drugsupplychain.neu.css.model.organization.other.PharmacyOrganization;
import drugsupplychain.neu.css.model.organization.pharmacompany.InterNationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.NationalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.PharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.RegionalPharmaceauticalCompany;
import drugsupplychain.neu.css.model.organization.pharmacompany.StatePharmaceauticalCompany;
import drugsupplychain.neu.css.model.product.Product;
import drugsupplychain.neu.css.model.product.ProductItem;
import drugsupplychain.neu.css.util.ImplCommonUtil;
import drugsupplychain.neu.css.util.ImplValidationUtils;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laksh
 */
public class BrowseProductCatalogJPanel extends javax.swing.JPanel {
    private final JPanel userProcessContainer;
    private final Distributor distributor;
    private final LawAgency lawAgency;
    private final FDISystem fDISystem;
    private Order order;
    /**
     * Creates new form BrowseProductCatalogJPanel
     * @param userProcessContainer
     * @param distributor
     * @param lawAgency
     * @param fDISystem
     */
    public BrowseProductCatalogJPanel(JPanel userProcessContainer,Distributor distributor,LawAgency lawAgency,FDISystem fDISystem) {
        initComponents();
        ImplLogger.enterMethod();
        this.distributor = distributor;
        this.lawAgency = lawAgency;
        this.fDISystem = fDISystem;
        this.userProcessContainer = userProcessContainer;
        order = new Order();
        ImplLogger.exitMethod();
        populateTable();        
    }
    /**
     * populate table
     */
    private void populateTable(){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)productTable.getModel();
        defaultTableModel.setRowCount(0);
        if (distributor instanceof CityDistributor){
            ImplLogger.info("Product catalog for CityDistributor");
            NationalLawAgency nationaLawAgency = (NationalLawAgency)lawAgency;
            if (null != nationaLawAgency){
                for (StateLawAgency stateLawAgency : nationaLawAgency.getStateLawAgencyDirectory().getStateLawAgencyList()){
                    for (StatePharmaceauticalCompany statePharmaceauticalCompany : stateLawAgency.getStatePharmaceauticalCompanyDirectory().getStatePharmaceauticalCompanyList()){
                        if (null != statePharmaceauticalCompany.getCityDistributorDirectory().searchCityDistributor(distributor.getOrganizationID())){
                            for (Product product :  statePharmaceauticalCompany.getProductCatalog().getProductList()){
                                if (product.getMedicineLincense().isIsLicenseValid()){
                                    Object[] row = new Object[8];
                                    row[0] = product;
                                    row[1] = product.getProductName();            
                                    row[2] = product.getAvailable();
                                    row[3] = product.getPrice();
                                    row[4] = product.getMedicineLincense().getLicenseNumber();
                                    row[5] = ImplCommonUtil.getFormattedDate(product.getExpiryDate());
                                    row[6] = statePharmaceauticalCompany.getOrganizationID();
                                    row[7] = statePharmaceauticalCompany;
                                    defaultTableModel.addRow(row);
                                }    
                            }
                        }
                    }        
                }
                 for (StateLawAgency stateLawAgency : nationaLawAgency.getStateLawAgencyDirectory().getStateLawAgencyList()){
                    for (StateDistributor stateDistributor : stateLawAgency.getStateDistributorDirectory().getStateDistributorList()){
                        if (null != stateDistributor.getCityDistributorDirectory().searchCityDistributor(distributor.getOrganizationID())){
                            for (ProductItem productItem :  stateDistributor.getProductCatalog().getProductItems()){   
                                if (productItem.getProduct().getMedicineLincense().isIsLicenseValid()){
                                    Object[] row = new Object[8];
                                    row[0] = productItem;
                                    row[1] = productItem.getProduct().getProductName();            
                                    row[2] = productItem.getQuantity();
                                    row[3] = productItem.getProduct().getPrice();
                                    row[4] = productItem.getProduct().getMedicineLincense().getLicenseNumber();
                                    row[5] = ImplCommonUtil.getFormattedDate(productItem.getProduct().getExpiryDate());
                                    row[6] = stateDistributor.getOrganizationID();
                                    row[7] = stateDistributor;
                                    defaultTableModel.addRow(row);  
                                }  
                            }
                        }
                    }        
                }
            }
        }
        if (distributor instanceof StateDistributor){
            ImplLogger.info("Product catalog for StateDistributor");
            RegionalLawAgency regionalLawAgency = (RegionalLawAgency)lawAgency;
            if (null != regionalLawAgency){
                for (NationalLawAgency nationalLawAgency : regionalLawAgency.getNationalLawAgencyDirectory().getNationalLawAgencyList()){
                    for (NationalPharmaceauticalCompany nationalPharmaceauticalCompany : nationalLawAgency.getNationalPharmaceauticalCompanyDirectory().getNationalPharmaceauticalCompanyList()){
                        if (null != nationalPharmaceauticalCompany.getStateDistributorDirectory().searchStateDistributor(distributor.getOrganizationID())){
                            for (Product product :  nationalPharmaceauticalCompany.getProductCatalog().getProductList()){   
                                if (product.getMedicineLincense().isIsLicenseValid()){
                                    Object[] row = new Object[8];
                                    row[0] = product;
                                    row[1] = product.getProductName();            
                                    row[2] = product.getAvailable();
                                    row[3] = product.getPrice();
                                    row[4] = product.getMedicineLincense().getLicenseNumber();
                                    row[5] = ImplCommonUtil.getFormattedDate(product.getExpiryDate());
                                    row[6] = nationalPharmaceauticalCompany.getOrganizationID();
                                    row[7] = nationalPharmaceauticalCompany;
                                    defaultTableModel.addRow(row);
                                }    
                            }
                        }
                    }        
                }
                for (NationalLawAgency nationalLawAgency : regionalLawAgency.getNationalLawAgencyDirectory().getNationalLawAgencyList()){
                    for (NationalDistributor nationalDistributor : nationalLawAgency.getNationalDistributorDirectory().getNationalDistributorList()){
                        if (null != nationalDistributor.getStateDistributorDirectory().searchStateDistributor(distributor.getOrganizationID())){
                            for (ProductItem productItem :  nationalDistributor.getProductCatalog().getProductItems()){   
                                if (productItem.getProduct().getMedicineLincense().isIsLicenseValid()){  
                                    Object[] row = new Object[8];
                                    row[0] = productItem;
                                    row[1] = productItem.getProduct().getProductName();            
                                    row[2] = productItem.getQuantity();
                                    row[3] = productItem.getProduct().getPrice();
                                    row[4] = productItem.getProduct().getMedicineLincense().getLicenseNumber();
                                    row[5] = ImplCommonUtil.getFormattedDate(productItem.getProduct().getExpiryDate());
                                    row[6] = nationalDistributor.getOrganizationID();
                                    row[7] = nationalDistributor;
                                    defaultTableModel.addRow(row);  
                                }  
                            }
                        }
                    }        
                }
            }
        }  
        if (distributor instanceof NationalDistributor){
            ImplLogger.info("Product catalog for NationalDistributor");
            if (null != fDISystem){
                for (RegionalLawAgency regionalLawAgency : fDISystem.getRegionalLawAgencyDirectory().getRegionalLawAgencyList()){
                    for (RegionalPharmaceauticalCompany regionalPharmaceauticalCompany : regionalLawAgency.getRegionalPharmaceauticalCompanyDirectory().getRegionalPharmaceauticalCompanyList()){
                        if (null != regionalPharmaceauticalCompany.getNationalDistributorDirectory().searchNationalDistributor(distributor.getOrganizationID())){
                            for (Product product :  regionalPharmaceauticalCompany.getProductCatalog().getProductList()){   
                                if (product.getMedicineLincense().isIsLicenseValid()){  
                                    Object[] row = new Object[8];
                                    row[0] = product;
                                    row[1] = product.getProductName();            
                                    row[2] = product.getAvailable();
                                    row[3] = product.getPrice();
                                    row[4] = product.getMedicineLincense().getLicenseNumber();
                                    row[5] = ImplCommonUtil.getFormattedDate(product.getExpiryDate());
                                    row[6] = regionalPharmaceauticalCompany.getOrganizationID();
                                    row[7] = regionalPharmaceauticalCompany;
                                    defaultTableModel.addRow(row); 
                                }  
                            }
                        }
                    }        
                }
                for (RegionalLawAgency regionalLawAgency : fDISystem.getRegionalLawAgencyDirectory().getRegionalLawAgencyList()){
                    for (RegionalDistributor regionalDistributor : regionalLawAgency.getRegionalDistributorDirectory().getRegionalDistributorList()){
                        if (null != regionalDistributor.getNationalDistributorDirectory().searchNationalDistributor(distributor.getOrganizationID())){
                            for (ProductItem productItem :  regionalDistributor.getProductCatalog().getProductItems()){   
                                if (productItem.getProduct().getMedicineLincense().isIsLicenseValid()){
                                    Object[] row = new Object[8];
                                    row[0] = productItem;
                                    row[1] = productItem.getProduct().getProductName();            
                                    row[2] = productItem.getQuantity();
                                    row[3] = productItem.getProduct().getPrice();
                                    row[4] = productItem.getProduct().getMedicineLincense().getLicenseNumber();
                                    row[5] = ImplCommonUtil.getFormattedDate(productItem.getProduct().getExpiryDate());
                                    row[6] = regionalDistributor.getOrganizationID();
                                    row[7] = regionalDistributor;
                                    defaultTableModel.addRow(row);
                                }  
                            }
                        }
                    }        
                }
            }
        }
        if (distributor instanceof RegionalDistributor) {
            ImplLogger.info("Product catalog for RegionalDistributor");
            if (null != fDISystem){
                for (InterNationalPharmaceauticalCompany interNationalPharmaceauticalCompany : fDISystem.getInterNationalPharmaceauticalCompanyDirectory().getInterNationalPharmaceauticalCompanyList()){       
                    if (null != interNationalPharmaceauticalCompany.getRegionalDistributorDirectory().searchRegionalDistributor(distributor.getOrganizationID())){
                        for (Product product :  interNationalPharmaceauticalCompany.getProductCatalog().getProductList()){
                            if (product.getMedicineLincense().isIsLicenseValid()){  
                                Object[] row = new Object[8];
                                row[0] = product;
                                row[1] = product.getProductName();            
                                row[2] = product.getAvailable();
                                row[3] = product.getPrice();
                                row[4] = product.getMedicineLincense().getLicenseNumber();
                                row[5] = ImplCommonUtil.getFormattedDate(product.getExpiryDate());
                                row[6] = interNationalPharmaceauticalCompany.getOrganizationID();
                                row[7] = interNationalPharmaceauticalCompany;
                                defaultTableModel.addRow(row);
                            }    
                        }
                    }      
                }
            
            }
        }
        if (distributor instanceof PharmacyOrganization || distributor instanceof DispenceryOrganization || distributor instanceof HospitalOrganization
                || distributor instanceof DoctorOrganization || distributor instanceof ClinicOrganization) {
            StateLawAgency stateLawAgency = (StateLawAgency)lawAgency;
            if (null != stateLawAgency){
                for (CityLawAgency cityLawAgency : stateLawAgency.getCityLawAgencyDirectory().getCityLawAgencyList()){       
                    for (CityDistributor cityDistributor :  cityLawAgency.getCityDistributorDirectory().getCityDistributorList()){ 
                        for (ProductItem productItem : cityDistributor.getProductCatalog().getProductItems()){
                            if (productItem.getProduct().getMedicineLincense().isIsLicenseValid()){
                                Object[] row = new Object[8];
                                row[0] = productItem;
                                row[1] = productItem.getProduct().getProductName();            
                                row[2] = productItem.getQuantity();
                                row[3] = productItem.getProduct().getPrice();
                                row[4] = productItem.getProduct().getMedicineLincense().getLicenseNumber();
                                row[5] = ImplCommonUtil.getFormattedDate(productItem.getProduct().getExpiryDate());
                                row[6] = cityDistributor.getOrganizationID();
                                row[7] = cityDistributor;
                                defaultTableModel.addRow(row);    
                            }
                        }
                    }      
                }
            
            }
        }
        if (distributor instanceof PatientOrganization) {
            ImplLogger.info("Product catalog for distributor");
            CityLawAgency cityLawAgency = (CityLawAgency)lawAgency;
            if (null != cityLawAgency){      
                for (PharmacyOrganization pharmacyOrganization :  cityLawAgency.getPharmacyOrganizationDirectory().getPharmacyOrganizationList()){
                    if(null != pharmacyOrganization.getPatientOrganizationDirectory().searchPatientOrganization(distributor.getOrganizationID())){
                        for (ProductItem productItem : pharmacyOrganization.getProductCatalog().getProductItems()){
                            if (productItem.getProduct().getMedicineLincense().isIsLicenseValid()){
                                Object[] row = new Object[8];
                                row[0] = productItem;
                                row[1] = productItem.getProduct().getProductName();            
                                row[2] = productItem.getQuantity();
                                row[3] = productItem.getProduct().getPrice();
                                row[4] = productItem.getProduct().getMedicineLincense().getLicenseNumber();
                                row[5] = ImplCommonUtil.getFormattedDate(productItem.getProduct().getExpiryDate());
                                row[6] = pharmacyOrganization.getOrganizationID();
                                row[7] = pharmacyOrganization;
                                defaultTableModel.addRow(row);    
                            }    
                        }
                    }
                }
                for (DispenceryOrganization dispenceryOrganization : cityLawAgency.getDispenceryOrganizationDirectory().getDispenceryOrganizationList()){ 
                    if(null != dispenceryOrganization.getPatientOrganizationDirectory().searchPatientOrganization(distributor.getOrganizationID())){
                        for (ProductItem productItem : dispenceryOrganization.getProductCatalog().getProductItems()){
                            if (productItem.getProduct().getMedicineLincense().isIsLicenseValid()){
                                Object[] row = new Object[8];
                                row[0] = productItem;
                                row[1] = productItem.getProduct().getProductName();            
                                row[2] = productItem.getQuantity();
                                row[3] = productItem.getProduct().getPrice();
                                row[4] = productItem.getProduct().getMedicineLincense().getLicenseNumber();
                                row[5] = ImplCommonUtil.getFormattedDate(productItem.getProduct().getExpiryDate());
                                row[6] = dispenceryOrganization.getOrganizationID();
                                row[7] = dispenceryOrganization;
                                defaultTableModel.addRow(row);    
                            }   
                        }
                    }
                }   
                for (HospitalOrganization hospitalOrganization :  cityLawAgency.getHospitalOrganizationDirectory().getHospitalOrganizationList()){ 
                    if(null != hospitalOrganization.getPatientOrganizationDirectory().searchPatientOrganization(distributor.getOrganizationID())){
                        for (ProductItem productItem : hospitalOrganization.getProductCatalog().getProductItems()){
                            if (productItem.getProduct().getMedicineLincense().isIsLicenseValid()){
                                Object[] row = new Object[8];
                                row[0] = productItem;
                                row[1] = productItem.getProduct().getProductName();            
                                row[2] = productItem.getQuantity();
                                row[3] = productItem.getProduct().getPrice();
                                row[4] = productItem.getProduct().getMedicineLincense().getLicenseNumber();
                                row[5] = ImplCommonUtil.getFormattedDate(productItem.getProduct().getExpiryDate());
                                row[6] = hospitalOrganization.getOrganizationID();
                                row[7] = hospitalOrganization;
                                defaultTableModel.addRow(row);    
                            }    
                        }
                    }
                }
                for (DoctorOrganization doctorOrganization :  cityLawAgency.getDoctorOrganizationDirectory().getDoctorOrganizationList()){ 
                    if(null != doctorOrganization.getPatientOrganizationDirectory().searchPatientOrganization(distributor.getOrganizationID())){
                        for (ProductItem productItem : doctorOrganization.getProductCatalog().getProductItems()){
                            if (productItem.getProduct().getMedicineLincense().isIsLicenseValid()){
                                Object[] row = new Object[8];
                                row[0] = productItem;
                                row[1] = productItem.getProduct().getProductName();            
                                row[2] = productItem.getQuantity();
                                row[3] = productItem.getProduct().getPrice();
                                row[4] = productItem.getProduct().getMedicineLincense().getLicenseNumber();
                                row[5] = ImplCommonUtil.getFormattedDate(productItem.getProduct().getExpiryDate());
                                row[6] = doctorOrganization.getOrganizationID();
                                row[7] = doctorOrganization;
                                defaultTableModel.addRow(row);    
                            }    
                        }
                    }
                }
                for (ClinicOrganization clinicOrganization :  cityLawAgency.getClinicOrganizationDirectory().getClinicOrganizationList()){ 
                    if(null != clinicOrganization.getPatientOrganizationDirectory().searchPatientOrganization(distributor.getOrganizationID())){
                        for (ProductItem productItem : clinicOrganization.getProductCatalog().getProductItems()){
                            if (productItem.getProduct().getMedicineLincense().isIsLicenseValid()){
                                Object[] row = new Object[8];
                                row[0] = productItem;
                                row[1] = productItem.getProduct().getProductName();            
                                row[2] = productItem.getQuantity();
                                row[3] = productItem.getProduct().getPrice();
                                row[4] = productItem.getProduct().getMedicineLincense().getLicenseNumber();
                                row[5] = ImplCommonUtil.getFormattedDate(productItem.getProduct().getExpiryDate());
                                row[6] = clinicOrganization.getOrganizationID();
                                row[7] = clinicOrganization;
                                defaultTableModel.addRow(row);    
                            }   
                        }
                    }
                }
            }
        }
        ImplLogger.exitMethod();
    }
    /**
     * populate order table
     */
    private void populateOrderTable(){
        ImplLogger.enterMethod();
        DefaultTableModel defaultTableModel = (DefaultTableModel)orderTable.getModel();
        defaultTableModel.setRowCount(0);
        for (OrderItem orderItem : order.getOrderItemList()){
            ImplLogger.info("orderItem : " + orderItem.getProduct());
            Object[] row = new Object[8];
            row[0] = orderItem;
            row[1] = orderItem.getProduct().getProductName();            
            row[2] = orderItem.getQuantity();
            row[3] = orderItem.getProduct().getPrice();
            row[4] = orderItem.getProduct().getMedicineLincense().getLicenseNumber();
            row[5] = ImplCommonUtil.getFormattedDate(orderItem.getProduct().getExpiryDate());
            row[6] = orderItem.getShopId();
            row[7] = orderItem.getOrganization();
            defaultTableModel.addRow(row);            
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
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        viewProductDetailsButton = new javax.swing.JButton();
        checkOutButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        updateOrderButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        updateQuantityTextField = new javax.swing.JTextField();
        addToCartButton = new javax.swing.JButton();
        removeItemButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Browse Catalog");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Shoppping Cart");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Payment Screen");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Order Summary");

        jLabel5.setText(">>");

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText(">>");

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Quantity", "Price", "License Number", "Expiry Date", "Shop ID", "Shop Name"
            }
        ));
        jScrollPane1.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            productTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            productTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        viewProductDetailsButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        viewProductDetailsButton.setText("View Product Details");
        viewProductDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductDetailsButtonActionPerformed(evt);
            }
        });

        checkOutButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        checkOutButton.setText("Check Out");
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel8.setText("Quantity");

        backButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drugsupplychain/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel6.setText(">>");

        updateOrderButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        updateOrderButton.setText("Update Order");
        updateOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateOrderButtonActionPerformed(evt);
            }
        });

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Quantity", "Price", "License Number", "Expiry Date", "Shop ID", "Shop Name"
            }
        ));
        jScrollPane2.setViewportView(orderTable);
        if (orderTable.getColumnModel().getColumnCount() > 0) {
            orderTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            orderTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            orderTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel9.setText("Quantity");

        addToCartButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        addToCartButton.setText("Add to Cart");
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        removeItemButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        removeItemButton.setText("Remove Item");
        removeItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemButtonActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(removeItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(updateQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(updateOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(15, 15, 15)))))
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel5)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel7)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshButton)))
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewProductDetailsButton)
                        .addGap(532, 532, 532)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(addToCartButton)
                        .addContainerGap(45, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7))
                    .addComponent(refreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewProductDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(updateQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(updateOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * back button
     * @param evt 
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ImplLogger.enterMethod();
        for(OrderItem orderItem : order.getOrderItemList()){
            Organization organization = orderItem.getOrganization();
            if (organization instanceof Distributor){
                Distributor distributor1 = (Distributor)organization;
                for(ProductItem productItem : distributor1.getProductCatalog().getProductItems()){
                    if(productItem.getProduct().getBarcode().equals(orderItem.getProduct().getBarcode())){
                        productItem.setQuantity(productItem.getQuantity() +  orderItem.getQuantity());
                    }
                }
            }
            if (organization instanceof PharmaceauticalCompany){
                orderItem.getProduct().setAvailable(orderItem.getQuantity() +  orderItem.getProduct().getAvailable());
            }
        }        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        ImplLogger.exitMethod();
    }//GEN-LAST:event_backButtonActionPerformed
    /**
     * view product details
     * @param evt 
     */
    private void viewProductDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductDetailsButtonActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  productTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the row from the list");
        } else {
            if (productTable.getValueAt(selectedRow, 0) instanceof  Product){
                Product product = (Product)productTable.getValueAt(selectedRow,0);
                ImplLogger.info("product " + product);
                ViewMedicineDetails viewMedicineDetails = new ViewMedicineDetails(userProcessContainer,product,(Organization)productTable.getValueAt(selectedRow, 7));
                userProcessContainer.add("ViewMedicineDetails",viewMedicineDetails);
                CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
                cardLayout.next(userProcessContainer);
            } else if (productTable.getValueAt(selectedRow, 0) instanceof  ProductItem){
                ProductItem productItem = (ProductItem)productTable.getValueAt(selectedRow, 0);
                ImplLogger.info("productItem " + productItem);
                ViewMedicineDetails viewMedicineDetails = new ViewMedicineDetails(userProcessContainer,productItem.getProduct(),(Organization)productTable.getValueAt(selectedRow, 7));
                userProcessContainer.add("ViewMedicineDetails",viewMedicineDetails);
                CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
                cardLayout.next(userProcessContainer);
            }
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_viewProductDetailsButtonActionPerformed
    /**
     * check out button
     * @param evt 
     */
    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed
        ImplLogger.enterMethod();
        if (order != null && order.getOrderItemList().size() > 0){
            //order.setCreationDate(new Date());
            //distributor.getOrderCatalog().addOrder(order);
            populateTable();
            populateOrderTable();
            ImplLogger.info("order " + order + " distributor " + order);
            PaymentInfoScreenJPanel paymentInfoScreenJPanel = new PaymentInfoScreenJPanel(userProcessContainer,order,distributor);
            userProcessContainer.add("PaymentInfoScreenJPanel",paymentInfoScreenJPanel);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(null, "Shopping Cart is empty");
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_checkOutButtonActionPerformed
    /**
     * update Order button
     * @param evt 
     */
    private void updateOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateOrderButtonActionPerformed
        ImplLogger.enterMethod();
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the product from the list");
        } else {
            if (ImplValidationUtils.isInteger(updateQuantityTextField.getText())){
                int newQuantity = Integer.parseInt(updateQuantityTextField.getText());
                OrderItem orderItem = (OrderItem)orderTable.getValueAt(selectedRow, 0);                
                int oldQuantity = orderItem.getQuantity();
                Organization organization = (Organization)orderTable.getValueAt(selectedRow, 7);
                if (organization instanceof Distributor){
                    Distributor distributor1 = (Distributor)organization;
                    for(ProductItem productItem : distributor1.getProductCatalog().getProductItems()){
                        if(productItem.getProduct().getBarcode().equals(orderItem.getProduct().getBarcode())){                            
                            int currentAvailabilty = productItem.getQuantity();
                            if (newQuantity > oldQuantity + currentAvailabilty || newQuantity <= 0) {
                                JOptionPane.showMessageDialog(null, "Please select the desired quantity");
                            } else {
                                orderItem.setQuantity(newQuantity);
                                productItem.setQuantity(oldQuantity + currentAvailabilty - newQuantity);
                                populateTable();
                                populateOrderTable();
                            }
                        }
                    }
                }
                else if (organization instanceof PharmaceauticalCompany){
                    int currentAvailabilty = orderItem.getProduct().getAvailable();
                    if (newQuantity > oldQuantity + currentAvailabilty || newQuantity <= 0) {
                    JOptionPane.showMessageDialog(null, "Please select the desired quantity");
                    } else {
                        orderItem.setQuantity(newQuantity);
                        orderItem.getProduct().setAvailable(oldQuantity + currentAvailabilty - newQuantity);
                        populateTable();
                        populateOrderTable();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select the integer value of quantity");
            }
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_updateOrderButtonActionPerformed
    /**
     * add to cart
     * @param evt 
     */
    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartButtonActionPerformed
        ImplLogger.enterMethod();
        int selectedRow =  productTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the product from the list");
        } else {
            Organization organization = (Organization)productTable.getValueAt(selectedRow, 7);
            if (productTable.getValueAt(selectedRow, 0) instanceof  Product){
                Product product = (Product)productTable.getValueAt(selectedRow, 0);
                if (product.getMedicineLincense().isIsLicenseValid()){
                    if (ImplValidationUtils.isInteger(quantityTextField.getText())){
                        int quantity = Integer.parseInt(quantityTextField.getText());
                        if (quantity > product.getAvailable() || quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Please select the desired quantity of product");
                        } else {                        
                            product.setAvailable(product.getAvailable() - quantity);
                            boolean found = false;
                            for(OrderItem orderItem : order.getOrderItemList()){
                                if (orderItem.getProduct().getBarcode().equals(product.getBarcode()) && (orderItem.getShopId() == organization.getOrganizationID())){
                                   orderItem.setQuantity(orderItem.getQuantity() + quantity);
                                   found = true;
                                   break;
                                }
                           } if(!found){
                               order.addOrderItem(product,quantity,organization.getOrganizationID(),organization);
                           }
                            populateTable();
                            populateOrderTable();

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select the integer value of quantity");
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "This medicine has been revoked. You cannot sell or purchase this product anyomore");
                }
            } 
            if (productTable.getValueAt(selectedRow, 0) instanceof  ProductItem){
                ProductItem productItem = (ProductItem)productTable.getValueAt(selectedRow, 0);
                if (productItem.getProduct().getMedicineLincense().isIsLicenseValid()){
                    if (ImplValidationUtils.isInteger(quantityTextField.getText())){
                        int quantity = Integer.parseInt(quantityTextField.getText());
                        if (quantity > productItem.getQuantity() || quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Please select the desired quantity of product");
                        } else {                        
                            productItem.setQuantity(productItem.getQuantity() - quantity);
                            boolean found = false;
                            for(OrderItem orderItem : order.getOrderItemList()){
                                if (orderItem.getProduct().getBarcode().equals(productItem.getProduct().getBarcode()) && (orderItem.getShopId() == organization.getOrganizationID())){
                                   orderItem.setQuantity(orderItem.getQuantity()+ quantity);
                                   found = true;
                                   break;
                                }
                           } if(!found){
                               order.addOrderItem(productItem.getProduct(),quantity,organization.getOrganizationID(),organization);
                           }
                            populateTable();
                            populateOrderTable();

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select the integer value of quantity");
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "This medicine has been revoked. You cannot sell or purchase this product anyomore");
                }
            } 
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_addToCartButtonActionPerformed
    /**
     * remove item
     * @param evt 
     */
    private void removeItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemButtonActionPerformed
        ImplLogger.enterMethod();
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow < 0 ){
            JOptionPane.showMessageDialog(null, "Please select the product from the list");
        } else {
            OrderItem orderItem = (OrderItem)orderTable.getValueAt(selectedRow, 0);
            Organization organization = (Organization)orderTable.getValueAt(selectedRow, 7);
            if (organization instanceof Distributor){
                Distributor distributor1 = (Distributor)organization;
                for(ProductItem productItem : distributor1.getProductCatalog().getProductItems()){
                    if(productItem.getProduct().getBarcode().equals(orderItem.getProduct().getBarcode())){
                        productItem.setQuantity(productItem.getQuantity() +  orderItem.getQuantity());
                    }
                }
            }
            if (organization instanceof PharmaceauticalCompany){
                orderItem.getProduct().setAvailable(orderItem.getQuantity() +  orderItem.getProduct().getAvailable());
            }
            order.removeItem(orderItem);            
            populateTable();
            populateOrderTable();
        }
        ImplLogger.exitMethod();
    }//GEN-LAST:event_removeItemButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        populateTable();
        populateOrderTable();
    }//GEN-LAST:event_refreshButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable orderTable;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JButton updateOrderButton;
    private javax.swing.JTextField updateQuantityTextField;
    private javax.swing.JButton viewProductDetailsButton;
    // End of variables declaration//GEN-END:variables
}
