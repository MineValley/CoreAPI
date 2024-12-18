package minevalley.core.api.enums;

@SuppressWarnings("unused")
public enum InteractionType {

    LEFT_CLICK,
    SHIFT_LEFT_CLICK,
    RIGHT_CLICK,
    SHIFT_RIGHT_CLICK;

    public boolean isLeftClick() {
        return this == LEFT_CLICK || this == SHIFT_LEFT_CLICK;
    }

    public boolean isRightClick() {
        return this == RIGHT_CLICK || this == SHIFT_RIGHT_CLICK;
    }

    public boolean isShiftClick() {
        return this == SHIFT_LEFT_CLICK || this == SHIFT_RIGHT_CLICK;
    }
}
