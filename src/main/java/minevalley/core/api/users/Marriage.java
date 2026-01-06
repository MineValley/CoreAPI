package minevalley.core.api.users;

import java.util.Set;

@SuppressWarnings("unused")
public interface Marriage {

    Set<User> getUsers();

    void add(User user);

    void leave(User user);

    long since();
}
