package eu.minevalley.core.api.corporation.company;

import eu.minevalley.core.api.corporation.Group;
import eu.minevalley.core.api.user.User;
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
