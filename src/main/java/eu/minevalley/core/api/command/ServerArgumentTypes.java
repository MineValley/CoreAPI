package eu.minevalley.core.api.command;

import com.mojang.brigadier.arguments.ArgumentType;
import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.proxima.api.command.ArgumentTypes;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.Set;

@SuppressWarnings("unused")
public interface ServerArgumentTypes extends ArgumentTypes {

    /**
     * Gets an argument type that resolves a single online user.
     *
     * @return the online user argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<OnlineUser> onlineUser();

    /**
     * Gets an argument type that resolves multiple online users based on a selector.
     *
     * @return the online users selector argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<Set<OnlineUser>> onlineUsersSet();
}
