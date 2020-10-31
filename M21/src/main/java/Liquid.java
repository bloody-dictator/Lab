class Liquid {
    private double densityLiquid;

    protected Liquid(double densityLiquid){
        this.densityLiquid = densityLiquid;
    }

    protected double getDensityLiquid() {
        return densityLiquid;
    }

    protected void setDensityLiquid(double densityLiquid) {
        this.densityLiquid = densityLiquid;
    }
}
