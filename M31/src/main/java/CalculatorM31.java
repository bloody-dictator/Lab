import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CalculatorM31 extends CommonCalculator {
    void calculateM31(Collision collision) {
        System.out.println("\nИзмерения для соударения под углом " + collision.getAngle());
        System.out.println("Среднее время соударения " + collision.getMiddleTime());
        System.out.println("Длина нити " + collision.getLengthThread());
        double V10 = this.calculateV10(collision);
        System.out.println("Скорость V10 " + V10);
        collision.setV10(V10);
        double P10 = this.calculateP10(collision);
        collision.setP10(P10);
        System.out.println("Импульс Р10 " + P10);
        double E10 = this.calculateE10(collision);
        System.out.println("Энергия Е10 " + E10);
        double F10 = this.calculateF10(collision);
        System.out.println("Модуль средней силы F10 " + F10);
    }

    Double calculateV10(Collision collision){
        return  2 * collision.getSqrtGL() * collision.getSinus();
    }

    Double calculateP10(Collision collision){
        return  2 * collision.getMassBall() * collision.getSqrtGL() * collision.getSinus();
    }

    Double calculateE10(Collision collision){
        double V10 = collision.getV10();
        return (collision.getMassBall() * (V10 * V10)) / 2;
    }

    Double calculateF10(Collision collision){
        return collision.getP10() / (collision.getMiddleTime() * Math.pow(10, -4));
    }

    List<Double> getAnglesFi2() {
        List<Double> resultList = new ArrayList<>();
        List<String> FiFromCsv = new CsvReader().read("AnglesFi2.csv");
        for (String i : FiFromCsv) {
            Arrays.asList(i.split(",")).forEach((it) -> resultList.add(Double.parseDouble(it)));
        }
        return resultList;
    }

    List<Double> calculateRecoveryFactor(List<Double> anglesFi2) {
        List<Double> recoveryList = new ArrayList<>();
        for (double angle : anglesFi2) {
            double K = angle / ConstantsM31.ANGLE_FI_10;
            System.out.println("Коэффициент восстановления для угла " + angle + " равен " + K);
            recoveryList.add(K);
        }
        return recoveryList;
    }

    List<Collision> getTimeCollisionFromCsv(String filepath) {
        List<Collision> listCollision = new ArrayList<>();
        List<String> listTimeCollisionFromCsv = new CsvReader().read(filepath);
        for (String i : listTimeCollisionFromCsv) {
            List<String> fromCsv = new ArrayList<>(Arrays.asList((i.split(","))));
            int angle = Integer.parseInt(fromCsv.get(0));
            fromCsv.remove(0);
            List<Integer> times = new ArrayList<>();
            fromCsv.forEach((it) -> times.add(Integer.parseInt(it)));
            listCollision.add(new Collision(angle, times));
        }
        return listCollision;
    }
}