import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Liquid liquid = new Liquid(1260.0);
        Vessel vessel = new Vessel(0.4, 0.035);
        ArrayList<Ball> ballList = Calculator.ballsFromCsv();
        ArrayList<Double> viscosityList = Calculator.calculateResultM11(ballList, liquid, vessel);
        double middleResult = CommonCalculator.getMiddleResult(viscosityList);
        ArrayList<Double> listDeviance = CommonCalculator.getDeviance(viscosityList, middleResult);
        ArrayList<Double> listSquareDeviance = CommonCalculator.getSquareDeviance(listDeviance);
        System.out.println("Случайная погрешность с коэффициентом Стьюдента "+CommonCalculator.getRandomError(listSquareDeviance)*Constants.STUDENT_COEFFICIENTFOR4);
        Calculator.getCoefficientK(ballList, vessel);
    }
}