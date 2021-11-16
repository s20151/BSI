package com.company.tasks;

import java.text.DecimalFormat;

//03_chapter_V_3
public class Task3 {

    public static void annual_deposit_estimatate(int years, double goal, double rate) {
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
