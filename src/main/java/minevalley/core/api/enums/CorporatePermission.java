package minevalley.core.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CorporatePermission {
    USE_CARS("use_cars"),
    CAN_BUILD("can_build"),
    CAN_USE_PHONE("can_use_phone");

    private final String key;
}
