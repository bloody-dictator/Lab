public class Vessel {
    //расстояние между рисками K1 и K2
    private double distanceK1K2;
    private double radiusVessel;

    public Vessel(double distanceK1K2, double radiusVessel){
        this.distanceK1K2 = distanceK1K2;
        this.radiusVessel = radiusVessel;
    }

    public double getDistanceK1K2() {
        return distanceK1K2;
    }

    public double getRadiusVessel() {
        return radiusVessel;
    }

    public void setDistanceK1K2(double distanceK1K2) {
        this.distanceK1K2 = distanceK1K2;
    }

    public void setRadiusVessel(double radiusVessel) {
        this.radiusVessel = radiusVessel;
    }
}
