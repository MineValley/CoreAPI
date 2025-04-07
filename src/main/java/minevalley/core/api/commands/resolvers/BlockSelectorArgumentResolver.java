package minevalley.core.api.commands.resolvers;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import minevalley.core.api.commands.Context;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface BlockSelectorArgumentResolver {

    @Nonnull
    Block resolve(@Nonnull Context context) throws CommandSyntaxException;
}