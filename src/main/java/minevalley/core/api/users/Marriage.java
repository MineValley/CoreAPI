package minevalley.core.api.users;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.Set;

@SuppressWarnings("unused")
public interface Marriage {

    @Nonnull
    @Contract(pure = true)
    Set<User> getUsers();

    void add(@Nonnull User user) throws IllegalArgumentException, IllegalStateException;

    void leave(@Nonnull User user) throws IllegalArgumentException, IllegalStateException;

    @Contract(pure = true)
    long since();
}
