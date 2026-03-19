package minevalley.core.api.user.social;

import minevalley.core.api.user.User;
import org.bukkit.Location;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.Date;

@SuppressWarnings("unused")
public interface FriendRequest {

    /**
     * Gets the user who sent the friend request.
     *
     * @return the sender of the friend request
     */
    @Nonnull
    @Contract(pure = true)
    User getSender();

    /**
     * Gets the user who is the target of the friend request.
     *
     * @return the target of the friend request
     */
    @Nonnull
    @Contract(pure = true)
    User getTarget();

    /**
     * Gets the date (including time) when the friend request was sent.
     *
     * @return the sending timestamp
     */
    @Nonnull
    @Contract(pure = true)
    Date getSendingTimestamp();

    /**
     * Gets the location where the sending user was standing when sending the request.
     *
     * @return the location where this friend request was sent
     */
    @Nonnull
    @Contract(pure = true)
    Location getLocation();

    /**
     * Accepts the friend request, establishing a friendship between the sender and the target.
     */
    void accept();

    /**
     * Rejects the friend request, declining the friendship offer.
     */
    void reject();
}