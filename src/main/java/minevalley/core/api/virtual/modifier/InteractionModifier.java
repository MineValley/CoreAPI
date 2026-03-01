package minevalley.core.api.virtual.modifier;

import minevalley.core.api.registrant.OnlineUser;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
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
    @Nonnull
    @Contract("_ -> this")
    T onClick(@Nullable BiConsumer<OnlineUser, InteractionType> consumer);

    @SuppressWarnings("unused")
    enum InteractionType {

        LEFT_CLICK,
        SHIFT_LEFT_CLICK,
        RIGHT_CLICK,
        SHIFT_RIGHT_CLICK;

        /**
         * Checks if the interaction type is a left click.
         *
         * @return true if the interaction type is a left click, false otherwise.
         */
        @Contract(pure = true)
        public boolean isLeftClick() {
            return this == LEFT_CLICK || this == SHIFT_LEFT_CLICK;
        }

        /**
         * Checks if the interaction type is a right click.
         *
         * @return true if the interaction type is a right click, false otherwise.
         */
        @Contract(pure = true)
        public boolean isRightClick() {
            return this == RIGHT_CLICK || this == SHIFT_RIGHT_CLICK;
        }

        /**
         * Checks if the interaction type is a shift click.
         *
         * @return true if the interaction type is a shift click, false otherwise.
         */
        @Contract(pure = true)
        public boolean isShiftClick() {
            return this == SHIFT_LEFT_CLICK || this == SHIFT_RIGHT_CLICK;
        }
    }
}
