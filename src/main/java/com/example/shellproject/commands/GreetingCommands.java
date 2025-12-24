package com.example.shellproject.commands;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
@Command(group = "greet")
public class GreetingCommands {

    @Command(command = "greet", description = "Greet someone")
    public String greet(@Option(longNames = "name", shortNames = 'n', description = "Name of the person to greet") String name) {
        return "Hello " + name;
    }
}
