package commands;

import model.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HarmonicMeanTest {
    private HarmonicMean harmonicMean;
    private Input mockInput;

    @BeforeEach
    public void setUp() {
        harmonicMean = new HarmonicMean();
    }

    @Test
    public void testHarmonicMeanSingleValue() {
        List<Double> inputValues = List.of(4.0);

        String[] commandArguments = {};
        String result = harmonicMean.execute((Input) inputValues, commandArguments);

        assertEquals("4.0", result);
    }

    @Test
    public void testHarmonicMeanMultipleValues() {
        List<Double> inputValues = Arrays.asList(1.0, 2.0, 4.0);


        String[] commandArguments = {};
        String result = harmonicMean.execute(mockInput, commandArguments);

        assertEquals("1.7142857142857142", result);
    }

    @Test
    public void testHarmonicMeanWithZero() {
        List<Double> inputValues = Arrays.asList(1.0, 0.0, 4.0);


        String[] commandArguments = {};
        String result = harmonicMean.execute(mockInput, commandArguments);

        assertEquals("Infinity", result);
    }
}
