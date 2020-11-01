import java.util.ArrayList;
import java.util.Arrays;

class CalculatorM31 extends CommonCalculator {
    void calculateV10P10(Collision collision) {
        System.out.println("\nИзмерения для соударения под углом " + collision.getAngle());
        System.out.println("Среднее время соударения " + collision.getMiddleTime());
        System.out.println("Длина нити " + collision.getLengthThread());
        double anglesInRadians = Math.toRadians(collision.getAngle());
        double sqrtGL = Math.sqrt(Constants.GRAVITATIONAL_ACCELERATION * collision.getLengthThread());
        double sinus = Math.sin(anglesInRadians / 2);
        double V10 = 2 * sqrtGL * sinus;
        System.out.println("Скорость V10 " + V10);
        collision.setV10(V10);
        double P10 = 2 * collision.getMassBall() * sqrtGL * sinus;
        System.out.println("Импульс Р10 " + P10);
        double E10 = (collision.getMassBall() * (V10 * V10)) / 2;
        System.out.println("Энергия Е10 " + E10);
        double F10 = P10 / (collision.getMiddleTime() * Math.pow(10, -4));
        System.out.println("Модуль средней силы F10 " + F10);
    }

    ArrayList<Double> getAnglesFi2() {
        ArrayList<Double> resultList = new ArrayList<>();
        ArrayList<String> FiFromCsv = new CsvReader().reader("/Users/kristina/work/Lab/M31/src/main/resources/AnglesFi2.csv");
        for (String i : FiFromCsv) {
            Arrays.asList(i.split(",")).forEach((it) -> resultList.add(Double.parseDouble(it)));
        }
        return resultList;
    }

    ArrayList<Double> calculateRecoveryFactor(ArrayList<Double> anglesFi2) {
        ArrayList<Double> recoveryList = new ArrayList<>();
        for (double angle : anglesFi2) {
            double K = angle / ConstantsM31.ANGLE_FI_10;
            System.out.println("Коэффициент восстановления для угла " + angle + " равен " + K);
            recoveryList.add(K);
        }
        return recoveryList;
    }
}