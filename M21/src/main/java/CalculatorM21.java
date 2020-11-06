import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CalculatorM21 extends CommonCalculator {
    double calculateDynamicViscosity(Ball ball, Liquid liquid, Vessel vessel) {
        double difference = ball.getDensity() - liquid.getDensityLiquid();
        System.out.println("\np - p1: " + difference);
        double square = Math.pow(ball.getRadius(), 2);
        System.out.println("квадрат радиуса мяча: " + square);
        double numerator = 2 * square * Constants.GRAVITATIONAL_ACCELERATION * (difference) * ball.getTime();
        System.out.println("в числителе: 2r^2*g(p-p1)*t " + numerator);
        double denominator = 9 * vessel.getDistanceK1K2();
        System.out.println("В знаменателе:" + denominator);
        return numerator / denominator;
    }

    List<Ball> getBallsFromCsv() {
        List<Ball> resultBallList = new ArrayList<>();
        List<String> ballList = new CsvReader().read("ballList.csv");
        for (String i : ballList) {
            List<String> fromCsv = Arrays.asList(i.split(","));
            resultBallList.add(new Ball(
                    Double.parseDouble(fromCsv.get(0)),
                    Double.parseDouble(fromCsv.get(1)),
                    Double.parseDouble(fromCsv.get(2))
            ));
        }
        return resultBallList;
    }

    List<Double> calculateResultM11(List<Ball> ballList, Liquid liquid, Vessel vessel) {
        List<Double> results = new ArrayList<>();
        for (Ball i : ballList) {
            double result = this.calculateDynamicViscosity(i, liquid, vessel);
            results.add(result);
            System.out.println(result);
        }
        return results;
    }

     List<Double> calculateCoefficientK(List<Ball> ballList, Vessel vessel) {
        List<Double> listKResults = new ArrayList<>();
        for (Ball i : ballList) {
            double numerator = 1 + ((2.4 * i.getRadius()) / vessel.getRadiusVessel());
            double k = 1 / numerator;
            System.out.println("Коэффициент К " + k);
            listKResults.add(k);
        }
        return listKResults;
    }
}