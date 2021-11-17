package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class consists of CLI and it is responsible for activating selected methods from Tasks class.
 * User choose desired problem by entering correct number [1-5 or 9].
 * User is supposed to enter all required data shown on terminal in the correct order.
 * In case of incorrect input program throws InputMismatchException.
 *
 * @see Scanner
 * @see InputMismatchException
 * @see Tasks
 * @author Norbert Leśniak
 * @author Artur Piszczatowski
 */
public class Main {

    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        boolean keepWorking = true;
        while(keepWorking){
            System.out.println("Select problem: ");
            System.out.println("1. A man sets up a fund for his new-born son’s college education. He figures the son will go to college at X for a cost of Y." +
                    "\nHow much should be put in the fund if the interest rate is P %");
            System.out.println("2. A man retires with X amount of money at the age of Y He wants to convert it to an annuity that will ook after him until he is Z. " +
                    "\nIf interest rate is P %, what is his annual retirement income?");
            System.out.println("3. A person wants to buy a home for X amount of money in Y years. " +
                    "He wants to save by depositing an equal amount of money each year into a special account. " +
                    "\nAt P % interest rate, what should his annual deposit be?");
            System.out.println("4. A computer memory system consists of 4 identical memory units connected in parallel. The memory system’s “system success criteria”" +
                    " require that at least 3 memory units must function. " +
                    "\nWhat is the probability of system success if the reliability of each memory unit is X?");
            System.out.println("5. sum(ABC) persons are  chosen at random from a group containing A men, B women and C children. " +
                    "Calculate the chances that exactly two of them will be children");
            System.out.println("9. Exit.");
            try{
                choice = scanner.nextInt();
                if(choice<1||choice>5&&choice<9||choice>9)
                    throw new InputMismatchException();
            }catch (InputMismatchException e) {
                System.err.println("Wrong input! Input only integer in range 1-5 or 9 to exit.");
                scanner.nextLine();
            }
            switch(choice) {
                case 1 -> {
                    System.out.println("Enter: \n1. Investment duration in yerars \n2. Desired amount of money \n3. Interest rate percentage");
                    try {
                        Tasks.investmentEstimate(scanner.nextInt(), scanner.nextDouble(), scanner.nextDouble());
                    }catch(InputMismatchException e) {
                        System.err.println("Wrong input! Input only valid numbers.");
                        scanner.nextLine();
                    }
                }
                case 2 -> {
                    System.out.println("Enter: \n1. Age of retirement \n2. Estimated life expectancy " +
                            "\n3. Amount of money invested \n4. Interest rate percentage");
                    try {
                        Tasks.annuityConverter(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble(), scanner.nextDouble());
                    }catch(InputMismatchException e) {
                        System.err.println("Wrong input! Input only valid numbers.");
                        scanner.nextLine();
                    }
                }
                case 3 -> {
                    System.out.println("Enter: \n1. Investment duration in years (amount of payments) \n2. Desired amount of money " +
                            "\n3. Interest rate percentage");
                    try {
                        Tasks.annualDepositEstimatate(scanner.nextInt(), scanner.nextDouble(), scanner.nextDouble());
                    }catch(InputMismatchException e) {
                        System.err.println("Wrong input! Input only valid numbers.");
                        scanner.nextLine();
                    }
                }
                case 4 -> {
                    System.out.println("Enter: \n1. Reliability of each unit");
                    try {
                        Tasks.successProbabilityCalculator(scanner.nextDouble());
                    }catch(InputMismatchException e) {
                        System.err.println("Wrong input! Input only valid numbers.");
                        scanner.nextLine();
                    }
                }
                case 5 -> {
                    System.out.println("Enter: \n1. Amount of men \n2. Amount of women \n3. Amount of children");
                    try {
                        Tasks.probabilityCalculator(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    }catch(InputMismatchException e) {
                        System.err.println("Wrong input! You can not enter negative amount of people!");
                        scanner.nextLine();
                    }
                }
                case 9 -> keepWorking = false;
            }





        }
    }
}
