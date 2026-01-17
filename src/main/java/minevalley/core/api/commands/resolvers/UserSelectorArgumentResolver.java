package minevalley.core.api.commands.resolvers;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import minevalley.core.api.commands.Context;
import minevalley.core.api.users.User;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface UserSelectorArgumentResolver {

    @Nonnull
    User resolve(@Nonnull Context context) throws CommandSyntaxException;
}