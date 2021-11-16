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




}
=======
}
>>>>>>> 7c013df951d60267dacd8e8084e574ad727ea6f3:src/com/company/tasks/Task1.java
