package minevalley.core.api.tickets;

@SuppressWarnings("unused")
public interface SystemTicket {

    void send();

    void addAnswer(String text, TicketCommand... commands);
}