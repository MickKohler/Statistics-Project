package commands;

import model.Input;

public class Quit implements Command{
    private final CommandHandler commandHandler;

    public Quit(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public String execute(Input input, String[] commandArguments) {
        commandHandler.quit();
        return null;
    }
}
