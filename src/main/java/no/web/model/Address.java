package no.web.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private int zip;
    private String streetName;
    private String city ;
    private String country;

    public int getZip() {
        return zip;
    }

    public void setZip(final int zip) {
        this.zip = zip;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(final String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }
}
