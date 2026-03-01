package minevalley.core.api.corporation.company;

import minevalley.core.api.corporation.Group;
import minevalley.core.api.user.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface Personengesellschaft extends Group {

    /**
     * Gets the owner of this Personengesellschaft.
     *
     * @return the owner user
     */
    @Nonnull
    @Contract(pure = true)
    User getOwner();

    /**
     * Gets the co-owners of this Personengesellschaft.
     *
     * @return the list of co-owner users
     */
    @Nonnull
    @Contract(pure = true)
    List<User> getCoOwners();
}
