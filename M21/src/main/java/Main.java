import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Liquid liquid = new Liquid(1260.0);
        Vessel vessel = new Vessel(0.233, 0.032);
        CalculatorM21 calculatorM21 = new CalculatorM21();
        ArrayList<Ball> ballList = CalculatorM21.ballsFromCsv();
        ArrayList<Double> viscosityList = CalculatorM21.calculateResultM11(ballList, liquid, vessel);
        double middleResult = calculatorM21.getMiddleResult(viscosityList);
        ArrayList<Double> listDeviance = calculatorM21.getDeviance(viscosityList, middleResult);
        ArrayList<Double> listSquareDeviance = calculatorM21.getSquareDeviance(listDeviance);
        System.out.println("Случайная погрешность с коэффициентом Стьюдента "+calculatorM21.getRandomError(listSquareDeviance)*Constants.STUDENT_COEFFICIENTFOR4);
        ArrayList<Double> coefficients = CalculatorM21.getCoefficientK(ballList, vessel);
        calculatorM21.getMiddleResult(coefficients);
    }
}
