package org.scaler.splitwisemay.commands;

public interface command {

    public boolean matches(String input);
    public void execute(String input);
}
