package com.company;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.InputMismatchException;


public class TasksTest extends Tasks {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void investmentEstimateShouldBe719435(){
        double goal = 40000;
        int years = 18;
        double rate = 10;

        String expectedResponse = "You should invest 7194,35$ to reach 40000,00$ in 18 years with 10.0% interest rate.";
        Assert.assertEquals(expectedResponse, investmentEstimate(years, goal, rate));
    }

    @Test
    public void investmentEstimateShouldBe311000(){
        double goal = 30000;
        int years = 20;
        double rate = 12;

        String expectedResponse = "You should invest 3110,00$ to reach 30000,00$ in 20 years with 12.0% interest rate.";
        Assert.assertEquals(expectedResponse, investmentEstimate(years, goal, rate));
    }

    @Test
    public void investmentEstimateThrowInputMismatch(){
        exception.expect(InputMismatchException.class);
        investmentEstimate(10,10000,101);
    }

    @Test
    public void probabilityOfChoosingShouldBe0275(){
        double husbandProbability = 0.125;
        double wifeProbability = 0.2;

        String expectedResponse = "Probability that only one of them will be selected equals: 0.275";
        Assert.assertEquals(expectedResponse, probabilityOfChoosingOnlyOne(wifeProbability,husbandProbability));
    }

    @Test
    public void probabilityOfChoosingThrowInputMismatch(){
        exception.expect(InputMismatchException.class);
        probabilityOfChoosingOnlyOne(1.2,0.2);
    }

    @Test
    public void annualDepositEstimateShouldBe1589609(){
        double goal = 300000;
        int years = 10;
        double rate = 13.5;

        String expectedResponse = "To reach 300000,00$ in 10 years with 13.5% interest rate, you should be depositing 15896,09$ each year.";
        Assert.assertEquals(expectedResponse, annualDepositEstimate(years,goal,rate));
    }

    @Test
    public void annualDepositEstimateShouldBe(){
        double goal = 500000;
        int years = 12;
        double rate = 14.5;

        String expectedResponse = "To reach 500000,00$ in 12 years with 14.5% interest rate, you should be depositing 17779,69$ each year.";
        Assert.assertEquals(expectedResponse, annualDepositEstimate(years,goal,rate));
    }

    @Test
    public void annualDepositEstimateThrowInputMismatch(){
        exception.expect(InputMismatchException.class);
        annualDepositEstimate(15,450000,104);
    }

    @Test
    public void factorialShouldBe6(){
        int expectedResult = 6;
        int actualResult = factorial(3);

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void factorialShouldBe2004310016(){
        int expectedResult = 2004310016;
        int actualResult = factorial(15);

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void binomialDistributionShouldBe03456(){
        double expectedResult = 0.3456;
        double actualResult = binomialDistribution(3,0.6,5);

        Assert.assertEquals(expectedResult,actualResult,0);
    }

    @Test
    public void binomialDistributionShouldBe(){
        double expectedResult = 0.04668;
        double actualResult = binomialDistribution(5,0.3,8);

        Assert.assertEquals(expectedResult,actualResult,0.00001);
    }

    @Test
    public void successProbabilityShouldBe09477(){
        double reliability = 0.9;

        String expectedResponse = "Probability of system success that consists of 4 units and needs at least 3 units to operate " +
                "when the reliability of each memory unit equals 0.9 is 0.9477.";
        String actualResponse = successProbabilityCalculator(reliability);
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void successProbabilityShouldBe013623552(){
        double reliability = 0.36;

        String expectedResponse = "Probability of system success that consists of 4 units and needs at least 3 units to operate " +
                "when the reliability of each memory unit equals 0.36 is 0.13623552.";
        String actualResponse = successProbabilityCalculator(reliability);
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void successProbabilityThrowInputMismatchException(){
        exception.expect(InputMismatchException.class);
        successProbabilityCalculator(2);
    }

    @Test
    public void probabilityCalculatorShouldBe0794(){
        int men = 3;
        int women = 2;
        int children = 4;

        String expectedResponse = "Probability of randomly choosing exactly 2 children from a group of 9 people is 7,94%.";
        String actualResponse = probabilityCalculator(men, women, children);
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void probabilityCalculatorShouldBe0265(){
        int men = 15;
        int women = 12;
        int children = 7;

        String expectedResponse = "Probability of randomly choosing exactly 2 children from a group of 34 people is 2,65%.";
        String actualResponse = probabilityCalculator(men, women, children);
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void probabilityCalculatorThrowInputMismatchException(){
        int men = 1;
        int women = 0;
        int children = 2;

        exception.expect(InputMismatchException.class);
        probabilityCalculator(men, women, children);
    }

    @Test
    public void probabilityCalculatorThrowInputMismatchException2(){
        int men = 5;
        int women = 4;
        int children = 1;

        exception.expect(InputMismatchException.class);
        probabilityCalculator(men, women, children);
    }
}
