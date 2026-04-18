package eu.minevalley.core.api.user.social;

import eu.minevalley.core.api.user.User;
import org.bukkit.Location;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.Date;

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
     * Gets the date (with time!) of when this friendship was created.
     *
     * @return the date of when this friendship was created
     */
    @Nonnull
    @Contract(pure = true)
    Date since();

    /**
     * Gets the location where this friendship was created.
     *
     * @return the location where this friendship was created
     */
    @Nonnull
    @Contract(pure = true)
    Location where();

    /**
     * Ends this friendship.
     */
    void exit();
}
