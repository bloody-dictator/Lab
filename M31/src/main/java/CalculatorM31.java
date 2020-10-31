class CalculatorM31 {
    protected static void calculateV10P10(Collision collision) {
        System.out.println("\nИзмерения для соударения под углом " + collision.getAngle());
        System.out.println("Среднее время соударения " + collision.getMiddleTime());
        System.out.println("Длина нити " + collision.getLengthThread());
        double anglesInRadians = Math.toRadians(collision.getAngle());
        double sqrtGL = Math.sqrt(Constants.GRAVITATIONAL_ACCELERATION * collision.getLengthThread());
        double sinus = Math.sin(anglesInRadians / 2);
        double V10 = 2 * sqrtGL * sinus;
        System.out.println("Скорость V10 " + V10);
        collision.setV10(V10);
        double P10 = 2 * collision.getMassBall() * sqrtGL * sinus;
        System.out.println("Импульс Р10 " + P10);
        double E10 = (collision.getMassBall() * (V10 * V10)) / 2;
        System.out.println("Энергия Е10 " + E10);
        double F10 = P10 / (collision.getMiddleTime() * Math.pow(10, -4));
        System.out.println("Модуль средней силы F10 " + F10);
    }
}