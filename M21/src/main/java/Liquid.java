class Liquid {
    private double densityLiquid;

    protected Liquid(double densityLiquid) {
        this.densityLiquid = densityLiquid;
    }

    double getDensityLiquid() {
        return densityLiquid;
    }

    void setDensityLiquid(double densityLiquid) {
        this.densityLiquid = densityLiquid;
    }
}