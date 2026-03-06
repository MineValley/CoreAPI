package minevalley.core.api.user.social;

import minevalley.core.api.user.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.Set;

@SuppressWarnings("unused")
public interface Marriage {

    /**
     * Gets all users part of this marriage.
     *
     * @return set of users
     */
    @Nonnull
    @Contract(pure = true)
    Set<User> getUsers();

    /**
     * Removes a user from this marriage.
     * <p>
     * <b>Note:</b> If the marriage has only two users,
     * the marriage will be dissolved and the remaining user will be left without a partner.
     * </p>
     *
     * @param user user to be removed
     * @throws IllegalArgumentException if the user is null or not part of this marriage
     */
    void leave(@Nonnull User user) throws IllegalArgumentException;

    /**
     * Gets the timestamp (in milliseconds since epoch) when this marriage was created.
     *
     * @return timestamp when the marriage was created
     */
    @Contract(pure = true)
    long since();
}
