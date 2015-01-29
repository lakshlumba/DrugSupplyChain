/*
 * Class : TrackOrganization.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 23, 2014, 8:38:20 PM
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

import drugsupplychain.neu.css.model.organization.Organization;

/**
 *
 * @author Laksh
 */
public class TrackOrganization {
    private Organization organization;
    private String puchaseDate;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getPuchaseDate() {
        return puchaseDate;
    }

    public void setPuchaseDate(String puchaseDate) {
        this.puchaseDate = puchaseDate;
    }
    @Override
    public String toString() {
        return String.valueOf(organization.getOrganizationID());
    }
}
