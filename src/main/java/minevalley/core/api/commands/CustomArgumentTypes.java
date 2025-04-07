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

    public static @Nonnull ArgumentType<OnlineUser> onlineUser() {
        return manager.onlineUser();
    }

    public static @Nonnull ArgumentType<OnlineUsersSelectorArgumentResolver> onlineUsers() {
        return manager.onlineUsers();
    }

    public static @Nonnull ArgumentType<Group> group() {
        return manager.group();
    }

    public static @Nonnull ArgumentType<Fraction> fraction() {
        return manager.fraction();
    }

    public static @Nonnull ArgumentType<TeamRank> teamRank() {
        return manager.teamRank();
    }

    public static @Nonnull ArgumentType<ServerType> server() {
        return manager.server();
    }

    public static @Nonnull ArgumentType<BlockSelectorArgumentResolver> block() {
        return manager.block();
    }

    public static @Nonnull ArgumentType<BlockState> blockState() {
        return ArgumentTypes.blockState();
    }

    public static @Nonnull ArgumentType<ItemStack> itemStack() {
        return ArgumentTypes.itemStack();
    }

    public static @Nonnull ArgumentType<NamedTextColor> namedColor() {
        return ArgumentTypes.namedColor();
    }

    public static @Nonnull ArgumentType<Component> component() {
        return ArgumentTypes.component();
    }

    public static @Nonnull ArgumentType<GameMode> gameMode() {
        return ArgumentTypes.gameMode();
    }

    public static @Nonnull ArgumentType<Integer> time() {
        return ArgumentTypes.time();
    }

    public static @Nonnull ArgumentType<Integer> time(final int minTime) {
        return ArgumentTypes.time(minTime);
    }

    private interface Manager {

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
