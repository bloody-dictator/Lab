import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculatorM31 calculatorM31 = new CalculatorM31();
        List<Double> anglesFi2List = calculatorM31.getAnglesFi2();
        List<Double> recoveryFactorList = calculatorM31.calculateRecoveryFactor(anglesFi2List);
        calculatorM31.getMiddleResult(recoveryFactorList);
        calculatorM31.getMiddleResult(anglesFi2List);
        List<Collision> collisionList = calculatorM31.getTimeCollisionFromCsv("timeCollision.csv");
        collisionList.forEach((it) -> {
            System.out.println(it.getAngle());
            it.setMiddleTime(calculatorM31.getMiddleResultFromInt(it.getTimes()));
            it.setLengthThread(0.34);
            it.setMassBall(0.112);
            calculatorM31.calculateM31(it);
        });
        FileOut.fileWrite(Constants.M31_FILEPATH, FileOut.stringBuilder.toString());
        EmailSender.wrapperSendMail(Constants.M31_FILEPATH);
    }
}
