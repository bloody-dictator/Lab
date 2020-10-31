import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> anglesFi2List = RecoveryFactor.getAnglesFi2();
        ArrayList<Double> recoveryFactorList = RecoveryFactor.calculateRecoveryFactor(anglesFi2List);
        CommonCalculator.getMiddleResult(recoveryFactorList);
        CommonCalculator.getMiddleResult(anglesFi2List);
        ArrayList<Collision> collisionList = Collision.getTimeCollisionFromCsv();
        collisionList.forEach((it) -> {
            System.out.println(it.getAngle());
            it.setMiddleTime(CommonCalculator.getMiddleResultFromInt(it.getTimes()));
            it.setLengthThread(0.34);
            it.setMassBall(0.112);
            CalculatorM31.calculateV10P10(it);
        });
    }
}
