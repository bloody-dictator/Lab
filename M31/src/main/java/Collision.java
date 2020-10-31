import java.util.ArrayList;
import java.util.Arrays;

class Collision {
    private int angle;
    private ArrayList<Integer> times;
    private double lengthThread;
    private double middleTime;
    private double V10;
    private double massBall;

    protected Collision(int angle, ArrayList<Integer> times) {
        this.angle = angle;
        this.times = times;
    }

    protected ArrayList<Integer> getTimes() {
        return times;
    }

    protected int getAngle() {
        return angle;
    }

    protected double getMiddleTime() {
        return middleTime;
    }

    protected void setMiddleTime(double middleTime) {
        this.middleTime = middleTime;
    }

    protected double getMassBall() {
        return massBall;
    }

    protected void setMassBall(double massBall) {
        this.massBall = massBall;
    }

    protected double getV10() {
        return V10;
    }

    protected void setV10(double v10) {
        V10 = v10;
    }

    protected void setTimes(ArrayList<Integer> times) {
        this.times = times;
    }

    protected void setAngle(int angle) {
        this.angle = angle;
    }

    protected double getLengthThread() {
        return lengthThread;
    }

    protected void setLengthThread(double lengthThread) {
        this.lengthThread = lengthThread;
    }

    protected static ArrayList<Collision> getTimeCollisionFromCsv() {
        ArrayList<Collision> listCollision = new ArrayList<>();
        ArrayList<String> listTimeCollisionFromCsv = CsvReader.reader("/Users/kristina/work/Lab/M31/src/main/resources/timeCollision.csv");
        for (String i : listTimeCollisionFromCsv) {
            ArrayList<String> fromCsv = new ArrayList<>(Arrays.asList((i.split(","))));
            Integer angle = Integer.parseInt(fromCsv.get(0));
            fromCsv.remove(0);
            ArrayList<Integer> times = new ArrayList<>();
            fromCsv.forEach((it) -> times.add(Integer.parseInt(it)));
            listCollision.add(new Collision(angle, times));
        }
        return listCollision;
    }
}