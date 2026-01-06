package minevalley.core.api.users.friends;

import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Friendship {

    /**
     * Gets the first friend in this friendship.
     *
     * @return the first friend
     */
    @Nonnull
    @Contract(pure = true)
    User getFriend1();

    /**
     * Gets the second friend in this friendship.
     *
     * @return the second friend
     */
    @Nonnull
    @Contract(pure = true)
    User getFriend2();

    /**
     * Gets the timestamp (in milliseconds since epoch) of when this friendship was created.
     *
     * @return the timestamp of when this friendship was created
     */
    @Contract(pure = true)
    long since();

    /**
     * Ends this friendship.
     */
    void exit();
}
