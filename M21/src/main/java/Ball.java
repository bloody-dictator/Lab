class Ball {
    //радиус r шарика
    private double radius;
    //плотность шарика ро греческая
    private double density;

    //время движения шарика
    private double time;

    Ball() {
    }

    Ball(double radius, double density, double time) {
        this.time = time;
        this.radius = radius;
        this.density = density;
    }

    double getDensity() {
        return density;
    }

    double getRadius() {
        return radius;
    }

    double getTime() {
        return time;
    }

    void setDensity(double density) {
        this.density = density;
    }

    void setRadius(double radius) {
        this.radius = radius;
    }

    void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Ball[ time: "+ time+"; radius: "+radius+"; density: "+density;
    }
}