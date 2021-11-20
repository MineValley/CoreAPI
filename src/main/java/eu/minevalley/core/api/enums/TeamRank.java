package eu.minevalley.core.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TeamRank {

    NONE(0, false),
    MISCELLANEOUS(10, false),
    BUILDING(11, false),
    T_SUPPORT(1, true),
    SUPPORT(2, true),
    MODERATION(11, true),
    DEVELOPMENT(20, false),
    ADMINISTRATION(30, true),
    SERVER_LEAD(100, true);

    private final int value;

    private final boolean supportOnJoin;

    public static TeamRank getRank(int value) {
        for (TeamRank teamRank : values())
            if (teamRank.getValue() == value)
                return teamRank;
            return null;
    }
}