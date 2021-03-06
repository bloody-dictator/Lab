import java.util.List;

public class Main {
    public static void main(String[] args) {
        Liquid liquid = new Liquid(1260.0);
        Vessel vessel = new Vessel(0.233, 0.032);
        CalculatorM21 calculatorM21 = new CalculatorM21();
        List<Ball> ballList = calculatorM21.getBallsFromCsv();
        List<Double> viscosityList = calculatorM21.calculateResultM11(ballList, liquid, vessel);
        double middleResult = calculatorM21.getMiddleResult(viscosityList);
        List<Double> listDeviance = calculatorM21.getDeviance(viscosityList, middleResult);
        List<Double> listSquareDeviance = calculatorM21.getSquareDeviance(listDeviance);
        System.out.println("Случайная погрешность с коэффициентом Стьюдента "+calculatorM21.getRandomError(listSquareDeviance)*Constants.STUDENT_COEFFICIENTFOR4);
        List<Double> coefficients = calculatorM21.calculateCoefficientK(ballList, vessel);
        calculatorM21.getMiddleResult(coefficients);
    }
}
