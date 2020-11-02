import java.util.ArrayList;
import java.util.List;

public abstract class CommonCalculator {
    public Double getMiddleResult(List<Double> result) {
        Double sum = 0d;
        for (Double i : result) {
            sum += i;
        }
        Double middleResult = sum / result.size();
        System.out.println("Среднее значение " + middleResult);
        return middleResult;
    }

    public Double getMiddleResultFromInt(List<Integer> result) {
        Integer sum = 0;
        for (Integer i : result) {
            sum += i;
        }
        Double middleResult = Double.valueOf(sum) / result.size();
        System.out.println("Среднее значение " + middleResult);
        return middleResult;
    }

    public List<Double> getDeviance(List<Double> result, Double middleResult) {
        List<Double> listDeviance = new ArrayList<>();
        for (Double i : result) {
            Double deviance = i - middleResult;
            System.out.println("n-<n> " + deviance);
            listDeviance.add(deviance);
        }
        return listDeviance;
    }

    public List<Double> getSquareDeviance(List<Double> devianceList) {
        List<Double> listSquareDeviance = new ArrayList<>();
        for (Double i : devianceList) {
            Double squareDeviance = i * i;
            System.out.println("(n-<n>)^2 " + squareDeviance);
            listSquareDeviance.add(squareDeviance);
        }
        return listSquareDeviance;
    }

    public Double getRandomError(List<Double> squareDevianceList) {
        Double sumSquareDeviance = 0d;
        for (Double i : squareDevianceList) {
            sumSquareDeviance += i;
        }
        Integer numerator = squareDevianceList.size() * (squareDevianceList.size() - 1);
        System.out.println("в знаменателе погрешности " + numerator);
        Double randomError = Math.sqrt(sumSquareDeviance / numerator);
        System.out.println(" Случайная погрешность: " + randomError);
        return randomError;
    }
}