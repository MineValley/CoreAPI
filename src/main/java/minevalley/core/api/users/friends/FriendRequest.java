package minevalley.core.api.users.friends;

import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface FriendRequest {

    @Nonnull
    @Contract(pure = true)
    User getSender();

    @Nonnull
    @Contract(pure = true)
    User getTarget();

    @Contract(pure = true)
    long getSendingTimestamp();

    void accept();

    void reject();
}