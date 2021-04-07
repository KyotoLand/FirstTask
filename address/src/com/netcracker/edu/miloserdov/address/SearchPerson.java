package com.netcracker.edu.miloserdov.address;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class to work with array of Persons.
 * Contains different types of searching somebody in array.
 * Contains universal method to work with console.
 */

public class SearchPerson {

    /**
     * Universal method of searching somebody from console.
     * @param person Person
     */

    public static void searchIn(Person[] person) {

        for (Person value : person) {
            System.out.println(value.getPerson() + "   |/////|   " + value.getAddress());
        }

        System.out.println("\nYou can search something in this list of people and addresses:\n");

        int check;

        while (true) {

            System.out.println("1 - for searching by address |" +
                    " 2 - for searching by surname |" +
                    " 3 - searching people from n years old to m years old|" +
                    " 4 - find the oldest person |" +
                    " 5 - find the youngest person |" +
                    " 6 - find people, who live at the same street |" +
                    " 0 - exit");

            while (true) {
                try {
                    Scanner input = new Scanner(System.in);
                    check = input.nextInt();
                    if (check > 6 || check < 0) {
                        throw new InputMismatchException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter an integer number between 0 and 6:");
                }
            }

            Scanner input = new Scanner(System.in);

            switch (check) {
                case 1:
                    String[] searchAddress = new String[3];
                    System.out.println("Enter town:");
                    searchAddress[0] = input.next();
                    System.out.println("Enter street:");
                    searchAddress[1] = input.next();
                    System.out.println("Enter house number:");
                    searchAddress[2] = input.next();
                    System.out.println(SearchPerson.searchByAddress(person, searchAddress));
                    System.out.print("--------------------------------------------------------------");
                    System.out.println("\nTry again: \n");
                    break;
                case 2:
                    System.out.println("Enter surname:");
                    String surname = input.next();
                    System.out.println(SearchPerson.searchBySurname(person, surname));
                    System.out.print("--------------------------------------------------------------");
                    System.out.println("\nTry again: \n");
                    break;
                case 3:
                    int min;
                    int max;
                    while (true) {
                        System.out.println("Enter n:");
                        min = input.nextInt();
                        System.out.println("Enter m:");
                        max = input.nextInt();
                        if (max >= min) {
                            break;
                        } else {
                            System.out.println("Max should be bigger than min, try again");
                        }
                    }
                    System.out.println(SearchPerson.searchByAge(person, min, max));
                    System.out.print("--------------------------------------------------------------");
                    System.out.println("\nTry again: \n");
                    break;
                case 4:
                    System.out.println(SearchPerson.findTheOldest(person));
                    System.out.print("--------------------------------------------------------------");
                    System.out.println("\nTry again: \n");
                    break;
                case 5:
                    System.out.println(SearchPerson.findTheYoungest(person));
                    System.out.print("--------------------------------------------------------------");
                    System.out.println("\nTry again: \n");
                    break;
                case 6:
                    System.out.println(SearchPerson.searchForTheSameStreet(person));
                    System.out.println("\nTry again: \n");
                    break;
                case 0:
                    System.exit(0);
            }

        }

    }

    /**
     * Searching for somebody by address.
     * @param person Person
     * @param addresses String[]
     * @return String
     */

    public static String searchByAddress(Person[] person, String[] addresses) {

        int[] indexesOfMatches = new int[person.length];
        int k = 0;
        for (int i = 0; i < person.length; i++) {
            if (person[i].matchByAddress(addresses[0], addresses[1], addresses[2]) != null) {
                indexesOfMatches[k] = i;
                k++;
            }
        }

        System.out.println("");

        String resultString = "Result of searching:\n";

        for (int i = 0; i < k; i++) {
            resultString += i + 1 + " - " + person[indexesOfMatches[i]].getPerson() + "\n";
        }

        if (k != 0) {
            return "--------------------------------------------------------------\n" + resultString;
        } else {
            return "--------------------------------------------------------------\n" + "No results";
        }
    }

    /**
     * Searching for somebody by surname.
     * @param person Person
     * @param surname String
     * @return String
     */

    public static String searchBySurname(Person[] person, String surname) {

        int[] indexesOfMatches = new int[person.length];
        int k = 0;
        for (int i = 0; i < person.length; i++) {
            if (person[i].getSurname().equalsIgnoreCase(surname)) {
                indexesOfMatches[k] = i;
                k++;
            }
        }

        System.out.println("");

        String resultString = "Result of searching:\n";

        for (int i = 0; i < k; i++) {
            resultString += i + 1 + " - " + person[indexesOfMatches[i]].getPerson() + "\n";
        }

        if (k != 0) {
            return "--------------------------------------------------------------\n" + resultString;
        } else {
            return "--------------------------------------------------------------\n" + "No results";
        }

    }

    /**
     * Searching for the people in array, who are between "min" and "max" years old.
     * @param person Person
     * @param min int
     * @param max int
     * @return String
     */

    public static String searchByAge(Person[] person, int min, int max) {

        int[] indexesOfMatches = new int[person.length];
        int k = 0;
        for (int i = 0; i < person.length; i++) {
            if (person[i].getAge() >= min && person[i].getAge() <= max) {
                indexesOfMatches[k] = i;
                k++;
            }
        }

        System.out.println("");

        String resultString = "Result of searching:\n";
        for (int i = 0; i < k; i++) {
            resultString += i + 1 + " - " + person[indexesOfMatches[i]].getPerson() + "\n";
        }

        if (k != 0) {
            return "--------------------------------------------------------------\n" + resultString;
        } else {
            return "--------------------------------------------------------------\n" + "No results";
        }

    }

    /**
     * Find the oldest person in array.
     * @param person Person
     * @return String
     */

    public static String findTheOldest(Person[] person) {
        int max = person[0].getAge();
        int[] indexes = new int[person.length];
        int j = 0;
        for (int i = 0; i < person.length; i++) {
            if (max < person[i].getAge()) {
                j = 0;
                max = person[i].getAge();
                indexes[0] = i;
            } else if (max == person[i].getAge()) {
                j++;
                indexes[j] = i;
            }
        }
        if (j == 0) {
            return "--------------------------------------------------------------\nThe oldest person is: \n"
                    + person[indexes[j]].getPerson();
        } else {
            String result = "-------------------------------" +
                    "-------------------------------\nThere are several oldest persons: \n";
            for (int i = 0; i <= j; i++) {
                result += person[indexes[i]].getPerson() + "\n";
            }
            return result;
        }
    }

    /**
     * Find the youngest person in array.
     * @param person Person
     * @return String
     */

    public static String findTheYoungest(Person[] person) {
        int min = person[0].getAge();
        int[] indexes = new int[person.length];
        int j = 0;
        for (int i = 0; i < person.length; i++) {
            if (min > person[i].getAge()) {
                j = 0;
                min = person[i].getAge();
                indexes[0] = i;
            } else if (min == person[i].getAge()) {
                j++;
                indexes[j] = i;
            }
        }
        if (j == 0) {
            return "--------------------------------------------------------------\nThe youngest person is: \n"
                    + person[indexes[j]].getPerson();
        } else {
            String result = "-------------------------------" +
                    "-------------------------------\nThere are several youngest persons: \n";
            for (int i = 0; i <= j; i++) {
                result += person[indexes[i]].getPerson() + "\n";
            }
            return result;
        }

    }

    /**
     * Supporting method, returns if input String[] size of "size" contains input String.
     * @param string String
     * @param stringArr String[]
     * @param size int
     * @return
     */

    private static boolean isInArray(String string, String[] stringArr, int size) {
        for (int i = 0; i <= size; i++) {
            return string.equals(stringArr[i]);
        }
        return false;
    }

    /**
     * Searching for the people who live at the same street.
     * @param person Person
     * @return String
     */


    public static String searchForTheSameStreet(Person[] person) {

        int[][] indexes = new int[person.length][person.length];

        for (int j = 0; j < person.length; j++) {
            for (int i = 0; i < person.length; i++) {
                indexes[j][i] = -1;
            }
        }

        String test;

        String[] matches = new String[person.length];

        int k = 1;
        int g = 0;
        int kmax = 0;

        boolean flag = false;

        for (int i = person.length - 1; i > 0; i--) {
            test = person[i].getStreet();
            for (int j = 0; j < i; j++) {
                if (person[j].getStreet().equalsIgnoreCase(test) && !isInArray(test, matches, g)) {
                    indexes[g][0] = i;
                    indexes[g][k] = j;
                    k++;
                    flag = true;
                }
            }
            if (flag) {
                matches[g] = test;
                g++;
            }
            flag = false;
            if (k > kmax) {
                kmax = k;
            }
            k = 1;
        }

        System.out.println("");

        String resultString = "Result of searching:\n" + "----------------------------\n";

        for (int i = 0; i < g; i++) {
            for (int j = 0; j < kmax; j++) {
                if (indexes[i][j] != -1) {
                    resultString += person[indexes[i][j]].getPerson() + "\n";
                } else {
                    break;
                }
            }
            resultString += "----------------------------\n";
        }

        if (g != 0) {
            return "--------------------------------------------------------------\n" + resultString;
        } else {
            return "--------------------------------------------------------------\n" + "No results";
        }
    }
}