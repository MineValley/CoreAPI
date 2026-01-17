package minevalley.core.api.users;

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
     * Adds a user to this marriage.
     *
     * @param user user to be added
     * @throws IllegalArgumentException if the user is null or already part of this marriage
     */
    void add(@Nonnull User user) throws IllegalArgumentException;

    /**
     * Removes a user from this marriage.
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
