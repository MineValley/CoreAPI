package minevalley.core.api.corporations.companies;

import minevalley.core.api.corporations.Group;
import minevalley.core.api.users.User;

public interface Einzelunternehmen extends Group {

    User getOwner();
}
