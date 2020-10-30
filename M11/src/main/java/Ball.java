public class Ball {
    //радиус r шарика
    private double radius;
    //плотность шарика ро греческая
    private double density;

    //время движения шарика
    private double time;

    public Ball(){}
    public Ball(double radius, double density, double time){
        this.time = time;
        this.radius = radius;
        this.density = density;
    }

    public double getDensity() {
        return density;
    }

    public double getRadius() {
        return radius;
    }

    public double getTime() {
        return time;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
