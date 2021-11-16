package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome in XXX");
        System.out.println("Authors: Norbert Leśniak, Artur piszczatowski");

        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Select problem: ");
            System.out.println("1. A man sets up a fund for his new-born son’s college education. He figures the son will go to college at X for a cost of Y.\nHow much should be put in the fund if the interest rate is P %");
            System.out.println("2. A man retires with X amount of money at the age of Y He wants to convert it to an annuity that will ook after him until he is Z. \nIf interest rate is P %, what is his annual retirement income?");
            System.out.println("3. A person wants to buy a home for X amount of money in Y years. He wants to save by depositing an equal amount of money each year into a special account. \nAt P % interest rate, what should his annual deposit be?");
            System.out.println("4. ");
            System.out.println("5. Four persons are  chosen at random from a group containing 3  men, 2  women and  4  children. Calculate the chances that exactly two of them will be children");
            try{
                choice = scanner.nextInt();
                if(choice<1||choice>5)
                    throw new InputMismatchException();
            }catch (InputMismatchException e) {
                System.err.println("Wrong input! Input only integer in range 1-5 please.");
                scanner.nextLine();
            }
            switch(choice){
                case 1:
                    System.out.println("Enter: \n1. Investment duration \n2. Amount of money to achive \n3. Interest rate percentage");
                    try{
                    Tasks.investmentEstimate(scanner.nextInt(), scanner.nextDouble(), scanner.nextDouble());
                    }catch (InputMismatchException e) {
                        System.err.println("Wrong input! Input only valid numbers.");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    //Tasks.annuityConverter();
                    break;
                case 3:
                    //Tasks.annualDepositEstimatate();
                    break;
                case 4:

                    break;
                case 5:

                    break;
            }





        }
    }
}
