package minevalley.core.api.commands.resolvers;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import minevalley.core.api.commands.Context;
import minevalley.core.api.users.OnlineUser;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface OnlineUsersSelectorArgumentResolver {

    @Nonnull
    List<OnlineUser> resolve(@Nonnull Context context) throws CommandSyntaxException;
}