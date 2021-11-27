import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class M21UnitTests {
    @Test
    void calculateDynamicViscosityNegativeTest(){
        Vessel testVessel = new Vessel(0.0, 1.0);
        Liquid liquid = new Liquid(1260.0);
        Ball ball = new Ball(0.1, 11300.0,1.00);
        CalculatorM21 calculatorM21 = new CalculatorM21();
        Assertions.assertEquals(0.0, calculatorM21.calculateDynamicViscosity(ball, liquid, testVessel));
    }
    @Test
    void calculateDynamicViscosityPositiveTest(){
        Vessel testVessel = new Vessel(1.0, 1.0);
        Liquid liquid = new Liquid(1260.0);
        Ball ball = new Ball(0.1, 11300.0,1.00);
        CalculatorM21 calculatorM21 = new CalculatorM21();
        double value = calculatorM21.calculateDynamicViscosity(ball, liquid, testVessel);
        System.out.println(value);
        BigDecimal result = new BigDecimal(value);
        result = result.setScale(3, RoundingMode.DOWN);
        Assertions.assertEquals(new BigDecimal("218.872"), result);
    }

    @Test
    void calculateCoefficientKNegativeTest(){
        List<Ball> balls = List.of(new Ball(0.0, 11300.0,1.00));
        Vessel testVessel = new Vessel(1.0, 0.0);
        CalculatorM21 calculatorM21 = new CalculatorM21();
        Assertions.assertNull(calculatorM21.calculateCoefficientK(balls, testVessel));
    }

    @Test
    void calculateCoefficientKPositiveTest(){
        List<Ball> balls = List.of(new Ball(0.1, 11300.0,1.00));
        Vessel testVessel = new Vessel(1.0, 1.0);
        CalculatorM21 calculatorM21 = new CalculatorM21();
        List<Double> values = calculatorM21.calculateCoefficientK(balls, testVessel);
        for (Double value : values) {
            BigDecimal result  = new BigDecimal(value).setScale(3, RoundingMode.DOWN);
            Assertions.assertEquals(new BigDecimal("0.806"), result);
        }
    }

}
