import java.util.ArrayList;
import java.util.Arrays;

class Collision {
    private int angle;
    private ArrayList<Integer> times;
    private double lengthThread;
    private double middleTime;
    private double V10;
    private double massBall;

    Collision(int angle, ArrayList<Integer> times) {
        this.angle = angle;
        this.times = times;
    }

    ArrayList<Integer> getTimes() {
        return times;
    }

    int getAngle() {
        return angle;
    }

    double getMiddleTime() {
        return middleTime;
    }

    void setMiddleTime(double middleTime) {
        this.middleTime = middleTime;
    }

    double getMassBall() {
        return massBall;
    }

    void setMassBall(double massBall) {
        this.massBall = massBall;
    }

    double getV10() {
        return V10;
    }

    void setV10(double v10) {
        V10 = v10;
    }

    void setTimes(ArrayList<Integer> times) {
        this.times = times;
    }

    void setAngle(int angle) {
        this.angle = angle;
    }

    double getLengthThread() {
        return lengthThread;
    }

    void setLengthThread(double lengthThread) {
        this.lengthThread = lengthThread;
    }

    static ArrayList<Collision> getTimeCollisionFromCsv() {
        ArrayList<Collision> listCollision = new ArrayList<>();
        ArrayList<String> listTimeCollisionFromCsv = new CsvReader().reader("/Users/kristina/work/Lab/M31/src/main/resources/timeCollision.csv");
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