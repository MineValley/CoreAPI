package minevalley.core.api.tickets;

import net.md_5.bungee.api.chat.BaseComponent;

public class TicketManager {

    private static TicketManagerInterface ticketManager;

    public TicketManager(TicketManagerInterface ticketManagerInterface) {
        ticketManager = ticketManagerInterface;
    }

    public static SystemTicket createSystemTicket(BaseComponent[] baseComponents, TicketTarget target) {
        return ticketManager.createSystemTicket(baseComponents, target);
    }

    public static SystemTicket createSystemTicket(BaseComponent[] baseComponents) {
        return ticketManager.createSystemTicket(baseComponents, TicketTarget.EVERYONE);
    }
}