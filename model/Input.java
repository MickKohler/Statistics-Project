package model;

import commands.CommandHandler;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String INVALID_INPUT_ERROR = "Invalid input: ";
    private static final String REFERENCE_POINT = "Do you need a reference point? Types 'Yes' if you need";
    private static final String WHICH_REF_POINT = "Which reference point do you want? Type in here: ";
    private static final String AMOUNT_OF_NUMBERS = "how many numbers would you like to add?";
    private static final String YOUR_NUMBER = "Your number: ";
    private static final String INTRO = "This is a statistical calculator. Type in one of the following commands to start. The following things can be calculated: %s ";

    private final CommandHandler commandHandler;


    /**
     * Instantiates input.
     * 
     * @param commandHandler from CommandHandler class.
     */
    public Input(CommandHandler commandHandler, CommandHandler commandHandler1) { // TODO possibly adding commandHandler to constructor
        this.commandHandler = commandHandler;
    }

    /**
     * Handles user input from console.
     *
     * @return returns list of input Strings.
     */
    public List<Double> takeInput() {
        String inputString = null;

        try (Scanner scanner = new Scanner(System.in)) {
            inputString = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.err.println(INVALID_INPUT_ERROR + inputString);
        }
        
        List<Double> input = new ArrayList<>();

        String commands = String.join(System.lineSeparator(), commandHandler.getCommandNames());
        System.out.println(String.format(INTRO,commands));


        return input;
        
    }

}

