package commands;

import model.Input;

import java.util.Collections;
import java.util.List;

public class Range implements Command{
    @Override
    public String execute(Input input, String[] commandArguments) {
        List<Double> numbers = input.takeInput();
        double max = Collections.max(numbers);
        double min = Collections.min(numbers);

        return String.valueOf(max-min);
    }
}
