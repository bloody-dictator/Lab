class Ball {
    //радиус r шарика
    private double radius;
    //плотность шарика ро греческая
    private double density;

    //время движения шарика
    private double time;

    protected Ball(){}
    protected Ball(double radius, double density, double time){
        this.time = time;
        this.radius = radius;
        this.density = density;
    }

    protected double getDensity() {
        return density;
    }

    protected double getRadius() {
        return radius;
    }

    protected double getTime() {
        return time;
    }

    protected void setDensity(double density) {
        this.density = density;
    }

    protected void setRadius(double radius) {
        this.radius = radius;
    }

    protected void setTime(double time) {
        this.time = time;
    }
}
