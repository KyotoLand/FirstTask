package com.netcracker.edu.miloserdov.address;

/**
 * Class of persons, contains information about name, surname, age and address.
 * Contains methods to work with person's data.
 */

public class Person {

    private final String name;
    public String surname;
    private final int age;
    private final Address address = new Address(this);

    Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getPerson() {
        return ("Name: " + this.name + " | Surname: " + this.surname + " | Age: " + this.age);
    }

    public String getAddress() {
        return address.getAddress();
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getStreet() {
        return address.getStreet();
    }

    /**
     * Returns Person if his address is matched with input address.
     * @param town
     * @param street
     * @param houseNum
     * @return
     */

    public Person matchByAddress(String town, String street, String houseNum) {
        return address.matchByAddress(town, street, houseNum);
    }

    public void personSetAddress(String town, String street, String houseNum) {
        this.address.setAddress(town, street, houseNum);
    }

}


