package minevalley.core.api.users.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TabListView {

    DEFAULT,
    DISPOSAL,
    MAIL,
    MEDIC,
    POLICE,
    TEAM,
    SUPPORT
}
