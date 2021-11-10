package com.company.tasks;

import java.text.DecimalFormat;

//03_chapter_V_1
public class Task1 {

    public static void investment_estimate(int years, double goal, double rate) {
        double investment = goal;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        for(int i=0; i<years; i++){
            investment=investment/(1+rate);
        }

        rate=rate*100;

        System.out.println("You should invest " + numberFormat.format(investment) + "$ to reach " +
                numberFormat.format(goal) + "$ in " + years + " years with " + rate + "% interest rate.");
    }

}