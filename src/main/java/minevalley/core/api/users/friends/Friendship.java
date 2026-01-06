package minevalley.core.api.users.friends;

import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Friendship {

    @Nonnull
    @Contract(pure = true)
    User getFriend1();

    @Nonnull
    @Contract(pure = true)
    User getFriend2();

    @Contract(pure = true)
    long since();

    void exit();
}
