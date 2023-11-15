package minevalley.core.api.utils.armorstand.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ArmorStandMetaData {

    IS_SMALL(0x01),
    HAS_ARMS(0x04),
    HAS_BASE_PLATE(0x08),
    IS_MARKER(0x10);

    private final int masking;
}
