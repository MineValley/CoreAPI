package minevalley.core.api.tickets;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TicketTarget {

    ADMINISTRATION(10),
    DEVELOPMENT(9),
    MODERATION(6),
    SUPPORT(5),
    BUILDING(1),
    EVERYONE(0);

    private final int id;
}