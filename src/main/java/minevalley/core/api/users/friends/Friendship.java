package minevalley.core.api.users.friends;

import minevalley.core.api.users.User;

public interface Friendship {

    User getFriend1();

    User getFriend2();

    long since();

    void exit();
}
