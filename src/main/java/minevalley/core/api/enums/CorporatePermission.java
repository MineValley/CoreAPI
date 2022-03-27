package minevalley.core.api.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CorporatePermission {
    USE_CARS("use_cars"),
    CAN_BUILD("can_build"),
    CAN_USE_PHONE("can_use_phone");

    private final String key;
}
