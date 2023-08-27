package minevalley.core.api.corporations.business;

import minevalley.core.api.users.User;
import minevalley.core.api.corporations.Group;

public interface Einzelunternehmen extends Group {

    User getOwner();
}
