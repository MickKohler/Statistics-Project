package commands;

import model.Input;

public interface Command {

    String execute(Input input, String[] commandArguments);


}
