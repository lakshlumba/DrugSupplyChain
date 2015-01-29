/*
 * Class : License.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 13, 2014, 1:59:32 AM
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
package drugsupplychain.neu.css.model.address;

import drugsupplychain.neu.css.util.ImplCommonUtil;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Laksh
 */
public class License {
    private String licenseNumber;
    private boolean isLicenseValid;
    private Date creationDate;
    private Date expirationDate;

    public License(String name) {
        Calendar calendar = Calendar.getInstance();
        this.creationDate = calendar.getTime();
        this.licenseNumber = ImplCommonUtil.generateLicencseNumber(name);
        calendar.add(Calendar.YEAR, 1);
        this.expirationDate  = calendar.getTime();
        this.isLicenseValid = true;
    }   
    
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public boolean isIsLicenseValid() {
        return isLicenseValid;
    }

    public void setIsLicenseValid(boolean isLicenseValid) {
        this.isLicenseValid = isLicenseValid;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    @Override
    public String toString(){
        return licenseNumber;
    }
}
