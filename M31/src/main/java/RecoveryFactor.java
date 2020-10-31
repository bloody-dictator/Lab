import java.util.ArrayList;
import java.util.Arrays;

class RecoveryFactor {
    protected static ArrayList<Double> getAnglesFi2() {
        ArrayList<Double> resultList = new ArrayList<>();
        ArrayList<String> FiFromCsv = CsvReader.reader("/Users/kristina/work/Lab/M31/src/main/resources/AnglesFi2.csv");
        for (String i : FiFromCsv) {
            Arrays.asList(i.split(",")).forEach((it) -> resultList.add(Double.parseDouble(it)));
        }
        return resultList;
    }

    protected static ArrayList<Double> calculateRecoveryFactor(ArrayList<Double> anglesFi2) {
        ArrayList<Double> recoveryList = new ArrayList<>();
        for (double angle : anglesFi2) {
            double K = angle / ConstantsM31.ANGLE_FI_10;
            System.out.println("Коэффициент восстановления для угла " + angle + " равен " + K);
            recoveryList.add(K);
        }
        return recoveryList;
    }
}