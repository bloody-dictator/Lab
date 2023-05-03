import java.util.List;

public class Main {

    public static void main(String[] args) {
        Liquid liquid = new Liquid(1260.0);
        Vessel vessel = new Vessel(0.233, 0.032);
        CalculatorM21 calculatorM21 = new CalculatorM21();
        List<Ball> ballList = calculatorM21.getBallsFromCsv("ballList.csv");
        List<Double> viscosityList = calculatorM21.calculateResultM11(ballList, liquid, vessel);
        if (!viscosityList.isEmpty()){
            double middleResult = calculatorM21.getMiddleResult(viscosityList);
            List<Double> listDeviance = calculatorM21.getDeviance(viscosityList, middleResult);
            List<Double> listSquareDeviance = calculatorM21.getSquareDeviance(listDeviance);
            FileOut.stringBuilder.append("\nСлучайная погрешность с коэффициентом Стьюдента ").append(calculatorM21.getRandomError(listSquareDeviance) * Constants.STUDENT_COEFFICIENTFOR4);
            List<Double> coefficients = calculatorM21.calculateCoefficientK(ballList, vessel);
            calculatorM21.getMiddleResult(coefficients);
            FileOut.fileWrite(Constants.M21_FILEPATH, FileOut.stringBuilder.toString());
            EmailSender.wrapperSendMail(Constants.M21_FILEPATH);
        }else System.out.println("Файл balllist.csv пуст, вычисления невозможны!");
    }
}
