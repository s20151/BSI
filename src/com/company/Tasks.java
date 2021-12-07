Package com.company;

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
     * Method counts probability that only one of them will be selected.
     *
     * @param wifeProbability probability of wife's selection
     * @param husbandProbability probability of husband's selection
     * @throws InputMismatchException when user enters incorrect data
     */
    public static void probabilityOfChosingOnlyOne(double wifeProbability, double husbandProbability){
        if(wifeProbability < 0 || husbandProbability < 0 || wifeProbability > 1 || husbandProbability > 1)
            throw new InputMismatchException();
        double probability = wifeProbability * (1-husbandProbability) + husbandProbability * (1-wifeProbability);
        System.out.println("Probability that only one of them will be selected equals: "+ probability );
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

        annual_deposit = (rate/100)/(Math.pow((rate/100)+1,years)-1)*goal;

        System.out.println("To reach " + numberFormat.format(goal) + "$ in " +
                + years + " years with " + rate + "% interest rate, you should be depositing "
                + numberFormat.format(annual_deposit) + "$ each year.");
    }

    /**
     * Method required for binomial probability equation.
     * @param n number being factorialized
     * @return factoralized number
     */
     private static int factorial(int n){
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }

    /**
     * Equation of binomial distribution required to solve problem #16 from set 03, chapter II-III
     * Method calculates the probability of a success outcome in an experiment that is repeated multiple times.
     * The binomial is a type of distribution that has two possible outcomes.
     *
     * @param total_number_of_successes desired number of successes in whole experiment
     * @param probability_of_individual_success probability of success in one specific instance
     * @param number_of_trials number of times the experiment runs
     * @return binomial probability of success
     */
    private static double binomialDistribution(int total_number_of_successes, double probability_of_individual_success, int number_of_trials){
        double binomial_probability;

        binomial_probability = factorial(number_of_trials)/((factorial(number_of_trials-total_number_of_successes)*factorial(total_number_of_successes)))
                *Math.pow(probability_of_individual_success,total_number_of_successes)*Math.pow(1-probability_of_individual_success,number_of_trials-total_number_of_successes);

        return binomial_probability;
    }

    /**
     * Problem #16 from set 03, chapter II-III
     * Method calculates the probability of system success consisting of 4 units in the system
     * that requires at least 3 units to operate depending on the reliability of each unit.
     *
     * @param reliability how reliable is each unit 0,0-1,0
     * @throws InputMismatchException when user enters probability out of bounds
     */

    public static void successProbabilityCalculator(double reliability){
        if(reliability < 0.0 || reliability > 1.0)
            throw new InputMismatchException();

        double probability_3_operate = binomialDistribution(3,reliability,4);
        double probability_all_operate = binomialDistribution(4,reliability,4);
        double probability_of_system_success = probability_3_operate + probability_all_operate;

        System.out.println("Probability of system success that consists of 4 units and needs at least 3 units to operate when" +
                "the reliability of each memory unit equals " + reliability + " is " + probability_of_system_success + ".");

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
