package minevalley.core.api.tickets;

import net.md_5.bungee.api.chat.BaseComponent;

public interface SystemTicket {

    void send();

    void addAnswer(BaseComponent[] baseComponents);
}