import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CalculatorM31 calculatorM31 = new CalculatorM31();
        ArrayList<Double> anglesFi2List = calculatorM31.getAnglesFi2();
        ArrayList<Double> recoveryFactorList = calculatorM31.calculateRecoveryFactor(anglesFi2List);
        calculatorM31.getMiddleResult(recoveryFactorList);
        calculatorM31.getMiddleResult(anglesFi2List);
        ArrayList<Collision> collisionList = Collision.getTimeCollisionFromCsv();
        collisionList.forEach((it) -> {
            System.out.println(it.getAngle());
            it.setMiddleTime(calculatorM31.getMiddleResultFromInt(it.getTimes()));
            it.setLengthThread(0.34);
            it.setMassBall(0.112);
            calculatorM31.calculateM31(it);
        });
    }
}
