package com.company;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

/**
 * This class consists exclusively of static methods that operate on integers and doubles,
 * solve given problems and print outcome on terminal. They do not return any value.
 *
 * @see DecimalFormat
 * @see InputMismatchException
 * @author Norbert Leśniak s20151
 * @author Artur Piszczatowski s20487
 */
public class Tasks {

    /**
     * Problem #1 from set 03, chapter V
     * Method counts how much money should person put into fund to achive
     * given amount of money with given interest rest for given amount of years.
     *
     * @param years investment duration in years
     * @param goal amount o money person wants to achive
     * @param rate interest rate percentage 1-100%
     * @throws InputMismatchException when user enters incorrect data
     */
    public static void investmentEstimate(int years, double goal, double rate) {
        if(years < 0 || goal < 0 || rate < 0 || rate > 100 )
            throw new InputMismatchException();
        double investment = goal;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        for(int i=0; i<years; i++){
            investment=investment/(1+rate/100);
        }
        rate/=100;

        System.out.println("You should invest " + numberFormat.format(investment) + "$ to reach " +
                numberFormat.format(goal) + "$ in " + years + " years with " + rate*100 + "% interest rate.");
    }

    /**
     * Problem #2 from set 03, chapter V
     *  Method counts annual retirement income on course of retirement based on
     *  amount of money invested, interest rate and retirement duration (goalAge - initialAge).
     *
     * @param initialAge age of retirement
     * @param goalAge estimated life expectancy
     * @param investment amount of money to invest
     * @param rate interest rate percentage 1-100%
     */
    public static void annuityConverter(int initialAge, int goalAge, double investment, double rate){
        if(initialAge < 0 || goalAge < 0 || rate < 0 || investment < 0 || rate > 100)
            throw new InputMismatchException();
        int years = goalAge - initialAge;
        double annual_income = investment;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        annual_income = annual_income + annual_income * rate/100;
        annual_income = annual_income - investment;
        annual_income = annual_income + annual_income * rate/100;

        System.out.println("To equally divide " + numberFormat.format(investment) + "$ for " + years + " years with " +
                rate + "% interest rate, you will have " + numberFormat.format(annual_income) + " annual income.");
    }

    /**
     * Problem #3 from set 03, chapter V
     * Method counts annual deposit amount required to achive desired amount of money
     * on course of given amount of years.
     *
     * @param years amount of years = amount of deposits
     * @param goal desired amount of money
     * @param rate interest rate percentage 1-100%
     * @throws InputMismatchException when user enters incorrect data
     */
    public static void annualDepositEstimatate(int years, double goal, double rate) {
        if(years < 0 || goal < 0 || rate < 0 || rate > 100)
            throw new InputMismatchException();
        double annual_deposit = goal;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        annual_deposit = rate/(Math.pow(rate+1,years)-1)*goal;

        System.out.println("To reach " + numberFormat.format(goal) + "$ in " +
                + years + " years with " + rate*100 + "% interest rate, you should be depositing "
                + numberFormat.format(annual_deposit) + "$ each year.");
    }

    /**
     * Problem #30 from set 02
     * Method counts probability of randomly choosing exactly 2 children from a group
     * of given amount of men, women and children.
     *
     * @param men amount of men
     * @param women amount of women
     * @param children amount of children
     * @throws InputMismatchException when user enters incorrect data
     */
    public static void probabilityCalculator(int men, int women, int children) {
        if(men < 0 || women < 0 || children < 0)
            throw new InputMismatchException();
        double all = men + women + children;
        double probability;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        double first_child = children/all;
        double second_child = (children-1)/(all-1);
        double third_not_child = (men+women)/(all-2);
        double forth_not_child = (men+women-1)/(all-3);

        probability = first_child*second_child*third_not_child*forth_not_child;

        System.out.println("Probability of randomly choosing exactly 2 children from a group of "
                + (int)all + " people is " + numberFormat.format(probability*100) + "%.");
    }
}
