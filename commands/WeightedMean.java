package commands;

import model.Input;

import java.util.List;

public class WeightedMean implements Command{
    @Override
    public String execute(Input input, String[] commandArguments) {
        List<Double> numbers = input.takeInput();
        double result = 0;
        double weightedFactor = 0;

        for (Double d : numbers) {
            result += 1/d * weightedFactor;
        }
        return String.valueOf(numbers.size() / result);
    }
}
