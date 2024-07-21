package commands;

import model.Input;

import java.util.*;

/**
 * This class handles the user input and executes the commands.
 *
 * @author Mick Kohler
 */
public class CommandHandler {
    private static final String QUIT_COMMAND = "quit";
    private static final String ARITHMETIC_MEAN_COMMAND = "arithmetic mean";
    private static final String MEAN_COMMAND = "mean";
    private static final String HARMONIC_MEAN_COMMAND = "harmonic mean";
    private static final String WEIGHTED_MEAN_COMMAND = "weighted mean";
    private static final String RANGE_COMMAND = "range";
    private static final String MEAN_ABS_DEV_COMMAND = "mean absolute deviation";
    private static final String MEAN_QUAD_DEV_COMMAND = "mean quadratic deviation";
    private static final String VARIANCE_COMMAND = "variance";
    private static final String STANDARD_DEV_COMMAND = "standard deviation";
    private static final String COEFF_OF_VARIATION_COMMAND = "coefficient of variation";
    private static final String NORMED_COEFF_OF_VARIATON_COMMAND = "normed coefficient of variation";
    private static final String QUARTILE_DISPERSION_COEFF_COMMAND = "quartile dispersion coefficient";
    private static final String GINI_COEFF_COMMAND = "Gini coefficient";
    private static final String PEARSON_CORR_COEFF_COMMAND = "Bravais Pearson correlation coefficient";
    private static final String SPEARMAN_RANK_CORR_COEFF_COMMAND = "Spearman's rank correlation coefficient";

    private static final String COMMAND_SEPARATOR_REGEX = " +";
    private static final String ARGUMENT_SEPARATOR_REGEX = ",+";

    private final Input input;
    private final Map<String, Command> commands;
    private boolean isRunning = false;

    /**
     * Constructs a new CommandHandler.
     *
     * @param input the langton board that this instance manages
     */
    public CommandHandler(Input input) {
        this.input = Objects.requireNonNull(input);
        this.commands = new HashMap<>();
        this.initCommands();
    }

    /**
     * Starts the interaction with the user.
     */
    public void handleUserInput() {
        this.isRunning = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (isRunning && scanner.hasNextLine()) {
                executeCommand(scanner.nextLine());
            }
        }
    }

    /**
     * Quits the interaction with the user.
     */
    void quit() {
        this.isRunning = false;
    }


    private void executeCommand(String commandWithArguments) {
        String[] splittedCommand = commandWithArguments.trim().split(COMMAND_SEPARATOR_REGEX);
        String commandName = splittedCommand[0];
        String[] commandArguments = splittedCommand.length == 1 ? new String[0]
                : splittedCommand[1].split(ARGUMENT_SEPARATOR_REGEX);

        executeCommand(commandName, commandArguments);
    }

    private void executeCommand(String commandName, String[] commandArguments) {
        String result = commands.get(commandName).execute(input, commandArguments);
        if (result != null) {
            System.out.println(result);
        }
    }

    private void initCommands() {
        this.addCommand(ARITHMETIC_MEAN_COMMAND, new ArithmeticMean());
        this.addCommand(MEAN_COMMAND, new Mean());
        this.addCommand(WEIGHTED_MEAN_COMMAND, new WeightedMean());
        this.addCommand(HARMONIC_MEAN_COMMAND, new HarmonicMean());
        this.addCommand(QUIT_COMMAND, new Quit(this));
    }


    /**
     * Returns the command names.
     *
     * @return the command names
     */
    public Set<String> getCommandNames() {
        return commands.keySet();
    }



    private void addCommand(String commandName, Command command) {
        this.commands.put(commandName, command);
    }
}
