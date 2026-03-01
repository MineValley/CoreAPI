package minevalley.core.api.command.resolver;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import minevalley.core.api.command.Context;
import minevalley.core.api.user.User;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface UserSelectorArgumentResolver {

    @Nonnull
    User resolve(@Nonnull Context context) throws CommandSyntaxException;
}