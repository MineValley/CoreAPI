package minevalley.core.api.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import lombok.Setter;
import minevalley.core.api.commands.resolvers.BlockSelectorArgumentResolver;
import minevalley.core.api.commands.resolvers.OnlineUsersSelectorArgumentResolver;
import minevalley.core.api.commands.resolvers.UserSelectorArgumentResolver;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.server.ServerType;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.User;
import minevalley.core.api.users.enums.Fraction;
import minevalley.core.api.users.enums.TeamRank;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.GameMode;
import org.bukkit.block.BlockState;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings({"unused", "UnstableApiUsage"})
public final class CustomArgumentTypes {

    @Setter
    private static Manager manager;

    /**
     * Gets an argument type that resolves a single online user.
     *
     * @return the online user argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<OnlineUser> onlineUser() {
        return manager.onlineUser();
    }

    /**
     * Gets an argument type that resolves multiple online users based on a selector.
     *
     * @return the online users selector argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<OnlineUsersSelectorArgumentResolver> onlineUsers() {
        return manager.onlineUsers();
    }

    /**
     * Gets an argument type that resolves a single user based on a selector.
     *
     * @return the user selector argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<UserSelectorArgumentResolver> user() {
        return manager.user();
    }

    /**
     * Gets an argument type that resolves a group.
     *
     * @return the group argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<Group> group() {
        return manager.group();
    }

    /**
     * Gets an argument type that resolves a fraction.
     *
     * @return the fraction argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<Fraction> fraction() {
        return manager.fraction();
    }

    /**
     * Gets an argument type that resolves a team rank.
     *
     * @return the team rank argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<TeamRank> teamRank() {
        return manager.teamRank();
    }

    /**
     * Gets an argument type that resolves a server type.
     *
     * @return the server type argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<ServerType> server() {
        return manager.server();
    }

    /**
     * Gets an argument type that resolves a block selector.
     *
     * @return the block selector argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<BlockSelectorArgumentResolver> block() {
        return manager.block();
    }

    /**
     * Gets an argument type that resolves a block state.
     *
     * @return the block state argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<BlockState> blockState() {
        return ArgumentTypes.blockState();
    }

    /**
     * Gets an argument type that resolves an item stack.
     *
     * @return the item stack argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<ItemStack> itemStack() {
        return ArgumentTypes.itemStack();
    }

    /**
     * Gets an argument type that resolves a named text color.
     *
     * @return the named text color argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<NamedTextColor> namedColor() {
        return ArgumentTypes.namedColor();
    }

    /**
     * Gets an argument type that resolves a component.
     *
     * @return the component argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<Component> component() {
        return ArgumentTypes.component();
    }

    /**
     * Gets an argument type that resolves a game mode.
     *
     * @return the game mode argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<GameMode> gameMode() {
        return ArgumentTypes.gameMode();
    }

    /**
     * Gets an argument type that resolves a time in ticks.
     *
     * @return the time argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<Integer> time() {
        return ArgumentTypes.time();
    }

    /**
     * Gets an argument type that resolves a time in ticks with a minimum time.
     *
     * @param minTime the minimum time in ticks
     * @return the time argument type
     */
    @Nonnull
    @Contract(pure = true)
    public static ArgumentType<Integer> time(final int minTime) {
        return ArgumentTypes.time(minTime);
    }

    public interface Manager {

        @Nonnull
        @Contract(pure = true)
        ArgumentType<BlockSelectorArgumentResolver> block();

        @Nonnull
        @Contract(pure = true)
        ArgumentType<Fraction> fraction();

        @Nonnull
        @Contract(pure = true)
        ArgumentType<OnlineUser> onlineUser();

        @Nonnull
        @Contract(pure = true)
        ArgumentType<OnlineUsersSelectorArgumentResolver> onlineUsers();

        @Nonnull
        @Contract(pure = true)
        ArgumentType<UserSelectorArgumentResolver> user();

        @Nonnull
        @Contract(pure = true)
        ArgumentType<ServerType> server();

        @Nonnull
        @Contract(pure = true)
        ArgumentType<TeamRank> teamRank();

        @Nonnull
        @Contract(pure = true)
        ArgumentType<Group> group();
    }
}
