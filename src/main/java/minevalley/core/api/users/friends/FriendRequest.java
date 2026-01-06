package minevalley.core.api.users.friends;

import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

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
     * Gets the timestamp when the friend request was sent.
     *
     * @return the sending timestamp in milliseconds since epoch
     */
    @Contract(pure = true)
    long getSendingTimestamp();

    /**
     * Accepts the friend request, establishing a friendship between the sender and the target.
     */
    void accept();

    /**
     * Rejects the friend request, declining the friendship offer.
     */
    void reject();
}