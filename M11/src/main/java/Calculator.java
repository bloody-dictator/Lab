import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static ArrayList<Ball> scanningBalls(){
        ArrayList<Ball>listBalls = new ArrayList<>();
        int count = 5;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Дробные значение типа double вводить с запятой!!!!!!!");
        for(int i = 0; i<count; i++){
            double radius = 0d;
            double density = 0d;
            double time = 0d;
            System.out.println("Введите радиус шара №"+i);
            if(scanner.hasNextDouble()){
                radius = scanner.nextDouble();
            }
            System.out.println("Введите плотность шара №"+i);
            if(scanner.hasNextDouble()){
                density = scanner.nextDouble();
            }
            System.out.println("Введите время движения шара №"+i);
            if(scanner.hasNextDouble()){
                time = scanner.nextDouble();
            }
            listBalls.add(new Ball(radius, density, time));
        }
        return listBalls;
    }

    private static double calculateDynamicViscosity(Ball ball, Liquid liquid, Vessel vessel){
        double difference = ball.getDensity() - liquid.getDensityLiquid();
        System.out.println("\np - p1: "+difference);
        double square = Math.pow(ball.getRadius(), 2);
        System.out.println("квадрат радиуса мяча: "+square);
        double numerator = 2*square*Constants.GRAVITATIONAL_ACCELERATION*(difference)*ball.getTime();
        System.out.println("в числителе: 2r^2*g(p-p1)*t "+numerator);
        double denominator = 9* vessel.getDistanceK1K2();
        System.out.println("В знаменателе:" + denominator);
        return numerator/denominator;
    }

    protected static ArrayList<Ball> ballsFromCsv(){
        ArrayList<Ball> resultBallList = new ArrayList<>();
        ArrayList<String> ballList = CsvReader.reader("/Users/kristina/work/Lab/M11/src/main/resources/ballList.csv");
        for (String i : ballList){
            List<String> fromcsv = Arrays.asList(i.split(","));
            resultBallList.add(new Ball(Double.parseDouble(fromcsv.get(0)),
                    Double.parseDouble(fromcsv.get(1)),
                    Double.parseDouble(fromcsv.get(2))));
        }
        return resultBallList;
    }

    public static ArrayList<Double> calculateResultM11(ArrayList<Ball> ballList, Liquid liquid, Vessel vessel){
        ArrayList<Double>results = new ArrayList<>();
        for(Ball i: ballList){
            double result = calculateDynamicViscosity(i, liquid, vessel);
            results.add(result);
            System.out.println(result);
        }
        return results;
    }

    public static ArrayList<Double> getCoefficientK(ArrayList<Ball> ballList, Vessel vessel){
        ArrayList<Double>listKResults = new ArrayList<>();
        for(Ball i: ballList){
            double numerator = 1+ ((2.4*i.getRadius())/vessel.getRadiusVessel());
            double k = 1/numerator;
            System.out.println("Коэффициент К "+ k);
            listKResults.add(k);
        }
        return listKResults;
    }
}
