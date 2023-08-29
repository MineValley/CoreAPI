package minevalley.core.api.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Purchase {

    private final String code;
    private final Type type;

    public enum Type {
        CAR_SKIN,
        WEAPON_SKIN,
        COSMETIC,
        RESIDENCE_SLOT,
        COMPANY_SLOT,
        SOUNDS_PACK,
        NAVIGATION_TARGET
    }
}
