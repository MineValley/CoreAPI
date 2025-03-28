package minevalley.core.api.corporations.companies;

import minevalley.core.api.corporations.Group;
import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface Personengesellschaft extends Group {

    @Nonnull
    @Contract(pure = true)
    User getOwner();

    @Nonnull
    @Contract(pure = true)
    List<User> getCoOwners();
}
