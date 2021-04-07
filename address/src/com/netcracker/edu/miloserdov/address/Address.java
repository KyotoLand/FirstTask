package com.netcracker.edu.miloserdov.address;

/**
 * Class of addresses, contains information about town, street and house number.
 * Contains methods to work with address data.
 */

public class Address {

    private final Person person;

    private String town = "None";
    private String street = "None";
    private String houseNum = "None";

    /**
     * Constructor binds Person with Address.
     * Address only can be used in relation to Person.
     * @param person
     */

    public Address(Person person) {
        this.person = person;
    }

    public void setAddress(String town, String street, String houseNum) {
        this.town = town;
        this.street = street;
        this.houseNum = houseNum;
    }

    public String getStreet() {
        return this.street;
    }


    public String getAddress() {
        return "Town: " + this.town + " | Street: " + this.street + " | House Number: " + this.houseNum;
    }

    /**
     * Returns Person if his address is matched with input address.
     * @param town
     * @param street
     * @param houseNum
     * @return
     */

    public Person matchByAddress(String town, String street, String houseNum) {
        if (this.town.equalsIgnoreCase(town) && this.street.equalsIgnoreCase(street)
                && this.houseNum.equalsIgnoreCase(houseNum)) {
            return this.person;
        } else {
            return null;
        }
    }

}