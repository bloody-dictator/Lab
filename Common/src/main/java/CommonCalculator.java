import java.util.ArrayList;
import java.util.List;

public abstract class CommonCalculator {
    public Double getMiddleResult(List<Double> result) {
        Double middleResult = result.stream().reduce(Double::sum).orElse(0d)/result.size();
        FileOut.stringBuilder.append("\nСреднее значение ").append(middleResult);
        return middleResult;
    }

    public Double getMiddleResultFromInt(List<Integer> result) {
        Integer sum = result.stream().reduce(Integer::sum).orElse(0);
        Double middleResult = Double.valueOf(sum) / result.size();
        FileOut.stringBuilder.append("\nСреднее значение ").append(middleResult);
        return middleResult;
    }

    public List<Double> getDeviance(List<Double> result, Double middleResult) {
        List<Double> listDeviance = new ArrayList<>();
        for (Double i : result) {
            Double deviance = i - middleResult;
            FileOut.stringBuilder.append("\nn-<n> ").append(deviance);
            listDeviance.add(deviance);
        }
        return listDeviance;
    }

    public List<Double> getSquareDeviance(List<Double> devianceList) {
        List<Double> listSquareDeviance = new ArrayList<>();
        for (Double i : devianceList) {
            Double squareDeviance = i * i;
            FileOut.stringBuilder.append("\n(n-<n>)^2 ").append(squareDeviance);
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
        FileOut.stringBuilder.append("\nв знаменателе погрешности ").append(numerator);
        Double randomError = Math.sqrt(sumSquareDeviance / numerator);
        FileOut.stringBuilder.append("\nСлучайная погрешность: ").append(randomError);
        return randomError;
    }
}