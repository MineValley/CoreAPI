package minevalley.core.api.corporations.companies;

import minevalley.core.api.corporations.Group;
import minevalley.core.api.users.User;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Einzelunternehmen extends Group {

    @Nonnull
    User getOwner();
}
