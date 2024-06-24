package minevalley.core.api.corporations.companies;

import minevalley.core.api.corporations.Group;
import minevalley.core.api.users.User;

import java.util.List;

public interface Personengesellschaft extends Group {

    User getOwner();

    List<User> getCoOwners();
}
