import java.util.ArrayList;

public class CommonCalculator {
    public static Double getMiddleResult(ArrayList<Double> result) {
        double sum = 0;
        for (double i : result) {
            sum += i;
        }
        double middleResult = sum / result.size();
        System.out.println("Среднее значение " + middleResult);
        return middleResult;
    }

    public static Double getMiddleResultFromInt(ArrayList<Integer> result) {
        Integer sum = 0;
        for (Integer i : result) {
            sum += i;
        }
        double middleResult = Double.valueOf(sum) / result.size();
        System.out.println("Среднее значение " + middleResult);
        return middleResult;
    }

    public static ArrayList<Double> getDeviance(ArrayList<Double> result, double middleResult) {
        ArrayList<Double> listDeviance = new ArrayList<>();
        for (double i : result) {
            double deviance = i - middleResult;
            System.out.println("n-<n> " + deviance);
            listDeviance.add(deviance);
        }
        return listDeviance;
    }

    public static ArrayList<Double> getSquareDeviance(ArrayList<Double> devianceList) {
        ArrayList<Double> listSquareDeviance = new ArrayList<>();
        for (double i : devianceList) {
            double squareDeviance = i * i;
            System.out.println("(n-<n>)^2 " + squareDeviance);
            listSquareDeviance.add(squareDeviance);
        }
        return listSquareDeviance;
    }

    public static double getRandomError(ArrayList<Double> squareDevianceList) {
        double sumSquareDeviance = 0;
        for (double i : squareDevianceList) {
            sumSquareDeviance += i;
        }
        int numerator = squareDevianceList.size() * (squareDevianceList.size() - 1);
        System.out.println("в знаменателе погрешности " + numerator);
        double randomError = Math.sqrt(sumSquareDeviance / numerator);
        System.out.println(" Случайная погрешность: " + randomError);
        return randomError;
    }
}