package com.netcracker.edu.miloserdov.dice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Dice {

    private int N;
    private int K;

    Dice(int N, int K){
        this.N = N;
        this.K = K;
    }

    public static int findMax(int[] array){
        int temp = array[0];
        for(int i = 0 ; i< array.length ; i++){
            if(array[i] > temp){
                temp = array[i];
            }
        }
        return temp;
    }

    public static int findMaxKey(int[] array){
        int temp = array[0];
        int key = 0;
        for(int i = 0 ; i< array.length ; i++){
            if(array[i] > temp){
                temp = array[i];
                key = i;
            }
        }
        return key;
    }

    public static int findIndex(int arr[], int t)
    {

        // if array is Null
        if (arr == null) {
            return -1;
        }

        // find length of array
        int len = arr.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    public static int[] bubbleSort(int[] arr){
        int[] temparr = arr;
        for(int i = temparr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){

            if( temparr[j] > temparr[j+1] ){
                int tmp = temparr[j];
                temparr[j] = temparr[j+1];
                temparr[j+1] = tmp;
            }
        }
    }
        return temparr;
}

    public void start(){

        int[] playerDice = new int[N+1]; // очки игроков выпавшие в каждом отдельном броске
        int[] playerScore = new int[N+1]; // очки игроков, по результатам всей игры

        int rand;
        int winner = 0;

        int game = 1;

        while ( findMax(playerScore) != 7){
            int temp = 0;
            while (bubbleSort(playerDice)[playerDice.length - 2] != -1) {
                if (temp == 0) {
                    System.out.println("Game - " + game);
                } else {
                    System.out.println("Extra game for winners");
                }
                if (winner != playerScore.length - 1) {
                    System.out.println(winner + 1 + " Player:");
                } else {
                    System.out.println("Computer:");
                }
                for (int j = 0; j < K; j++) {
                    rand = (int) (Math.random() * 6) + 1;
                    playerDice[winner] += rand;
                    if (j != 0) {
                        System.out.print("+ ");
                    }
                    System.out.print(rand + " ");
                }
                System.out.println("= " + playerDice[winner]);

                for (int i = 0; i < playerDice.length; i++) {
                    if (i != winner && playerDice[i] == 0) {

                        if (i != playerDice.length - 1) {
                            System.out.println(i + 1 + " Player:");
                        } else {
                            System.out.println("Computer:");
                        }

                        for (int j = 0; j < K; j++) {
                            rand = (int) (Math.random() * 6) + 1;
                            playerDice[i] += rand;
                            if (j != 0) {
                                System.out.print("+ ");
                            }
                            System.out.print(rand + " ");
                        }
                        System.out.println("= " + playerDice[i]);
                    }
                }
                int maxvalue = findMax(playerDice);


                for (int i = 0; i < playerScore.length; i++) {
                    if (playerDice[i] != maxvalue) {
                        playerDice[i] = -1;
                    } else {
                        playerDice[i] = 0;
                    }
                }


                temp++;


                winner = findMaxKey(playerDice);

            }
            System.out.println("");
            playerScore[winner]++;
            if( winner == playerScore.length - 1){
                System.out.println("Player \"Computer\" wins, he has " + playerScore[winner] + " points");
            }else {
                System.out.println("Player \"" + (winner + 1) + "\" wins, he has " + playerScore[winner] + " points");
            }

            for (int i = 0; i < playerScore.length; i++) {
                playerDice[i] = 0;

            }
            game++;
            System.out.println("");
        }

        System.out.println("Congratulations to Player \"" + (findMaxKey(playerScore) + 1) + "\"");
    }
}
