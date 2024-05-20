package org.scaler.splitwisemay.commands;

import org.scaler.splitwisemay.controller.SettleUpController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    List<command> commands;

    public CommandExecutor(){
        commands = new ArrayList<>();
        commands.add(new SettleUpUserCommand(new SettleUpController()));
    }

    public void addCommands(command command) {
        commands.add(command);
    }

    public void removeCommands(command command) {
        commands.remove(command);
    }

    public void execute(String input){
        for(command c: commands){
            if(c.matches(input)){
                c.execute(input);
                return;
            }
        }

        throw new RuntimeException("Command not found..");
    }
}
