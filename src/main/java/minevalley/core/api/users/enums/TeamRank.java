package minevalley.core.api.users.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TeamRank {

    /**
     * Users without any team-rank (or team members who aren't in team service).
     */
    NONE(0, false),

    /**
     * Members of the "Test-Support"-group.
     */
    T_SUPPORT(1, true),

    /**
     * Members of the "Support"-group.
     */
    SUPPORT(2, true),

    /**
     * Members of the "Moderation"-group.
     */
    MODERATION(3, true),

    /**
     * Members of the "Sonstiges"-group.
     */
    MISCELLANEOUS(10, false),

    /**
     * Members of the "Bauteam"-group.
     */
    BUILDING(11, false),

    /**
     * Members of the "Entwicklung"-group.
     */
    DEVELOPMENT(20, false),

    /**
     * Members of the "Administration"-group.
     */
    ADMINISTRATION(30, true),

    /**
     * Members of the "Serverleitung"-group.
     */
    SERVER_LEAD(100, true);

    /**
     * Identification-number of the rank, that is saved in the database.
     */
    private final int value;

    /**
     * Boolean that says whether the teamler is in support-service by default when joining the server.
     */
    private final boolean supportOnJoin;

    /**
     * Gets the rank by giving the identification-number of the rank.
     *
     * @param value identification-number of the searched rank
     * @return the matching team-rank
     */
    public static TeamRank getRank(int value) {
        return Arrays.stream(values()).filter(teamRank -> teamRank.getValue() == value).findFirst().orElse(null);
    }
}