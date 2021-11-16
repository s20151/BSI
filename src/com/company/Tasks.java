package com.company;

import java.text.DecimalFormat;

/**
 * This class consists exclusively of static methods that operate on integers and doubles,
 * solve given problems and print outcome on terminal. They do not return any value.
 *
 * @see DecimalFormat
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
     */
    public static void investmentEstimate(int years, double goal, double rate) {
        double investment = goal;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        for(int i=0; i<years; i++){
            investment=investment/(1+rate);
        }
        rate=rate*100;

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
        int years = goalAge - initialAge;
        double annual_income = investment;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        annual_income = annual_income + annual_income * rate;
        annual_income = annual_income - investment;
        annual_income = annual_income + annual_income * rate;

        System.out.println("To equally divide " + numberFormat.format(investment) + "$ for " + years + " years with " +
                rate*100 + "% interest rate, you will have " + numberFormat.format(annual_income) + " annual income.");
    }

    /**
     * Problem #3 from set 03, chapter V
     * Method counts annual deposit amount required to achive desired amount of money
     * on course of given amount of years.
     *
     * @param years amount of years = amount of deposits
     * @param goal desired amount of money
     * @param rate interest rate percentage 1-100%
     */
    public static void annualDepositEstimatate(int years, double goal, double rate) {
        double annual_deposit = goal;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        for(int i=0; i<years; i++){
            annual_deposit=annual_deposit/(1+rate);
        }


        System.out.println("To reach " + numberFormat.format(goal) + "$ in " +
                + years + " years with " + rate*100 + "% interest rate, you should be depositing "
                + numberFormat.format(annual_deposit) + "$ each year.");
    }
}
