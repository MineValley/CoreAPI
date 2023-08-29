package minevalley.core.api.users;

import java.util.List;

public interface Marriage {

    List<User> getUsers();

    void add(User user);

    void leave(User user);

    long since();
}
