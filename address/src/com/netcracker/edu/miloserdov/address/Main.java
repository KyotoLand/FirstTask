package com.netcracker.edu.miloserdov.address;

public class Main {

    public static void main(String[] args) {

        Person[] person = new Person[6];

        String[][] names = {{"Alex", "Goodman"}, {"Michael", "Scofield"}, {"Lincoln", "Barrows"}, {"Sara", "Tancredi"},
                {"Hugh", "Laurie"}, {"Liza", "Edelstein"}};

        int[] ages = {21, 35, 36, 27, 12, 13};

        String[][] addresses = {{"Moscow", "Filts", "7/2"}, {"Utah", "Sunny", "19"}, {"Utah", "Sunny", "19"},
                {"New York", "Filts", "12/7"}, {"Prinston", "Merser", "1"}, {"Prinston", "Merser", "5"}};

        for (int i = 0; i < person.length; i++) {
            person[i] = new Person(names[i][0], names[i][1], ages[i]);
            person[i].personSetAddress(addresses[i][0], addresses[i][1], addresses[i][2]);
        }

        SearchPerson.searchIn(person);
    }

}
