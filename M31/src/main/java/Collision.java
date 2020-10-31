import java.util.ArrayList;
import java.util.Arrays;

class Collision {
    private int angle;
    private ArrayList<Integer> times;
    private double lengthThread;
    private double middleTime;
    private double V10;
    private double massBall;

    public Collision(int angle, ArrayList<Integer> times){
        this.angle = angle;
        this.times = times;
    }

    public ArrayList<Integer> getTimes() {
        return times;
    }

    public int getAngle() {
        return angle;
    }

    public double getMiddleTime() {
        return middleTime;
    }

    public void setMiddleTime(double middleTime) {
        this.middleTime = middleTime;
    }

    public double getMassBall() {
        return massBall;
    }

    public void setMassBall(double massBall) {
        this.massBall = massBall;
    }

    public double getV10() {
        return V10;
    }

    public void setV10(double v10) {
        V10 = v10;
    }

    public void setTimes(ArrayList<Integer> times) {
        this.times = times;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public double getLengthThread() {
        return lengthThread;
    }

    public void setLengthThread(double lengthThread) {
        this.lengthThread = lengthThread;
    }

    protected static ArrayList<Collision> getTimeCollisionFromCsv(){
        ArrayList<Collision> listCollision = new ArrayList<>();
        ArrayList<String> listTimeCollisionFromCsv = CsvReader.reader("/Users/kristina/work/Lab/M31/src/main/resources/timeCollision.csv");
        for (String i: listTimeCollisionFromCsv){
            ArrayList<String> fromCsv = new ArrayList<>(Arrays.asList((i.split(","))));
            Integer angle = Integer.parseInt(fromCsv.get(0));
            fromCsv.remove(0);
            ArrayList<Integer> times = new ArrayList<>();
            fromCsv.forEach((it) -> times.add(Integer.parseInt(it)));
            listCollision.add(new Collision(angle, times));
        }
        return listCollision;
    }

    protected static void calculateV10P10(Collision collision){
        System.out.println("Измерения для соударения под углом "+ collision.getAngle());
        System.out.println("Среднее время соударения "+ collision.getMiddleTime());
        System.out.println("Длина нити "+ collision.getLengthThread());
        double anglesInRadians = Math.toRadians(collision.getAngle());
        double sqrtGL = Math.sqrt(Constants.GRAVITATIONAL_ACCELERATION*collision.getLengthThread());
        double sinus = Math.sin(anglesInRadians/2);
        double V10 = 2*sqrtGL*sinus;
        System.out.println("Скорость V10 "+V10);
        collision.setV10(V10);
        double P10 = 2* collision.massBall*sqrtGL*sinus;
        System.out.println("Импульс Р10 "+ P10);
        double E10 = (collision.massBall*(V10*V10))/2;
        System.out.println("Энергия Е10 "+ E10);
        System.out.println("");
        double F10 = P10/ (collision.getMiddleTime()*Math.pow(10, -4));
        System.out.println("Модуль средней силы F10 "+F10);
    }



}
