package minevalley.core.api.smart;

import minevalley.core.api.users.User;

public interface AppSession {

    User getUser();

    void end();

    void onEnd(Runnable runnable);
}
