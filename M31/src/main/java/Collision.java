import java.util.ArrayList;

class Collision {
    private int angle;
    private ArrayList<Integer> times;
    private double lengthThread;
    private double middleTime;
    private double V10;
    private double massBall;
    private double sqrtGL;
    private double sinus;
    private double P10;

    Collision(int angle, ArrayList<Integer> times) {
        this.angle = angle;
        this.times = times;
        double anglesInRadians = Math.toRadians(angle);
        this.sinus = Math.sin(anglesInRadians / 2);
    }

    ArrayList<Integer> getTimes() {
        return times;
    }

    public double getSinus() {
        return sinus;
    }

    public double getSqrtGL() {
        return sqrtGL;
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

    public double getP10() {
        return P10;
    }

    public void setP10(double p10) {
        P10 = p10;
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
        this.sqrtGL = Math.sqrt(Constants.GRAVITATIONAL_ACCELERATION * lengthThread);
    }
}