package eu.minevalley.core.api.user.team;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TeamRank {

    /**
     * Members of the "Test-Support"-group.
     */
    T_SUPPORT(true),

    /**
     * Members of the "Support"-group.
     */
    SUPPORT(true),

    /**
     * Members of the "Moderation"-group.
     */
    MODERATION(true),

    /**
     * Members of the "Sonstiges"-group.
     */
    MISCELLANEOUS(false),

    /**
     * Members of the "Bauteam"-group.
     */
    BUILDING(false),

    /**
     * Members of the "Entwicklung"-group.
     */
    DEVELOPMENT(false),

    /**
     * Members of the "Administration"-group.
     */
    ADMINISTRATION(true),

    /**
     * Members of the "Serverleitung"-group.
     */
    SERVER_LEAD(true);

    /**
     * Boolean that says whether the teamler is in support-service by default when joining the server.
     */
    private final boolean supportOnJoin;
}