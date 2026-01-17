package minevalley.core.api.corporations.companies;

import minevalley.core.api.corporations.Group;
import minevalley.core.api.users.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Einzelunternehmen extends Group {

    /**
     * Gets the owner of this Einzelunternehmen.
     *
     * @return the owner
     */
    @Nonnull
    @Contract(pure = true)
    User getOwner();
}
