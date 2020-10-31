class Vessel {
    //расстояние между рисками K1 и K2
    private double distanceK1K2;
    private double radiusVessel;

    protected Vessel(double distanceK1K2, double radiusVessel){
        this.distanceK1K2 = distanceK1K2;
        this.radiusVessel = radiusVessel;
    }

    protected double getDistanceK1K2() {
        return distanceK1K2;
    }

    protected double getRadiusVessel() {
        return radiusVessel;
    }

    protected void setDistanceK1K2(double distanceK1K2) {
        this.distanceK1K2 = distanceK1K2;
    }

    protected void setRadiusVessel(double radiusVessel) {
        this.radiusVessel = radiusVessel;
    }
}
