package com.netcracker.edu.miloserdov.dice;

import java.util.Scanner;

public class Main {

    static public void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of players:");
        int N = scanner.nextInt();
        System.out.println("Enter the number of cubes:");
        int K = scanner.nextInt();

        Dice game = new Dice(N, K);
        game.start();

    }
}
