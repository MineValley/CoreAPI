package minevalley.core.api.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import lombok.Setter;
import minevalley.core.api.commands.resolvers.BlockSelectorArgumentResolver;
import minevalley.core.api.commands.resolvers.OnlineUsersSelectorArgumentResolver;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.server.ServerType;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.enums.Fraction;
import minevalley.core.api.users.enums.TeamRank;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.GameMode;
import org.bukkit.block.BlockState;
import org.bukkit.inventory.ItemStack;

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
    public static @Nonnull ArgumentType<OnlineUser> onlineUser() {
        return manager.onlineUser();
    }

    /**
     * Gets an argument type that resolves multiple online users based on a selector.
     *
     * @return the online users selector argument type
     */
    public static @Nonnull ArgumentType<OnlineUsersSelectorArgumentResolver> onlineUsers() {
        return manager.onlineUsers();
    }

    /**
     * Gets an argument type that resolves a group.
     *
     * @return the group argument type
     */
    public static @Nonnull ArgumentType<Group> group() {
        return manager.group();
    }


    /**
     * Gets an argument type that resolves a fraction.
     *
     * @return the fraction argument type
     */
    public static @Nonnull ArgumentType<Fraction> fraction() {
        return manager.fraction();
    }

    /**
     * Gets an argument type that resolves a team rank.
     *
     * @return the team rank argument type
     */
    public static @Nonnull ArgumentType<TeamRank> teamRank() {
        return manager.teamRank();
    }

    /**
     * Gets an argument type that resolves a server type.
     *
     * @return the server type argument type
     */
    public static @Nonnull ArgumentType<ServerType> server() {
        return manager.server();
    }

    /**
     * Gets an argument type that resolves a block selector.
     *
     * @return the block selector argument type
     */
    public static @Nonnull ArgumentType<BlockSelectorArgumentResolver> block() {
        return manager.block();
    }

    /**
     * Gets an argument type that resolves a block state.
     *
     * @return the block state argument type
     */
    public static @Nonnull ArgumentType<BlockState> blockState() {
        return ArgumentTypes.blockState();
    }

    /**
     * Gets an argument type that resolves an item stack.
     *
     * @return the item stack argument type
     */
    public static @Nonnull ArgumentType<ItemStack> itemStack() {
        return ArgumentTypes.itemStack();
    }

    /**
     * Gets an argument type that resolves a named text color.
     *
     * @return the named text color argument type
     */
    public static @Nonnull ArgumentType<NamedTextColor> namedColor() {
        return ArgumentTypes.namedColor();
    }

    /**
     * Gets an argument type that resolves a component.
     *
     * @return the component argument type
     */
    public static @Nonnull ArgumentType<Component> component() {
        return ArgumentTypes.component();
    }

    /**
     * Gets an argument type that resolves a game mode.
     *
     * @return the game mode argument type
     */
    public static @Nonnull ArgumentType<GameMode> gameMode() {
        return ArgumentTypes.gameMode();
    }

    /**
     * Gets an argument type that resolves a time in ticks.
     *
     * @return the time argument type
     */
    public static @Nonnull ArgumentType<Integer> time() {
        return ArgumentTypes.time();
    }

    /**
     * Gets an argument type that resolves a time in ticks with a minimum time.
     *
     * @param minTime the minimum time in ticks
     * @return the time argument type
     */
    public static @Nonnull ArgumentType<Integer> time(final int minTime) {
        return ArgumentTypes.time(minTime);
    }

    public interface Manager {

        @Nonnull
        ArgumentType<BlockSelectorArgumentResolver> block();

        @Nonnull
        ArgumentType<Fraction> fraction();

        @Nonnull
        ArgumentType<OnlineUser> onlineUser();

        @Nonnull
        ArgumentType<OnlineUsersSelectorArgumentResolver> onlineUsers();

        @Nonnull
        ArgumentType<ServerType> server();

        @Nonnull
        ArgumentType<TeamRank> teamRank();

        @Nonnull
        ArgumentType<Group> group();
    }
}
