package minevalley.core.api.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A command literal is a string that represents a (sub-) command.
 * It can be used to create the root command or any sub-command.
 */
@Getter
@AllArgsConstructor
public abstract class CommandLiteral implements CommandBuilder {

    private final String literal;
}