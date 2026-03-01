package minevalley.core.api.packet.modifiers;

import minevalley.core.api.users.OnlineUser;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;

@SuppressWarnings("unused")
public interface InteractionModifier<T extends InteractionModifier<T>> {

    /**
     * Defines the action when a user interacts with this object.
     *
     * @param consumer is called whenever a user interacts with this object
     * @return this
     */
    T onClick(@Nullable BiConsumer<OnlineUser, InteractionType> consumer);

    @SuppressWarnings("unused")
    enum InteractionType {

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
}
