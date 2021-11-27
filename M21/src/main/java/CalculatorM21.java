import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CalculatorM21 extends CommonCalculator {
    //вычисление динамической вязкости
    public  double calculateDynamicViscosity(Ball ball, Liquid liquid, Vessel vessel) {
        double difference = ball.getDensity() - liquid.getDensityLiquid();
        System.out.println("\np - p1: " + difference);
        double square = Math.pow(ball.getRadius(), 2);
        System.out.println("квадрат радиуса мяча: " + square);
        double numerator = 2 * square * Constants.GRAVITATIONAL_ACCELERATION * (difference) * ball.getTime();
        System.out.println("в числителе: 2r^2*g(p-p1)*t " + numerator);
        double denominator = 9 * vessel.getDistanceK1K2();
        System.out.println("В знаменателе:" + denominator);
        if(denominator==0.0){
            System.out.println("Вычисление невозможно, знаменатель меньше 0");
            return 0.0;
        }
        return numerator / denominator;
    }
//получение из файла csv результатов измерений - 1)радиус 2)плотность 3)время движения шарика между рисками
    List<Ball> getBallsFromCsv(String filepath) {
        List<Ball> resultBallList = new ArrayList<>();
        List<String> ballList = new CsvReader().read(filepath);
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

    //вычисление динамической вязкости в цикле для списка шаров
    List<Double> calculateResultM11(List<Ball> ballList, Liquid liquid, Vessel vessel) {
        List<Double> results = new ArrayList<>();
        for (Ball i : ballList) {
            double result = this.calculateDynamicViscosity(i, liquid, vessel);
            results.add(result);
            System.out.println(result);
        }
        return results;
    }
/*поправка - коэффициент К, на который нужно умножить полученное значение 〈η,
 чтобы исключить из результата измерений вязкости систематическую погрешность,
 возникшую из-за влияния стенок со- суда при движении шарика
 */
    public List<Double> calculateCoefficientK(List<Ball> ballList, Vessel vessel) {
        List<Double> listKResults = new ArrayList<>();
        if(vessel.getRadiusVessel() == 0){
            System.out.println("Вычисление невозможно, знаменатель равен нулю");
            return null;
        }
        for (Ball i : ballList) {
            double numerator = 1 + ((2.4 * i.getRadius()) / vessel.getRadiusVessel());
            if (numerator==0.0){
                System.out.println("Вычисление невозможно, знаменатель равен нулю");
                return null;
            }
            double k = 1 / numerator;
            System.out.println("Коэффициент К " + k);
            listKResults.add(k);
        }
        return listKResults;
    }
}