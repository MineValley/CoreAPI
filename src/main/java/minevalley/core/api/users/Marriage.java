package minevalley.core.api.users;

import java.util.List;

@SuppressWarnings("unused")
public interface Marriage {

    List<User> getUsers();

    void add(User user);

    void leave(User user);

    long since();
}
