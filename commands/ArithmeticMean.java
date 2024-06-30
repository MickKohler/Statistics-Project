package commands;

import model.Input;

import java.util.List;

public class ArithmeticMean implements Command{
    @Override
    public String execute(Input input, String[] commandArguments) {
        List<Double> numbers = input.takeInput();
        double sum = 0;
        for(Double d : numbers) {
            sum += d;
        }
        return String.valueOf((1/numbers.size()) * sum);
    }
}
