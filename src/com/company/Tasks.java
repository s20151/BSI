package com.company;

import java.text.DecimalFormat;

/**
 * Class includes all five methods used to calculate our problems.
 */
public class Tasks {
    /**
     *  Problem #1 from set 03, chapter V
     * Function counts how much should we invest to achive given goal with given interest rest for given amount of years.
     *
     * @param years - amount of years
     * @param goal -  amount o money we want to achive
     * @param rate - interest rate percentage 1-100%
     * @function prints
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

    public static void annuityConverter(int initial_age, int goal_age, double investment, double rate){
        int years = goal_age - initial_age;
        double annual_income = investment;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        annual_income = annual_income + annual_income * rate;
        annual_income = annual_income - investment;
        annual_income = annual_income + annual_income * rate;


        System.out.println("To equally divide " + numberFormat.format(investment) + "$ for " + years + " years with " +
                rate*100 + "% interest rate, you will have " + numberFormat.format(annual_income) + " annual income.");
    }

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
