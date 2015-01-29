/*
 * Class : Address.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 11, 2014, 5:46:44 PM
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

/**
 *
 * @author Laksh
 */
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String region;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Address{" + "addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", region=" + region + ", city=" + city + ", state=" + state + ", country=" + country + ", zipcode=" + zipcode + '}';
    }

    
}
