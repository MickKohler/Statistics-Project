package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Methods {


    public double arithmeticMean(List<Double> input) {
        double sum = 0;
        for (Double i : input) {
            sum += i;
        }
        double mean = (double) sum / input.size();

        BigDecimal bd = new BigDecimal(mean);
        bd = bd.setScale(6, RoundingMode.CEILING); // Setting the scale to 6 digits and using CEILING rounding mode
        return bd.doubleValue();
    }

    public double meanSquareDeviation(List<Double> input, double referencePoint) {
        double sum = 0;

        for (Double d : input) {
            sum += Math.sqrt(d - referencePoint);
        }
        return ((double) 1 /input.size()) * sum;
    }


}
