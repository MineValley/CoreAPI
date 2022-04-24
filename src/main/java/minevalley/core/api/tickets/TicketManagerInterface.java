package minevalley.core.api.tickets;

public interface TicketManagerInterface {

    SystemTicket createSystemTicket(String text, TicketTarget target, TicketCommand... commands);
}