package com.netcracker.edu.miloserdov.quadratic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("To solve ax^2 + bx + c = 0:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a :");
        double a = scanner.nextDouble();
        System.out.println("Enter b :");
        double b = scanner.nextDouble();
        System.out.println("Enter c :");
        double c = scanner.nextDouble();
        Quadratic equation =  new Quadratic(a, b, c);
        System.out.println(equation.solve());
    }
}
