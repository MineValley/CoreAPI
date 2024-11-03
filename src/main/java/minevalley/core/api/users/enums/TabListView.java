package minevalley.core.api.users.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TabListView {

    DEFAULT(0),
    DISPOSAL(1),
    MAIL(2),
    MEDIC(3),
    POLICE(4),
    TEAM(5),
    SUPPORT(6);

    /**
     * Identification-number of the tab-list view
     */
    private final int value;

    public static TabListView getTabListView(int value) {
        return Arrays.stream(values()).filter(fraction -> fraction.getValue() == value).findFirst().orElse(null);
    }
}
