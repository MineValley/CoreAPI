package minevalley.core.api.modifiers;

import minevalley.core.api.enums.InteractionType;
import minevalley.core.api.users.OnlineUser;

import javax.annotation.Nullable;
import java.util.function.BiConsumer;

@SuppressWarnings("unused")
public interface InteractionModifier {

    /**
     * Defines the action when a user interacts with this object.
     *
     * @param consumer is called whenever a user interacts with this object
     */
    void onClick(@Nullable BiConsumer<OnlineUser, InteractionType> consumer);
}
