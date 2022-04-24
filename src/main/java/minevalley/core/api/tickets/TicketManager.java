package minevalley.core.api.tickets;

public class TicketManager {

    private static TicketManagerInterface ticketManager;

    public TicketManager(TicketManagerInterface ticketManagerInterface) {
        ticketManager = ticketManagerInterface;
    }

    public static SystemTicket createSystemTicket(String text, TicketTarget target, TicketCommand... commands) {
        return ticketManager.createSystemTicket(text, target);
    }

    public static SystemTicket createSystemTicket(String text, TicketCommand... commands) {
        return ticketManager.createSystemTicket(text, TicketTarget.EVERYONE);
    }
}