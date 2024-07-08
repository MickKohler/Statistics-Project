import commands.CommandHandler;
import model.Input;
import model.Methods;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        CommandHandler commandHandler = new CommandHandler(input);

        List<Double> numbers = input.takeInput();
        // System.out.println(input.takeInput());

        Methods methods = new Methods();
        System.out.println(methods.arithmeticMean(numbers));
    }
}
