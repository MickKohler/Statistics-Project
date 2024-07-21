import commands.CommandHandler;
import model.Input;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.takeInput();
        CommandHandler commandHandler = new CommandHandler(input);


        commandHandler.handleUserInput();
        
    }
}
