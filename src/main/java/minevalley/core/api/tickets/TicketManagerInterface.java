package minevalley.core.api.tickets;

import net.md_5.bungee.api.chat.BaseComponent;

interface TicketManagerInterface {

    SystemTicket createSystemTicket(BaseComponent[] baseComponents, TicketTarget target);
}