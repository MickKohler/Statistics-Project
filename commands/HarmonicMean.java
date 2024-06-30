package commands;

import model.Input;

import java.util.List;

/**
 * Calculates the harmonic mean based on input.
 *
 * @author Mick Kohler
 */
public class HarmonicMean implements Command {

    @Override
    public String execute(Input input, String[] commandArguments) {
        List<Double> numbers = input.takeInput();
        double result = 0;

        for (Double d : numbers) {
            result += 1/d;
        }
        return String.valueOf(numbers.size() / result);
    }
}
