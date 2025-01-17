package minevalley.core.api.tickets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.md_5.bungee.api.ChatColor;

@Getter
@AllArgsConstructor
public class TicketCommand {

    private final String name, command;
    private final ChatColor color;
}