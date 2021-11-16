package com.company.tasks;


import java.text.DecimalFormat;

//03_chapter_V_2
public class Task2 {

    public static void annuity_converter(int initial_age, int goal_age, double investment, double rate){
        int years = goal_age - initial_age;
        double annual_income = investment;
        DecimalFormat numberFormat = new DecimalFormat("#.00");

            annual_income = annual_income + annual_income * rate;
            annual_income = annual_income - investment;
            annual_income = annual_income + annual_income * rate;


        System.out.println("To equally divide " + numberFormat.format(investment) + "$ for " + years + " years with " +
                rate*100 + "% interest rate, you will have " + numberFormat.format(annual_income) + " annual income.");
    }
}
