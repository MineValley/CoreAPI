package minevalley.core.api.tickets;

public interface SystemTicket {

    void send();

    void addAnswer(String text, TicketCommand... commands);
}