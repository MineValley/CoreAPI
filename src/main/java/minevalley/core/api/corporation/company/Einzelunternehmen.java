package minevalley.core.api.corporation.company;

import minevalley.core.api.corporation.Group;
import minevalley.core.api.registrant.User;
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
