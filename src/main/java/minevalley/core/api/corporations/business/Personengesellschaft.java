package minevalley.core.api.corporations.business;

import minevalley.core.api.User;
import minevalley.core.api.corporations.Group;

import java.util.List;

public interface Personengesellschaft extends Group {

    User getOwner();

    List<User> getCoOwners();
}
