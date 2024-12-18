package minevalley.core.api.users;

public record Purchase(String code, Type type) {

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
