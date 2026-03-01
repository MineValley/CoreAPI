package minevalley.core.api.command.resolvers;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import minevalley.core.api.command.Context;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface BlockSelectorArgumentResolver {

    @Nonnull
    Block resolve(@Nonnull Context context) throws CommandSyntaxException;
}