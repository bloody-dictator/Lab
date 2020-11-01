import java.util.ArrayList;

public abstract class CommonCalculator {
    public Double getMiddleResult(ArrayList<Double> result) {
        Double sum = 0d;
        for (Double i : result) {
            sum += i;
        }
        Double middleResult = sum / result.size();
        System.out.println("Среднее значение " + middleResult);
        return middleResult;
    }

    public Double getMiddleResultFromInt(ArrayList<Integer> result) {
        Integer sum = 0;
        for (Integer i : result) {
            sum += i;
        }
        double middleResult = Double.valueOf(sum) / result.size();
        System.out.println("Среднее значение " + middleResult);
        return middleResult;
    }

    public ArrayList<Double> getDeviance(ArrayList<Double> result, Double middleResult) {
        ArrayList<Double> listDeviance = new ArrayList<>();
        for (Double i : result) {
            Double deviance = i - middleResult;
            System.out.println("n-<n> " + deviance);
            listDeviance.add(deviance);
        }
        return listDeviance;
    }

    public ArrayList<Double> getSquareDeviance(ArrayList<Double> devianceList) {
        ArrayList<Double> listSquareDeviance = new ArrayList<>();
        for (Double i : devianceList) {
            Double squareDeviance = i * i;
            System.out.println("(n-<n>)^2 " + squareDeviance);
            listSquareDeviance.add(squareDeviance);
        }
        return listSquareDeviance;
    }

    public double getRandomError(ArrayList<Double> squareDevianceList) {
        double sumSquareDeviance = 0;
        for (Double i : squareDevianceList) {
            sumSquareDeviance += i;
        }
        int numerator = squareDevianceList.size() * (squareDevianceList.size() - 1);
        System.out.println("в знаменателе погрешности " + numerator);
        double randomError = Math.sqrt(sumSquareDeviance / numerator);
        System.out.println(" Случайная погрешность: " + randomError);
        return randomError;
    }
}