package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        beginGame();
    }

    private static void beginGame(){
        Scanner input = new Scanner(System.in);
        int choice = 1;

        while (choice != 2){
            playGame(input);
            System.out.println("1-Play again\n2-Exit");
            System.out.print("choose 1 or 2: ");
            choice = input.nextInt();
            System.out.println("----------------------------------" +
                    "\n----------------------------------");
        }
    }
    private static void playGame(Scanner input){
        System.out.println("I have randomly chosen a number between [1-100]");
        System.out.println("Try to guess it");
        System.out.println("You have 10 guess(es) left: ");
        int numberToStopTheGame = 0;
        int inputNumber = input.nextInt();
        int randomNumber = getRandomNumber();
        while (true){
            while (inputNumber > 100 || inputNumber < 1){
                System.out.println("Incorrect number, Please enter number between[1-100]");
                inputNumber = input.nextInt();
            }
            if(isGameExpiredOrUserWin(numberToStopTheGame++, inputNumber, randomNumber) == true){
                break;
            }
            else {
                System.out.println("You have " + (10 - numberToStopTheGame) + " guess(es) left: ");
                inputNumber = input.nextInt();
            }
        }
    }
    private static int getRandomNumber(){
        Random random = new Random();
        int randomNumber = 1 + random.nextInt(100);
        return randomNumber;
    }
    private static boolean isGameExpiredOrUserWin(int numberToStopTheGame, int inputNumber, int randomNumber){
        if(numberToStopTheGame == 10){
            System.out.println("Game Expired... You Lose\n" +
                    "----------------------------------" +
                    "\n----------------------------------");

            return true;
        }
        else if(randomNumber == inputNumber) {
            System.out.println("Correct... You Win!\n" +
                    "----------------------------------" +
                    "\n----------------------------------");
            return true;
        }
        else if(randomNumber > inputNumber){
            System.out.println("It's bigger than " + inputNumber);
            return false;
        }
        System.out.println("It's smaller than " + inputNumber);
        return false;
    }
}

