package minevalley.core.api.command.resolver;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import minevalley.core.api.command.Context;
import minevalley.core.api.registrant.OnlineUser;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface OnlineUsersSelectorArgumentResolver {

    @Nonnull
    List<OnlineUser> resolve(@Nonnull Context context) throws CommandSyntaxException;
}