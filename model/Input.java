package model;

import commands.CommandHandler;

import java.util.*;

public class Input {
    private static final String INVALID_INPUT_ERROR = "Invalid input: ";
    private static final String REFERENCE_POINT = "Do you need a reference point? Types 'Yes' if you need";
    private static final String WHICH_REF_POINT = "Which reference point do you want? Type in here: ";
    private static final String AMOUNT_OF_NUMBERS = "how many numbers would you like to add?";
    private static final String YOUR_NUMBER = "Your number: ";
    private static final String INTRO = "This is a statistical calculator. Type in one of the following commands to start. The following things can be calculated: %s ";
    private static final String ARGUMENT_SEPARATOR = ",";

    private CommandHandler commandHandler;
    /**
     * Handles user input from console.
     *
     * @return returns list of input Strings.
     */
    public List<Double> takeInput() {
        List<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers separated by spaces (type 'done' to finish):");

        while (scanner.hasNext()) {
            String input = scanner.next();
            if ("done".equalsIgnoreCase(input)) {
                break;
            }
            try {
                double number = Double.parseDouble(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println(INVALID_INPUT_ERROR + input);
            }
        }

        return numbers;
    }

    public void printIntroduction() {
        String commands = String.join(", ", commandHandler.getCommandNames());
        System.out.println(String.format(INTRO, commands));
    }


}

