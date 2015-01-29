/*
 * Class : Product.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 3:35:38 PM
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
package drugsupplychain.neu.css.model.product;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author Laksh
 */
public class Product {
    private static int count = 0;
    private String productName;
    private String barcode;
    private String manufacturerId;
    private String manufacturerName;
    private String ManuFacturerEMAIL;
    private Date manufactureDate;
    private Date expiryDate;    
    private int price;
    private int available;
    private int initialQuantity;
    private StringBuffer chemicalComposition;  
    private boolean isPrescriptionRequired;
    private final ProductCaseCatalog productCaseCatalog;
    private final MedicineLincense medicineLincense;
    private final LinkedHashMap<String,TrackOrganization> productTracker;

    public HashMap<String, TrackOrganization> getProductTracker() {
        return productTracker;
    }

    public MedicineLincense getMedicineLincense() {
        return medicineLincense;
    }  

    public ProductCaseCatalog getProductCaseCatalog() {
        return productCaseCatalog;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManuFacturerEMAIL() {
        return ManuFacturerEMAIL;
    }

    public void setManuFacturerEMAIL(String ManuFacturerEMAIL) {
        this.ManuFacturerEMAIL = ManuFacturerEMAIL;
    }
    /**
     * constructor to set the bar code value
     */
    public Product() {
        count++;
        barcode = String.valueOf(count);
        manufactureDate = new Date();
        medicineLincense = new MedicineLincense();
        productCaseCatalog = new ProductCaseCatalog();
        productTracker = new LinkedHashMap<>();
    }
    public StringBuffer getChemicalComposition() {
        return chemicalComposition;
    }

    public void setChemicalComposition(StringBuffer chemicalComposition) {
        this.chemicalComposition = chemicalComposition;
    } 
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
    }
    public boolean isIsPrescriptionRequired() {
        return isPrescriptionRequired;
    }

    public void setIsPrescriptionRequired(boolean isPrescriptionRequired) {
        this.isPrescriptionRequired = isPrescriptionRequired;
    }
    @Override
    public String toString(){
      return barcode;
    }
    
}
